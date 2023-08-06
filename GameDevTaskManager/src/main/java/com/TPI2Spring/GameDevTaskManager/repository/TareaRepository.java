package com.TPI2Spring.GameDevTaskManager.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.TPI2Spring.GameDevTaskManager.domain.Estado;
import com.TPI2Spring.GameDevTaskManager.domain.Tarea;

@Repository
public interface TareaRepository extends JpaRepository<Tarea,UUID> {

    List<Tarea> findTareaByEstadoOrFechaLimite(Estado estado,Date fechaLimite);
    Optional<List<Tarea>> findByJuegoDeLaTareaId(UUID idJuego);
}
