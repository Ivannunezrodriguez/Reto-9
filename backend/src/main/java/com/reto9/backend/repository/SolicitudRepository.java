package com.reto9.backend.repository;

import com.reto9.backend.model.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SolicitudRepository extends JpaRepository<Solicitud, Integer> {
    List<Solicitud> findByUsuarioUsername(String username);
    List<Solicitud> findByVacanteId(int vacante);
    Optional<Solicitud> findByVacanteIdAndUsuarioUsername(int vacante, String username);
}
