package com.TPI2Spring.GameDevTaskManager.model.dto.tarea;

import java.util.Date;
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
public class TareaDTO {
    private String descripcion;
    private String juegoDeLaTareaId;
    private String desarrolladorResponsableId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date fechaLimite;
    private String estado;
}
