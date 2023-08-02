package com.TPI2Spring.GameDevTaskManager.model.dto.tarea;

import java.util.Date;
import com.TPI2Spring.GameDevTaskManager.domain.Estado;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class TareaResponseDTO {
    String descripcion;
    Estado estado;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    Date fechaLimite;
}
