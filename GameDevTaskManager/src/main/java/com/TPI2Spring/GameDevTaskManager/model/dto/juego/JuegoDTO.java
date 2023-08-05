package com.TPI2Spring.GameDevTaskManager.model.dto.juego;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.TPI2Spring.GameDevTaskManager.domain.Desarrollador;
import com.TPI2Spring.GameDevTaskManager.model.dto.tarea.TareaDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder.Default;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class JuegoDTO {
    @NotBlank
    @NotBlank
    private String titulo;
    @NotBlank
    @NotBlank
    @Size(max = 200)
    private String descripcion;
    @Default
    private List<TareaDTO> tareas = new ArrayList<>();
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @Future
    private Date fechaDeLanzamiento;
    @Default
    private List<Desarrollador> desarrolladores = new ArrayList<>();
}
