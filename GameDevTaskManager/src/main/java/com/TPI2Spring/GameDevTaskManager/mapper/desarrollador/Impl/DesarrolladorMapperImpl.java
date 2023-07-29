package com.TPI2Spring.GameDevTaskManager.mapper.desarrollador.Impl;

import org.springframework.stereotype.Component;
import com.TPI2Spring.GameDevTaskManager.domain.Desarrollador;
import com.TPI2Spring.GameDevTaskManager.mapper.desarrollador.DesarrolladorMapper;
import com.TPI2Spring.GameDevTaskManager.model.dto.desarrollador.DesarrolladorDTO;

@Component
public class DesarrolladorMapperImpl implements DesarrolladorMapper {

    @Override
    public Desarrollador desarrolladorDtoToDesarrollador(DesarrolladorDTO desarrollador){
        return Desarrollador.builder()
        .nombre(desarrollador.getNombre())
        .correoElectronico(desarrollador.getCorreoElectronico())
        .rol(desarrollador.getRol())
        .build();
    }

    @Override
    public DesarrolladorDTO desarrolladorToDessDesarrolladorDTO(Desarrollador desarrollador){
        return DesarrolladorDTO.builder()
        .nombre(desarrollador.getNombre())
        .correoElectronico(desarrollador.getCorreoElectronico())
        .rol(desarrollador.getRol())
        .juegoAsignadoid(desarrollador.getJuegoAsignado().getId().toString())
        .build();
    }
    
}
