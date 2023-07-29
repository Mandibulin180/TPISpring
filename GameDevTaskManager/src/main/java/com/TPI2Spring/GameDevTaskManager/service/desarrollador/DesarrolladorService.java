package com.TPI2Spring.GameDevTaskManager.service.desarrollador;


import com.TPI2Spring.GameDevTaskManager.domain.Desarrollador;
import com.TPI2Spring.GameDevTaskManager.exceptions.NotFoundException;
import com.TPI2Spring.GameDevTaskManager.model.dto.desarrollador.DesarrolladorDTO;

public interface DesarrolladorService {
    Desarrollador createDesarrollador(DesarrolladorDTO desarrollador)throws NotFoundException;
    
}
