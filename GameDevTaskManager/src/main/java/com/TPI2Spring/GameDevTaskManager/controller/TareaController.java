package com.TPI2Spring.GameDevTaskManager.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.TPI2Spring.GameDevTaskManager.domain.Estado;
import com.TPI2Spring.GameDevTaskManager.domain.Tarea;
import com.TPI2Spring.GameDevTaskManager.exceptions.NotFoundException;
import com.TPI2Spring.GameDevTaskManager.model.dto.tarea.TareaDTO;
import com.TPI2Spring.GameDevTaskManager.model.dto.tarea.TareaResponseDTO;
import com.TPI2Spring.GameDevTaskManager.service.tarea.TareaService;

import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/api/v1/tarea")
@Slf4j
public class TareaController {
    
    TareaService tareaService;

    @Autowired
    public TareaController(TareaService tareaService){
        this.tareaService = tareaService;
    }

    @PostMapping()
    public ResponseEntity createTarea(@RequestBody TareaDTO tareaDTO)throws NotFoundException{
        tareaService.createTarea(tareaDTO);

        return new ResponseEntity<>("Tarea Creada!",HttpStatus.CREATED);
    }

    @GetMapping("/{idDesarrollador}")
    public ResponseEntity getTareasDesarollador(@PathVariable(value = "idDesarrollador")UUID idDesarrollador)throws NotFoundException{
        List<TareaResponseDTO> tareas = tareaService.getTareasDesarrollador(idDesarrollador);
        return new ResponseEntity<>(tareas,HttpStatus.OK);
    } 

    @PutMapping("/{idTarea}")
    public ResponseEntity updateTarea(@PathVariable(value = "idTarea")UUID idTarea,@RequestBody TareaDTO tareaDto){
        Optional<Tarea> tareaOptional = tareaService.updateTarea(idTarea, tareaDto);
        if(tareaOptional.isEmpty()){
            return new ResponseEntity<>("Tarea no encontrada",HttpStatus.NOT_FOUND); 
        } else{
            return new ResponseEntity<>("Tarea Actualizada",HttpStatus.CREATED);
        }
    }

    @GetMapping()
    public ResponseEntity getTareaByEstadoOrFechaLimite(@RequestParam(required = false)Estado estado,@RequestParam(required = false)@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaLimite){
        List<TareaDTO> listaDeTareas = tareaService.searchTareaPorEstadoOFechaLimite(estado, fechaLimite);
        List<TareaDTO> listaDeTareasVencidas = new ArrayList<>();
        
        if(estado == null && fechaLimite == null){
            return new ResponseEntity<>("Debes ingresar ya sea un estado o una fecha limite",HttpStatus.BAD_REQUEST);
        }
        Date fechaActual = new Date();
        if((estado!=null&&estado != Estado.COMPLETADA) && (fechaLimite!=null&&fechaLimite.before(fechaActual))){
            for(TareaDTO tarea: listaDeTareas){
                if(tarea.getEstado() != Estado.COMPLETADA){
                    listaDeTareasVencidas.add(tarea);
                }
            }
            return new ResponseEntity<>(listaDeTareasVencidas,HttpStatus.OK);
        }

        return new ResponseEntity<>(listaDeTareas,HttpStatus.OK);
    }

    @GetMapping("/tareasDeJuego/{idJuego}")
    public ResponseEntity getTareaByJuego(@PathVariable(value = "idJuego")UUID idJuego){
        List<TareaResponseDTO> listaDeTareas = tareaService.searchTareasPorJuego(idJuego);

        if(listaDeTareas.isEmpty()){
            return new ResponseEntity<>("Juego no encontrado o no posee tareas",HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(listaDeTareas,HttpStatus.OK);
        }

        
    }
}
