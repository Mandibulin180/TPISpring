package com.TPI2Spring.GameDevTaskManager.mapper.juego.Impl;

import org.springframework.stereotype.Component;
import com.TPI2Spring.GameDevTaskManager.domain.Juego;
import com.TPI2Spring.GameDevTaskManager.mapper.juego.JuegoMapper;
import com.TPI2Spring.GameDevTaskManager.model.dto.juego.JuegoDTO;

@Component
public class JuegoMapperImpl implements JuegoMapper {

    @Override
    public Juego juegoDtoToJuego(JuegoDTO juego) {
        return Juego.builder()
        .titulo(juego.getTitulo())
        .descripción(juego.getDescripcion())
        .fechaDeLanzamiento(juego.getFechaDeLanzamiento())
        .build();
    }

    @Override
    public JuegoDTO juegoToJuegoDto(Juego juego) {
        return JuegoDTO.builder()
        .titulo(juego.getTitulo())
        .descripcion(juego.getDescripción())
        .fechaDeLanzamiento(juego.getFechaDeLanzamiento())
        .desarrolladores(juego.getDesarrolladores())
        .build();
    }
    
}
