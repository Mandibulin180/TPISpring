package com.TPI2Spring.GameDevTaskManager.model.dto.desarrollador;

import com.TPI2Spring.GameDevTaskManager.domain.Rol;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
    @NotBlank(message = "nombre no debe estar vacio")
    @NotNull
    private String nombre;
    @Email(message = "debe ser un correo electronico valido")
    @NotNull
    @NotBlank
    private String correoElectronico;
    private Rol rol;
    
}
