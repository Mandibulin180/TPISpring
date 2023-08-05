package com.TPI2Spring.GameDevTaskManager.service.csv.tarea;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import com.TPI2Spring.GameDevTaskManager.model.csvRecord.TareaCsvRecord;

public interface TareaCsvService {
    List<TareaCsvRecord> convertSCV (File file) throws IllegalStateException, FileNotFoundException;
}
