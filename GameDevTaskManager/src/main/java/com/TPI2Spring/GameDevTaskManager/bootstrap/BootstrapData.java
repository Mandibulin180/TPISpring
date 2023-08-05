package com.TPI2Spring.GameDevTaskManager.bootstrap;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Random;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import com.TPI2Spring.GameDevTaskManager.domain.Desarrollador;
import com.TPI2Spring.GameDevTaskManager.domain.Juego;
import com.TPI2Spring.GameDevTaskManager.domain.Tarea;
import com.TPI2Spring.GameDevTaskManager.model.csvRecord.DesarrolladorCsvRecord;
import com.TPI2Spring.GameDevTaskManager.model.csvRecord.JuegoCsvRecord;
import com.TPI2Spring.GameDevTaskManager.model.csvRecord.TareaCsvRecord;
import com.TPI2Spring.GameDevTaskManager.repository.DesarroladorRepository;
import com.TPI2Spring.GameDevTaskManager.repository.JuegoRepository;
import com.TPI2Spring.GameDevTaskManager.repository.TareaRepository;
import com.TPI2Spring.GameDevTaskManager.service.csv.desarrollador.DesarrolladorCsvService;
import com.TPI2Spring.GameDevTaskManager.service.csv.juego.JuegoCsvService;
import com.TPI2Spring.GameDevTaskManager.service.csv.tarea.TareaCsvService;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class BootstrapData implements CommandLineRunner {
    
    private final TareaCsvService tareaCsvService;
    private final TareaRepository tareaRepository;
    private final JuegoCsvService juegoCsvService;
    private final JuegoRepository juegoRepository;
    private final DesarroladorRepository desarroladorRepository;
    private final DesarrolladorCsvService desarrolladorCsvService;
    private final SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public void run(String... args)throws Exception{
        loadTareaData();
        loadDesarrolladorData();
        loadJuegoData();
        relacionarDatos();

    }

    private void relacionarDatos(){

        List<Tarea> allTareas = tareaRepository.findAll();
        for(Tarea tarea:allTareas){
            if(tarea.getDesarrolladorResponsable() == null && tarea.getJuegoDeLaTarea() == null){
                List<Desarrollador> allDesarrolladores = desarroladorRepository.findAll();
                List<Juego> allJuegos = juegoRepository.findAll();

                Random aleatorio = new Random(System.currentTimeMillis());
                int randomDev = aleatorio.nextInt(allDesarrolladores.size());
                int randomJuego = aleatorio.nextInt(allJuegos.size());
                Desarrollador desarrollador = allDesarrolladores.get(randomDev);
                Juego juego = allJuegos.get(randomJuego);
                
                tarea.setDesarrolladorResponsable(desarrollador);
                tarea.setJuegoDeLaTarea(juego);
                desarrollador.setJuegoAsignado(juego);

                desarroladorRepository.save(desarrollador);
                tareaRepository.save(tarea);
            }
        }
    }


    private void loadTareaData()throws FileNotFoundException, ParseException{
        if(tareaRepository.count()<50){
            File file = ResourceUtils.getFile("C:\\Users\\gonza\\Desktop\\TPI2 Spring\\GameDevTaskManager\\src\\main\\resources\\csv\\tareas.csv");
            List<TareaCsvRecord> tareaCsvRecordsList = tareaCsvService.convertSCV(file);
            if(!tareaCsvRecordsList.isEmpty()){
                for(TareaCsvRecord tareaCsvRecord:tareaCsvRecordsList){
                    tareaRepository.save(
                        Tarea.builder()
                        .descripcion(tareaCsvRecord.getDescripcion())
                        .fechaLimite(formato.parse(tareaCsvRecord.getFechalimite()))
                        .estado(tareaCsvRecord.getEstado())
                        .build()
                    );
                }
            }
        }
    }

    private void loadJuegoData()throws FileNotFoundException, ParseException{
        if(juegoRepository.count()<25){
            File file = ResourceUtils.getFile("src\\main\\resources\\csv\\juegos.csv");
            List<JuegoCsvRecord> juegoCsvRecordsList  = juegoCsvService.convertSCV(file);
            if(!juegoCsvRecordsList.isEmpty()){
                for(JuegoCsvRecord juegoCsvRecord:juegoCsvRecordsList){
                    juegoRepository.save(
                        Juego.builder()
                        .descripción(juegoCsvRecord.getDescripcion())
                        .titulo(juegoCsvRecord.getTitulo())
                        .fechaDeLanzamiento(formato.parse(juegoCsvRecord.getFechaLanzamiento()))
                        .build()
                    );
                }
            }

        }
    }

    private void loadDesarrolladorData()throws FileNotFoundException, ParseException{
        if(desarroladorRepository.count()<50){
            File file = ResourceUtils.getFile("classpath:csv/desarrolladores.csv");
            List<DesarrolladorCsvRecord> desarrolladorCsvRecordsList = desarrolladorCsvService.convertSCV(file);
            if(!desarrolladorCsvRecordsList.isEmpty()){
                for(DesarrolladorCsvRecord desarrolladorCsvRecord:desarrolladorCsvRecordsList){
                    desarroladorRepository.save(
                        Desarrollador.builder()
                        .correoElectronico(desarrolladorCsvRecord.getCorreoElectronico())
                        .nombre(desarrolladorCsvRecord.getNombre())
                        .rol(desarrolladorCsvRecord.getRol())
                        .build()
                    );
                }
            }
        }
    }

}
