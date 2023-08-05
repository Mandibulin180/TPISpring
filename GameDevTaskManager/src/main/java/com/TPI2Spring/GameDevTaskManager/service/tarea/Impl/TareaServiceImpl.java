package com.TPI2Spring.GameDevTaskManager.service.tarea.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;
import com.TPI2Spring.GameDevTaskManager.exceptions.NotFoundException;
import com.TPI2Spring.GameDevTaskManager.domain.Desarrollador;
import com.TPI2Spring.GameDevTaskManager.domain.Estado;
import com.TPI2Spring.GameDevTaskManager.domain.Juego;
import com.TPI2Spring.GameDevTaskManager.domain.Tarea;
import com.TPI2Spring.GameDevTaskManager.mapper.tarea.TareaMapper.TareaMapper;
import com.TPI2Spring.GameDevTaskManager.mapper.tarea.TareaResponseMapper.TareaResponseMapper;
import com.TPI2Spring.GameDevTaskManager.model.dto.tarea.TareaDTO;
import com.TPI2Spring.GameDevTaskManager.model.dto.tarea.TareaResponseDTO;
import com.TPI2Spring.GameDevTaskManager.model.dto.tarea.TareaUpdateDTO;
import com.TPI2Spring.GameDevTaskManager.repository.DesarroladorRepository;
import com.TPI2Spring.GameDevTaskManager.repository.JuegoRepository;
import com.TPI2Spring.GameDevTaskManager.repository.TareaRepository;
import com.TPI2Spring.GameDevTaskManager.service.tarea.TareaService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TareaServiceImpl implements TareaService {

    final TareaMapper tareaMapper;
    final JuegoRepository juegoRepository;
    final DesarroladorRepository desarroladorRepository;
    final TareaRepository tareaRepository;
    final TareaResponseMapper tareaResponseMapper;
    
    @Override
    public Tarea createTarea(TareaDTO tareaDTO)throws NotFoundException{
        Tarea tarea = tareaMapper.tareaDtoToTarea(tareaDTO);
        
        Optional<Juego> juego = juegoRepository.findById(UUID.fromString(tareaDTO.getJuegoDeLaTareaId()));
        Optional<Desarrollador> desarrollador = desarroladorRepository.findById(UUID.fromString(tareaDTO.getDesarrolladorResponsableId()));
        if(desarrollador.get().getJuegoAsignado() == null){
            desarrollador.get().setJuegoAsignado(juego.get());
        }
        tarea.setEstado(Estado.PENDIENTE);
        if(juego.isPresent() && desarrollador.isPresent()){
            tarea.setJuegoDeLaTarea(juego.get());
            tarea.setDesarrolladorResponsable(desarrollador.get());
        } else{
            throw new NotFoundException();
        }

        return tareaRepository.save(tarea);
    }

    @Override
    public List<TareaResponseDTO> getTareasDesarrollador(UUID idDesarrollador)throws NotFoundException{
        Optional<Desarrollador> desarrolladorOptional = desarroladorRepository.findById(idDesarrollador);
        List<TareaResponseDTO> tareasResposeDTO = new ArrayList<>();

        if(desarrolladorOptional.isPresent()){
            for(Tarea tarea: desarrolladorOptional.get().getTarea()){
                tareasResposeDTO.add(tareaResponseMapper.tareaToTareaResponseDTO(tarea));
            }
        }else {
            throw new NotFoundException("desarrollador no encontrado");
        }

        return tareasResposeDTO;
    }

    @Override
    public Optional<Tarea> updateTarea(UUID idTarea,TareaUpdateDTO tareaDTO){
        
        Optional<Tarea> tareaOptional = tareaRepository.findById(idTarea);

        if(tareaOptional.isPresent()){
            updatingTarea(tareaOptional.get(),tareaDTO); 
            return Optional.of(tareaRepository.save(tareaOptional.get()));
        }
        
        return Optional.empty();
    }

    private void updatingTarea(Tarea tarea,TareaUpdateDTO tareaDto){
        if(tareaDto.getDescripcion() != null){
            tarea.setDescripcion(tareaDto.getDescripcion());
        }
        if(tareaDto.getEstado() != null){
            tarea.setEstado(tareaDto.getEstado());
        }
        if(tareaDto.getFechaLimite() != null){
            tarea.setDescripcion(tareaDto.getDescripcion());
        }
        if(tareaDto.getDesarrolladorResponsableId() != null){
            tarea.setDesarrolladorResponsable(desarroladorRepository.findById(UUID.fromString(tareaDto.getDesarrolladorResponsableId())).get());
        }
        if(tareaDto.getJuegoDeLaTareaId() != null){
            tarea.setJuegoDeLaTarea(juegoRepository.findById(UUID.fromString(tareaDto.getJuegoDeLaTareaId())).get());
        }
    }

    @Override
    public List<TareaDTO> searchTareaPorEstadoOFechaLimite(Estado estado,Date fechaLimite){
        Optional<List<Tarea>> tareas = tareaRepository.findTareaByEstadoOrFechaLimite(estado, fechaLimite);
        List<TareaDTO> listaDeTareas = new ArrayList<>();
        List<TareaDTO> listaDeTareasVencidas = new ArrayList<>();
        Date fechaActual = new Date();
        for(Tarea tarea:tareas.get()){
            listaDeTareas.add(tareaMapper.tareaToTareaDto(tarea));  
        }

        if((estado!=null&&estado != Estado.COMPLETADA) && (fechaLimite!=null&&fechaLimite.before(fechaActual))){
            for(TareaDTO tarea: listaDeTareas){
                if(tarea.getEstado() != Estado.COMPLETADA){
                    listaDeTareasVencidas.add(tarea);
                }
            }
            return listaDeTareasVencidas;
        }

        return listaDeTareas;
    }

    @Override
    public List<TareaResponseDTO> searchTareasPorJuego(UUID idJuego){
        Optional<List<Tarea>> tareas = tareaRepository.findByJuegoDeLaTareaId(idJuego);
        List<TareaResponseDTO> listaDeTareas = new ArrayList<>();
        for(Tarea tarea:tareas.get()){
            listaDeTareas.add(tareaResponseMapper.tareaToTareaResponseDTO(tarea));
        }

        return listaDeTareas;
    }
}
