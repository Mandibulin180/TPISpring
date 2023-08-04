package com.TPI2Spring.GameDevTaskManager.mapper.desarrollador.desarrolladorResponseMapper;

import com.TPI2Spring.GameDevTaskManager.domain.Desarrollador;
import com.TPI2Spring.GameDevTaskManager.model.dto.desarrollador.DesarrolladorResponseDTO;

public interface DesarrolladorResponseMapper {
    
    DesarrolladorResponseDTO desarrolladorToDesarrolladorResponseDTO(Desarrollador desarrollador);
    Desarrollador desarrolladorResponseDtoToDesarollador(DesarrolladorResponseDTO desarrollador);
}
