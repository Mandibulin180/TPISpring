package com.TPI2Spring.GameDevTaskManager.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TPI2Spring.GameDevTaskManager.domain.Juego;

public interface JuegoRepository extends JpaRepository<Juego,UUID> {
    
}
