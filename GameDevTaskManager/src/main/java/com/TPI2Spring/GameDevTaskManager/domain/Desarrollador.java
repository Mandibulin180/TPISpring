package com.TPI2Spring.GameDevTaskManager.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Desarrollador extends Identifier {
    @Column(length = 100,columnDefinition = "Varchar(100)",updatable = true,nullable = false)
    private String nombre;
    @Column(length = 50,columnDefinition = "Varchar(50)",updatable = true,nullable = false)
    private String correoElectronico;
    @Column(length = 50,columnDefinition = "varchar(50)",updatable = true,nullable = false)
    private String rol;
    @OneToOne(mappedBy = "desarrolladorResponsable")
    private Tarea tarea;
    @ManyToOne
    private Juego juegoAsignado;
    
}
