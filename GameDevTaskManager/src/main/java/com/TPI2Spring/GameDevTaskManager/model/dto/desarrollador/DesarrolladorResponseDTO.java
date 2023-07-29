package com.TPI2Spring.GameDevTaskManager.model.dto.desarrollador;

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
public class DesarrolladorResponseDTO {
    private String nombre;
    private String correoElectronico;
    private String rol;
    
}
