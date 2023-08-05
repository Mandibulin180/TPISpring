package com.TPI2Spring.GameDevTaskManager.model.csvRecord;

import com.opencsv.bean.CsvBindByName;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JuegoCsvRecord {
    @CsvBindByName(column = "titulo")
    private String titulo;
    @CsvBindByName(column = "descripcion")
    private String descripcion;
    @CsvBindByName(column = "fechaLanzamiento")
    private String fechaLanzamiento;
}
