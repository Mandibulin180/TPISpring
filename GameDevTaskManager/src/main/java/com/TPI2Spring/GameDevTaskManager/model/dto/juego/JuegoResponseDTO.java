package com.TPI2Spring.GameDevTaskManager.model.dto.juego;

import java.util.Date;
import java.util.List;

import com.TPI2Spring.GameDevTaskManager.model.dto.desarrollador.DesarrolladorResponseDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class JuegoResponseDTO {
    private String titulo;
    private String descripcion;
    private Date fechaDeLanzamiento;
    private List<DesarrolladorResponseDTO> desarrolladores;
    

}
