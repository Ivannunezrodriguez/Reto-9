package com.reto9.backend.repository;

import com.reto9.backend.model.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SolicitudRepository extends JpaRepository<Solicitud, Integer> {
    List<Solicitud> findByVacante_Id(Integer idVacante);
    List<Solicitud> findByUsuario_Username(String username);
}
