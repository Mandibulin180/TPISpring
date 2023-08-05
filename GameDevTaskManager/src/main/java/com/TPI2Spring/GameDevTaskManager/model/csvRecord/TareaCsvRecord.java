package com.TPI2Spring.GameDevTaskManager.model.csvRecord;

import com.TPI2Spring.GameDevTaskManager.domain.Estado;
import com.opencsv.bean.CsvBindByName;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TareaCsvRecord {
    @CsvBindByName(column = "estado")
    private Estado estado;
    @CsvBindByName(column = "fechalimite")
    private String fechalimite;
    @CsvBindByName(column = "descripcion")
    private String descripcion;
}
