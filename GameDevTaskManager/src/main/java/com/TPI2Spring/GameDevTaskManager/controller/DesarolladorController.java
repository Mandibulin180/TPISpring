package com.TPI2Spring.GameDevTaskManager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TPI2Spring.GameDevTaskManager.domain.Desarrollador;
import com.TPI2Spring.GameDevTaskManager.exceptions.NotFoundException;
import com.TPI2Spring.GameDevTaskManager.model.dto.desarrollador.DesarrolladorDTO;
import com.TPI2Spring.GameDevTaskManager.service.desarrollador.DesarrolladorService;

@RestController
@RequestMapping("/api/v1/desarrollador")
public class DesarolladorController {
    
    DesarrolladorService desarrolladorService;

    @Autowired
    public DesarolladorController(DesarrolladorService desarrolladorService){
        this.desarrolladorService = desarrolladorService;
    }

    @PostMapping()
    public ResponseEntity createDesarrollador(@RequestBody DesarrolladorDTO desarrolladorDTO)throws NotFoundException {
        Desarrollador desarrollador = desarrolladorService.createDesarrollador(desarrolladorDTO);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Estado", "Creado!");

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

}
