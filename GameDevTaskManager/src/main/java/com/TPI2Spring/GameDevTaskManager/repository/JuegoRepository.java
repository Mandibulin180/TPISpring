package com.TPI2Spring.GameDevTaskManager.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.TPI2Spring.GameDevTaskManager.domain.Juego;

@Repository
public interface JuegoRepository extends JpaRepository<Juego,UUID> {
}
