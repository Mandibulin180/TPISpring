package com.TPI2Spring.GameDevTaskManager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TPI2Spring.GameDevTaskManager.domain.Juego;
import com.TPI2Spring.GameDevTaskManager.exceptions.NotFoundException;
import com.TPI2Spring.GameDevTaskManager.model.dto.juego.JuegoDTO;
import com.TPI2Spring.GameDevTaskManager.model.dto.juego.JuegoResponseDTO;
import com.TPI2Spring.GameDevTaskManager.service.juego.JuegoService;

@RestController
@RequestMapping("/api/v1/juego")
public class JuegoController {

    JuegoService juegoService;

    @Autowired
    public JuegoController(JuegoService juegoService){
        this.juegoService = juegoService;
    }

    @PostMapping()
    public ResponseEntity createJuego(@RequestBody JuegoDTO juegoDto) throws NotFoundException{
        Juego juego = juegoService.createJuego(juegoDto);
        
        HttpHeaders headers = new HttpHeaders();
        headers.add("Estado del juego","Creado!");

        return new ResponseEntity<>(headers,HttpStatus.CREATED);
    }

    @GetMapping()
    public List<JuegoResponseDTO> getAllJuegos(){
        return juegoService.getAllJuegos();
    }  
}
