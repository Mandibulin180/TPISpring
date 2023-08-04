package com.TPI2Spring.GameDevTaskManager.mapper.tarea.TareaMapper.Impl;

import org.springframework.stereotype.Component;
import com.TPI2Spring.GameDevTaskManager.domain.Tarea;
import com.TPI2Spring.GameDevTaskManager.mapper.tarea.TareaMapper.TareaMapper;
import com.TPI2Spring.GameDevTaskManager.model.dto.tarea.TareaDTO;

@Component
public class TareaMapperImpl implements TareaMapper {

    @Override
    public Tarea tareaDtoToTarea(TareaDTO tareaDto){
        return Tarea.builder()
        .descripcion(tareaDto.getDescripcion())
        .fechaLimite(tareaDto.getFechaLimite())
        .build();
    }

    @Override
    public TareaDTO tareaToTareaDto(Tarea tarea){
        return TareaDTO.builder()
        .descripcion(tarea.getDescripcion())
        .desarrolladorResponsableId(tarea.getDesarrolladorResponsable().getId().toString())
        .juegoDeLaTareaId(tarea.getJuegoDeLaTarea().getId().toString())
        .fechaLimite(tarea.getFechaLimite())
        .estado(tarea.getEstado())
        .build();
    }
}
