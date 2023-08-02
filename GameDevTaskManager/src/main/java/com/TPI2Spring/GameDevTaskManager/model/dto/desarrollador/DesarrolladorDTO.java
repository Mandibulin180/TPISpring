package com.TPI2Spring.GameDevTaskManager.model.dto.desarrollador;

import com.TPI2Spring.GameDevTaskManager.domain.Rol;

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
public class DesarrolladorDTO {
    private String nombre;
    private String correoElectronico;
    private Rol rol;
    private String juegoAsignadoid;
}
