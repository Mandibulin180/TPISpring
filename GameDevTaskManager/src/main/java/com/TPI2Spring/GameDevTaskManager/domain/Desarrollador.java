package com.TPI2Spring.GameDevTaskManager.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder.Default;
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
    @Enumerated(value = EnumType.STRING)
    private Rol rol;
    @OneToMany(mappedBy = "desarrolladorResponsable")
    @Default
    private List<Tarea> tarea = new ArrayList<>();
    @ManyToOne
    private Juego juegoAsignado;
    
}
