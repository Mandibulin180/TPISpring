package com.TPI2Spring.GameDevTaskManager.service.csv.tarea.Impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import org.springframework.stereotype.Service;

import com.TPI2Spring.GameDevTaskManager.model.csvRecord.TareaCsvRecord;
import com.TPI2Spring.GameDevTaskManager.service.csv.tarea.TareaCsvService;
import com.opencsv.bean.CsvToBeanBuilder;

@Service
public class TareaCsvServiceImpl implements TareaCsvService {
    
    @Override
    public List<TareaCsvRecord> convertSCV (File file) throws IllegalStateException, FileNotFoundException{

        List<TareaCsvRecord> tareaCsvRecordsList =
        new CsvToBeanBuilder<TareaCsvRecord>(new FileReader(file))
        .withType(TareaCsvRecord.class)
        .build()
        .parse();

        return tareaCsvRecordsList;
    }
}
