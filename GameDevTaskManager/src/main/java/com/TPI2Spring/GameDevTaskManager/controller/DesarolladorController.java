package com.TPI2Spring.GameDevTaskManager.controller;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TPI2Spring.GameDevTaskManager.domain.Desarrollador;
import com.TPI2Spring.GameDevTaskManager.exceptions.NotFoundException;
import com.TPI2Spring.GameDevTaskManager.mapper.desarrollador.DesarrolladorMapper;
import com.TPI2Spring.GameDevTaskManager.mapper.desarrollador.Impl.DesarrolladorMapperImpl;
import com.TPI2Spring.GameDevTaskManager.model.dto.desarrollador.DesarrolladorDTO;
import com.TPI2Spring.GameDevTaskManager.model.dto.desarrollador.DesarrolladorResponseDTO;
import com.TPI2Spring.GameDevTaskManager.service.desarrollador.DesarrolladorService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping("/api/v1/desarrollador")
public class DesarolladorController {
    
    DesarrolladorService desarrolladorService;

    @Autowired
    public DesarolladorController(DesarrolladorService desarrolladorService){
        this.desarrolladorService = desarrolladorService;
    }

    @PostMapping()
    public ResponseEntity createDesarrollador(@RequestBody DesarrolladorResponseDTO desarrolladorDTO)throws NotFoundException {
        Desarrollador desarrollador = desarrolladorService.createDesarrollador(desarrolladorDTO);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Estado", "Creado!");

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{idDesarrollador}")
    public ResponseEntity updateDesarrollador(@PathVariable(value = "idDesarrollador")UUID idDesarrollador,@RequestBody DesarrolladorDTO desarrolladorDTO){
        Optional<Desarrollador> desarrolladorOptional = desarrolladorService.updateDesarrollador(idDesarrollador, desarrolladorDTO);
        DesarrolladorMapper desarrolladorMapper = new DesarrolladorMapperImpl();
        DesarrolladorDTO finalDesarrollador =  desarrolladorMapper.desarrolladorToDessDesarrolladorDTO(desarrolladorOptional.get());
        if(desarrolladorOptional.isEmpty()){
            return new ResponseEntity<>("desarrollador no encontrado",HttpStatus.NOT_FOUND);
        } else{
            return new ResponseEntity<>(finalDesarrollador,HttpStatus.CREATED);
        }
    }

}
