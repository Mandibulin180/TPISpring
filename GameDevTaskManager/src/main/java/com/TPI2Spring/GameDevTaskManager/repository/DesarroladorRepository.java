package com.TPI2Spring.GameDevTaskManager.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TPI2Spring.GameDevTaskManager.domain.Desarrollador;

@Repository
public interface DesarroladorRepository extends JpaRepository<Desarrollador,UUID> {
    
}
