package com.TPI2Spring.GameDevTaskManager.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder.Default;
import lombok.experimental.SuperBuilder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Juego extends Identifier {
    @Column(length = 100,columnDefinition = "Varchar(100)",updatable = true,nullable = false)
    private String titulo;
    @Column(length = 200,columnDefinition = "Varchar(200)",updatable = true,nullable = false)
    private String descripción;
    @OneToMany(mappedBy = "juegoDeLaTarea")
    @Default
    @Column
    private List<Tarea> tareas = new ArrayList<>();
    @Default
    @OneToMany(mappedBy = "juegoAsignado")
    private List<Desarrollador> desarrolladores = new ArrayList<>();
    @Column(columnDefinition = "Date",nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date fechaDeLanzamiento;
}
