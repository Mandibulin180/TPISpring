package com.TPI2Spring.GameDevTaskManager.model.dto.tarea;

import java.util.Date;
import com.TPI2Spring.GameDevTaskManager.domain.Estado;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
public class TareaDTO {
    @NotBlank
    @NotNull
    @Size(max = 100)
    private String descripcion;
    @NotBlank
    @NotNull
    private String juegoDeLaTareaId;
    @NotBlank
    @NotNull
    private String desarrolladorResponsableId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @Future
    @NotNull
    private Date fechaLimite;
    private Estado estado;
}
