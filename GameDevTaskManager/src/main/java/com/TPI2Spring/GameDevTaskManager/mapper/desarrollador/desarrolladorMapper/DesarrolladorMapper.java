package com.TPI2Spring.GameDevTaskManager.mapper.desarrollador.desarrolladorMapper;

import com.TPI2Spring.GameDevTaskManager.domain.Desarrollador;
import com.TPI2Spring.GameDevTaskManager.model.dto.desarrollador.DesarrolladorDTO;

public interface DesarrolladorMapper {
    Desarrollador desarrolladorDtoToDesarrollador(DesarrolladorDTO desarrollador);

    DesarrolladorDTO desarrolladorToDessDesarrolladorDTO(Desarrollador desarrollador);
}
