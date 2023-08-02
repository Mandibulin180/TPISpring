package com.TPI2Spring.GameDevTaskManager.mapper.tarea.TareaResponseMapper;

import com.TPI2Spring.GameDevTaskManager.domain.Tarea;
import com.TPI2Spring.GameDevTaskManager.model.dto.tarea.TareaResponseDTO;

public interface TareaResponseMapper {

    TareaResponseDTO tareaToTareaResponseDTO(Tarea tarea);
    
}
