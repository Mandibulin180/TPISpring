package com.TPI2Spring.GameDevTaskManager.service.tarea;


import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.TPI2Spring.GameDevTaskManager.domain.Estado;
import com.TPI2Spring.GameDevTaskManager.domain.Tarea;
import com.TPI2Spring.GameDevTaskManager.exceptions.NotFoundException;
import com.TPI2Spring.GameDevTaskManager.model.dto.tarea.TareaDTO;
import com.TPI2Spring.GameDevTaskManager.model.dto.tarea.TareaResponseDTO;
import com.TPI2Spring.GameDevTaskManager.model.dto.tarea.TareaUpdateDTO;

public interface TareaService {
    Tarea createTarea(TareaDTO tareaDTO)throws NotFoundException;
    List<TareaResponseDTO> getTareasDesarrollador(UUID idDesarrollador)throws NotFoundException;
    Optional<Tarea> updateTarea(UUID idTarea,TareaUpdateDTO tareaDTO);
    List<TareaDTO> searchTareaPorEstadoOFechaLimite(Estado estado,Date fechaLimite);
    List<TareaResponseDTO> searchTareasPorJuego(UUID idJuego);
}
