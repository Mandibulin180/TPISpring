package com.TPI2Spring.GameDevTaskManager.mapper.juego.JuegoResponseMapper.Impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import com.TPI2Spring.GameDevTaskManager.domain.Desarrollador;
import com.TPI2Spring.GameDevTaskManager.domain.Juego;
import com.TPI2Spring.GameDevTaskManager.mapper.desarrollador.desarrolladorResponseMapper.DesarrolladorResponseMapper;
import com.TPI2Spring.GameDevTaskManager.mapper.juego.JuegoResponseMapper.JuegoResponseMapper;
import com.TPI2Spring.GameDevTaskManager.model.dto.desarrollador.DesarrolladorResponseDTO;
import com.TPI2Spring.GameDevTaskManager.model.dto.juego.JuegoResponseDTO;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class JuegoResponseMapperImpl implements JuegoResponseMapper {
    
    private final DesarrolladorResponseMapper desarrolladorResponseMapper;

    @Override
    public JuegoResponseDTO juegoToJuegoResponseDTO(Juego juego){
        JuegoResponseDTO juegoResponseDTO = JuegoResponseDTO.builder()
        .titulo(juego.getTitulo())
        .descripcion(juego.getDescripción())
        .fechaDeLanzamiento(juego.getFechaDeLanzamiento())
        .build();

        List<DesarrolladorResponseDTO> desarrolladorResponseDTOs = new ArrayList<>();

        for (Desarrollador desarrollador: juego.getDesarrolladores()){
            desarrolladorResponseDTOs.add(desarrolladorResponseMapper.desarrolladorToDesarrolladorResponseDTO(desarrollador));
        }
        juegoResponseDTO.setDesarrolladores(desarrolladorResponseDTOs); 

        return juegoResponseDTO;
    }
}
