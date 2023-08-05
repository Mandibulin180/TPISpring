package com.TPI2Spring.GameDevTaskManager.service.csv.juego.Impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import org.springframework.stereotype.Service;

import com.TPI2Spring.GameDevTaskManager.model.csvRecord.JuegoCsvRecord;
import com.TPI2Spring.GameDevTaskManager.service.csv.juego.JuegoCsvService;
import com.opencsv.bean.CsvToBeanBuilder;

@Service
public class JuegoCsvServiceImpl implements JuegoCsvService {
    
    @Override
    public List<JuegoCsvRecord> convertSCV (File file) throws IllegalStateException, FileNotFoundException{
        
        List<JuegoCsvRecord> juegoCsvRecordList = 
        new CsvToBeanBuilder<JuegoCsvRecord>(new FileReader(file))
        .withType(JuegoCsvRecord.class)
        .build()
        .parse();

        return juegoCsvRecordList;
    }
}
