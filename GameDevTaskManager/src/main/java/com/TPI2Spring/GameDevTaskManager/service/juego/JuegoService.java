package com.TPI2Spring.GameDevTaskManager.service.juego;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.TPI2Spring.GameDevTaskManager.domain.Juego;
import com.TPI2Spring.GameDevTaskManager.model.dto.juego.JuegoDTO;
import com.TPI2Spring.GameDevTaskManager.model.dto.juego.JuegoResponseDTO;

public interface JuegoService {
    
    Juego createJuego(JuegoDTO juego);
    List<JuegoResponseDTO> getAllJuegos();
    Optional<JuegoResponseDTO> getJuego(UUID idJuego);
}
