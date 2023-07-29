package com.TPI2Spring.GameDevTaskManager.mapper.juego;


import com.TPI2Spring.GameDevTaskManager.domain.Juego;
import com.TPI2Spring.GameDevTaskManager.model.dto.juego.JuegoDTO;

public interface JuegoMapper {
    Juego juegoDtoToJuego(JuegoDTO juego);

    JuegoDTO juegoToJuegoDto(Juego juego);

}
