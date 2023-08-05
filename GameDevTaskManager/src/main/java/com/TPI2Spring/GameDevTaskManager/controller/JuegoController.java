package com.TPI2Spring.GameDevTaskManager.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.TPI2Spring.GameDevTaskManager.exceptions.NotFoundException;
import com.TPI2Spring.GameDevTaskManager.model.dto.desarrollador.DesarrolladorResponseDTO;
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
    public ResponseEntity createJuego(@Validated @RequestBody JuegoDTO juegoDto) throws NotFoundException{
        juegoService.createJuego(juegoDto);

        return new ResponseEntity<>("Juego Creado!",HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity getJuegoByEstado(@RequestParam(defaultValue = "",required = false)String estado){
        List<JuegoResponseDTO> juegosResponse = juegoService.getJuegosFinalizados(estado);
        if(juegosResponse == null){
            return new ResponseEntity<>("Se necesaita ingresar un estado correcto del juego",HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(juegosResponse,HttpStatus.OK);
    }

    @GetMapping("/{idJuego}")
    public ResponseEntity getDatosDesarrollador(@PathVariable(value = "idJuego")UUID idjuego){
        Optional<JuegoResponseDTO> juegoResponseDTO = juegoService.getJuego(idjuego);
        if(juegoResponseDTO.isPresent()){
            List<DesarrolladorResponseDTO> listaDesarrolladores = new ArrayList<>();
            for(DesarrolladorResponseDTO desarrollador: juegoResponseDTO.get().getDesarrolladores()){
                listaDesarrolladores.add(desarrollador);
            }
            if(listaDesarrolladores.isEmpty()){
                
                return new ResponseEntity<>("No se han asignado desarrolladores a este juego",HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<>(listaDesarrolladores,HttpStatus.OK);
        }else{
            return new ResponseEntity<>("No se encuentra ningun juego con ese id",HttpStatus.NOT_FOUND);
        }
    }
}
