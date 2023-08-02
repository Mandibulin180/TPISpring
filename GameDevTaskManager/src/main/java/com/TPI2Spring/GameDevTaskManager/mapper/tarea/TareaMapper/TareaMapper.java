package com.TPI2Spring.GameDevTaskManager.mapper.tarea.TareaMapper;

import com.TPI2Spring.GameDevTaskManager.domain.Tarea;
import com.TPI2Spring.GameDevTaskManager.model.dto.tarea.TareaDTO;

public interface TareaMapper {
    
    Tarea tareaDtoToTarea(TareaDTO tareaDto);
    TareaDTO tareaToTareaDto(Tarea tarea);
}
