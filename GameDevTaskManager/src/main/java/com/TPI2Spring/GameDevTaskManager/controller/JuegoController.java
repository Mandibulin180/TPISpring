package com.TPI2Spring.GameDevTaskManager.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.TPI2Spring.GameDevTaskManager.domain.Juego;
import com.TPI2Spring.GameDevTaskManager.exceptions.NotFoundException;
import com.TPI2Spring.GameDevTaskManager.model.dto.desarrollador.DesarrolladorResponseDTO;
import com.TPI2Spring.GameDevTaskManager.model.dto.juego.JuegoDTO;
import com.TPI2Spring.GameDevTaskManager.model.dto.juego.JuegoResponseDTO;
import com.TPI2Spring.GameDevTaskManager.service.juego.JuegoService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/juego")
@Slf4j
public class JuegoController {

    JuegoService juegoService;

    @Autowired
    public JuegoController(JuegoService juegoService){
        this.juegoService = juegoService;
    }

    @PostMapping()
    public ResponseEntity createJuego(@RequestBody JuegoDTO juegoDto) throws NotFoundException{
        juegoService.createJuego(juegoDto);
        
        HttpHeaders headers = new HttpHeaders();
        headers.add("Estado del juego","Creado!");

        return new ResponseEntity<>(headers,HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity getJuegoByEstado(@RequestParam(required = false,defaultValue = "") String estado){
        List<JuegoResponseDTO> juegosEnDesarrollo = new ArrayList<>();
        List<JuegoResponseDTO> juegosFinalizados = new ArrayList<>();

        if(estado.toLowerCase().equals("finalizado")){
            listarEstados(juegosFinalizados, juegosEnDesarrollo);
            return new ResponseEntity<>(juegosFinalizados,HttpStatus.OK);
        }if(estado.equals("")){
            listarEstados(juegosFinalizados, juegosEnDesarrollo);
            return new ResponseEntity<>(juegosEnDesarrollo,HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Estado ingresado incorrecto",HttpStatus.NOT_FOUND);
        }
    }

    private void listarEstados(List<JuegoResponseDTO> juegosFinalizados,List<JuegoResponseDTO> juegosEnDesarrollo){
        Date fechaActual = new Date();
        for (JuegoResponseDTO juego: juegoService.getAllJuegos()){
            Date fechajuego = new Date(juego.getFechaDeLanzamiento().getTime());
            if(fechajuego.before(fechaActual)){
                juegosFinalizados.add(juego);
            }else{
                juegosEnDesarrollo.add(juego);
                }
        }
    }

    @GetMapping("/{idJuego}")
    public ResponseEntity getDatosDesarrollador(@PathVariable(value = "idJuego")UUID idjuego)throws NotFoundException{
        JuegoResponseDTO juegoResponseDTO = juegoService.getJuego(idjuego).orElseThrow(NotFoundException::new);
        List<DesarrolladorResponseDTO> listaDesarrolladores = new ArrayList<>();
        for(DesarrolladorResponseDTO desarrollador: juegoResponseDTO.getDesarrolladores()){
            listaDesarrolladores.add(desarrollador);
        }
        if(listaDesarrolladores.isEmpty()){
            HttpHeaders headers = new HttpHeaders();
            headers.add("Error", "No se han asignado desarrolladores a este juego");
            return new ResponseEntity<>(headers,HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listaDesarrolladores,HttpStatus.OK);
    }}
