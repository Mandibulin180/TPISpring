package com.TPI2Spring.GameDevTaskManager.service.csv.desarrollador;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import com.TPI2Spring.GameDevTaskManager.model.csvRecord.DesarrolladorCsvRecord;

public interface DesarrolladorCsvService {

    List<DesarrolladorCsvRecord> convertSCV (File file) throws IllegalStateException, FileNotFoundException;
    
}
