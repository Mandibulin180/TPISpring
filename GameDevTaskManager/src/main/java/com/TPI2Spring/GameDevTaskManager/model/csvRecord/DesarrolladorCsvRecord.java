package com.TPI2Spring.GameDevTaskManager.model.csvRecord;

import com.TPI2Spring.GameDevTaskManager.domain.Rol;
import com.opencsv.bean.CsvBindByName;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DesarrolladorCsvRecord {
    @CsvBindByName(column = "nombre")
    private String nombre;
    @CsvBindByName(column = "correoElectronico")
    private String correoElectronico;
    @CsvBindByName(column = "rol")
    private Rol rol;
    
}
