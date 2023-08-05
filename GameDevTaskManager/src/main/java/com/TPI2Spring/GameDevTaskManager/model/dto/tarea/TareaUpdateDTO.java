package com.TPI2Spring.GameDevTaskManager.model.dto.tarea;

import java.util.Date;

import com.TPI2Spring.GameDevTaskManager.domain.Estado;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
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
public class TareaUpdateDTO {
    @NotBlank
    private String descripcion;
    @NotBlank
    private String juegoDeLaTareaId;
    @NotBlank
    private String desarrolladorResponsableId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @Future
    private Date fechaLimite;
    private Estado estado;
}
