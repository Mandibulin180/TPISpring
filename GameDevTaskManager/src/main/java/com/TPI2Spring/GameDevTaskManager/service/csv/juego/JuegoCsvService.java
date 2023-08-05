package com.TPI2Spring.GameDevTaskManager.service.csv.juego;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import com.TPI2Spring.GameDevTaskManager.model.csvRecord.JuegoCsvRecord;


public interface JuegoCsvService {
    List<JuegoCsvRecord> convertSCV (File file) throws IllegalStateException, FileNotFoundException;
}
