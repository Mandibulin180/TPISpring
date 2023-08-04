package com.TPI2Spring.GameDevTaskManager.mapper.juego.JuegoResponseMapper;

import com.TPI2Spring.GameDevTaskManager.domain.Juego;
import com.TPI2Spring.GameDevTaskManager.model.dto.juego.JuegoResponseDTO;

public interface JuegoResponseMapper {
    JuegoResponseDTO juegoToJuegoResponseDTO(Juego juego);
}
