package com.TPI2Spring.GameDevTaskManager.service.desarrollador.Impl;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.TPI2Spring.GameDevTaskManager.domain.Desarrollador;
import com.TPI2Spring.GameDevTaskManager.domain.Juego;
import com.TPI2Spring.GameDevTaskManager.exceptions.NotFoundException;
import com.TPI2Spring.GameDevTaskManager.mapper.desarrollador.DesarrolladorMapper;
import com.TPI2Spring.GameDevTaskManager.model.dto.desarrollador.DesarrolladorDTO;
import com.TPI2Spring.GameDevTaskManager.repository.DesarroladorRepository;
import com.TPI2Spring.GameDevTaskManager.repository.JuegoRepository;
import com.TPI2Spring.GameDevTaskManager.service.desarrollador.DesarrolladorService;
import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class DesarrolladorServiceImpl implements DesarrolladorService {

    private final DesarrolladorMapper desarrolladorMapper;
    private final DesarroladorRepository desarroladorRepository;
    private final JuegoRepository juegoRepository;


    @Override
    public Desarrollador createDesarrollador(DesarrolladorDTO desarrollador)throws NotFoundException{
        Desarrollador newDesarrollador = desarrolladorMapper.desarrolladorDtoToDesarrollador(desarrollador);

        Optional<Juego> optionalJuego = juegoRepository.findById(UUID.fromString(desarrollador.getJuegoAsignadoid()));

        if(optionalJuego.isPresent()){
            newDesarrollador.setJuegoAsignado(optionalJuego.get());
        } else {
            throw new NotFoundException();
        }

        return desarroladorRepository.save(newDesarrollador);
    }
    
}
