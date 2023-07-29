package com.TPI2Spring.GameDevTaskManager.domain;

import java.util.Date;

import org.hibernate.annotations.JdbcTypeRegistration;
import org.hibernate.type.SqlTypes;

import com.fasterxml.jackson.annotation.JsonFormat;

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
public class Tarea extends Identifier {
    @Column(length = 100,columnDefinition = "Varchar(100)",updatable = true,nullable = false)
    private String descripcion;
    @ManyToOne
    private Juego juegoDeLaTarea;
    public void setJuegoDeLaTarea(Juego juegoDeLaTarea){
        this.juegoDeLaTarea = juegoDeLaTarea;
        juegoDeLaTarea.getTareas().add(this);
    }
    @OneToOne()
    private Desarrollador desarrolladorResponsable;
    @Column(columnDefinition = "Date",nullable = false,updatable = true)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date fechaLimite;
    @Column(length = 50,columnDefinition = "Varchar(50)",updatable = true,nullable = false)
    private String estado;
}
