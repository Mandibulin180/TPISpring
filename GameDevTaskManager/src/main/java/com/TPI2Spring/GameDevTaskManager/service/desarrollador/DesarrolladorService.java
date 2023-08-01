package com.TPI2Spring.GameDevTaskManager.service.desarrollador;


import java.util.Optional;
import java.util.UUID;

import com.TPI2Spring.GameDevTaskManager.domain.Desarrollador;
import com.TPI2Spring.GameDevTaskManager.exceptions.NotFoundException;
import com.TPI2Spring.GameDevTaskManager.model.dto.desarrollador.DesarrolladorDTO;
import com.TPI2Spring.GameDevTaskManager.model.dto.desarrollador.DesarrolladorResponseDTO;

public interface DesarrolladorService {
    Desarrollador createDesarrollador(DesarrolladorDTO desarrollador)throws NotFoundException;
    Desarrollador createDesarrollador(DesarrolladorResponseDTO desarrollador);
    Optional<Desarrollador> updateDesarrollador(UUID idDesarrollador,DesarrolladorDTO desarrollador);
    
}
