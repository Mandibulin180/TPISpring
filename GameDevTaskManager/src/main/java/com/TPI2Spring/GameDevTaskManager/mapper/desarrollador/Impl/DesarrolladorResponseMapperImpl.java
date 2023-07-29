package com.TPI2Spring.GameDevTaskManager.mapper.desarrollador.Impl;

import org.springframework.stereotype.Component;

import com.TPI2Spring.GameDevTaskManager.domain.Desarrollador;
import com.TPI2Spring.GameDevTaskManager.mapper.desarrollador.DesarrolladorResponseMapper;
import com.TPI2Spring.GameDevTaskManager.model.dto.desarrollador.DesarrolladorResponseDTO;

@Component
public class DesarrolladorResponseMapperImpl implements DesarrolladorResponseMapper {

    @Override
    public DesarrolladorResponseDTO desarrolladorToDesarrolladorResponseDTO(Desarrollador desarrollador){
        return DesarrolladorResponseDTO.builder()
        .nombre(desarrollador.getNombre())
        .correoElectronico(desarrollador.getCorreoElectronico())
        .rol(desarrollador.getRol())
        .build();
    }
    
}
