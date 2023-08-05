package com.TPI2Spring.GameDevTaskManager.service.juego.Impl;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;
import com.TPI2Spring.GameDevTaskManager.domain.Juego;
import com.TPI2Spring.GameDevTaskManager.mapper.juego.JuegoResponseMapper.JuegoResponseMapper;
import com.TPI2Spring.GameDevTaskManager.model.dto.juego.JuegoDTO;
import com.TPI2Spring.GameDevTaskManager.model.dto.juego.JuegoResponseDTO;
import com.TPI2Spring.GameDevTaskManager.repository.JuegoRepository;
import com.TPI2Spring.GameDevTaskManager.service.juego.JuegoService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class JuegoServiceImpl implements JuegoService {

    final com.TPI2Spring.GameDevTaskManager.mapper.juego.JuegoMapper.JuegoMapper juegoMapper;
    final JuegoRepository juegoRepository;
    final JuegoResponseMapper juegoResponseMapper;
    
    @Override
    public Juego createJuego(JuegoDTO juego){
        return juegoRepository.save(juegoMapper.juegoDtoToJuego(juego));
    }

    @Override
    public List<JuegoResponseDTO> getAllJuegos(){
        List<JuegoResponseDTO> juegosDtos = new ArrayList<>();

        for(Juego juego:juegoRepository.findAll()){
            juegosDtos.add(juegoResponseMapper.juegoToJuegoResponseDTO(juego));
        }
        return juegosDtos;
    }

    @Override
    public Optional<JuegoResponseDTO> getJuego(UUID idJuego){
        Optional<Juego> juegoOptional = juegoRepository.findById(idJuego);

        if(juegoOptional.isPresent()){
            return Optional.of(juegoResponseMapper.juegoToJuegoResponseDTO(juegoOptional.get()));
        }

        return Optional.empty();
    }

    @Override
    public List<JuegoResponseDTO> getJuegosFinalizados(String estado){
        List<JuegoResponseDTO> juegosFinalizados = new ArrayList<>();
        List<JuegoResponseDTO> juegosEnDesarrollor = new ArrayList<>();

        listarEstados(juegosFinalizados, juegosEnDesarrollor);

        if(estado.equalsIgnoreCase("finalizado")){
            return juegosFinalizados;
        }if(estado.equalsIgnoreCase("pendiente")){
            return juegosEnDesarrollor;
        }

        return null;
    }

    private void listarEstados(List<JuegoResponseDTO> juegosFinalizados,List<JuegoResponseDTO> juegosEnDesarrollo){
        Date fechaActual = new Date();
        for (Juego juego: juegoRepository.findAll()){
            Date fechajuego = new Date(juego.getFechaDeLanzamiento().getTime());
            if(fechajuego.before(fechaActual)){
                juegosFinalizados.add(juegoResponseMapper.juegoToJuegoResponseDTO(juego));
            }else{
                juegosEnDesarrollo.add(juegoResponseMapper.juegoToJuegoResponseDTO(juego));
                }
        }
    }

}
