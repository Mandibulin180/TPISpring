package com.TPI2Spring.GameDevTaskManager.mapper.tarea.TareaResponseMapper.Impl;

import org.springframework.stereotype.Component;
import com.TPI2Spring.GameDevTaskManager.domain.Tarea;
import com.TPI2Spring.GameDevTaskManager.mapper.tarea.TareaResponseMapper.TareaResponseMapper;
import com.TPI2Spring.GameDevTaskManager.model.dto.tarea.TareaResponseDTO;

@Component
public class TareaResponseMapperImpl implements TareaResponseMapper {

    @Override
    public TareaResponseDTO tareaToTareaResponseDTO(Tarea tarea){
        return TareaResponseDTO.builder()
        .descripcion(tarea.getDescripcion())
        .estado(tarea.getEstado())
        .fechaLimite(tarea.getFechaLimite())
        .build();
    }
    
}
