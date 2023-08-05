package com.TPI2Spring.GameDevTaskManager.service.csv.desarrollador.Impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import org.springframework.stereotype.Service;

import com.TPI2Spring.GameDevTaskManager.model.csvRecord.DesarrolladorCsvRecord;
import com.TPI2Spring.GameDevTaskManager.service.csv.desarrollador.DesarrolladorCsvService;
import com.opencsv.bean.CsvToBeanBuilder;

@Service
public class DesarrolladorCsvServiceImpl implements DesarrolladorCsvService {

    @Override
    public List<DesarrolladorCsvRecord> convertSCV (File file) throws IllegalStateException, FileNotFoundException{

        List<DesarrolladorCsvRecord> desarrolladorCsvRecordList =
        new CsvToBeanBuilder<DesarrolladorCsvRecord>(new FileReader(file))
        .withType(DesarrolladorCsvRecord.class)
        .build()
        .parse();

        return desarrolladorCsvRecordList;
    }
    
}
