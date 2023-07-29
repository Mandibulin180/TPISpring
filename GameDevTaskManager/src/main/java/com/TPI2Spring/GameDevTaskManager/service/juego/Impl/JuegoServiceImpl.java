package com.TPI2Spring.GameDevTaskManager.service.juego.Impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.TPI2Spring.GameDevTaskManager.domain.Juego;
import com.TPI2Spring.GameDevTaskManager.mapper.juego.JuegoMapper;
import com.TPI2Spring.GameDevTaskManager.mapper.juego.JuegoResponseMapper;
import com.TPI2Spring.GameDevTaskManager.model.dto.juego.JuegoDTO;
import com.TPI2Spring.GameDevTaskManager.model.dto.juego.JuegoResponseDTO;
import com.TPI2Spring.GameDevTaskManager.repository.JuegoRepository;
import com.TPI2Spring.GameDevTaskManager.service.juego.JuegoService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class JuegoServiceImpl implements JuegoService {

    final JuegoMapper juegoMapper;
    final JuegoRepository juegoRepository;
    final JuegoResponseMapper juegoResponseMapper;
    
    @Override
    public Juego createJuego(JuegoDTO juego){
        return juegoRepository.save(juegoMapper.juegoDtoToJuego(juego));
    }

    @Override
    public List<JuegoResponseDTO> getAllJuegos(){
        List<JuegoResponseDTO> juegosDtos = new ArrayList<>();

        for(Juego juego:juegoRepository.findAll()){
            juegosDtos.add(juegoResponseMapper.juegoToJuegoResponseDTO(juego));
        }
        return juegosDtos;
    }
}
