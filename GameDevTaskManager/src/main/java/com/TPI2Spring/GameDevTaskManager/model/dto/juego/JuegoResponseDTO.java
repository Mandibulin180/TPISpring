package com.TPI2Spring.GameDevTaskManager.model.dto.juego;

import java.util.Date;
import java.util.List;

import com.TPI2Spring.GameDevTaskManager.model.dto.desarrollador.DesarrolladorResponseDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date fechaDeLanzamiento;
    private List<DesarrolladorResponseDTO> desarrolladores;
    

}
