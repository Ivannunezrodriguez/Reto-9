package com.reto9.backend.repository;

import com.reto9.backend.model.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repositorio JPA para la entidad Solicitud.
 * Incluye métodos personalizados para buscar por vacante o por usuario.
 */
public interface SolicitudRepository extends JpaRepository<Solicitud, Integer> {

    /**
     * Obtener todas las solicitudes asociadas a una vacante.
     */
    List<Solicitud> findByVacanteId(Integer vacanteId);

    /**
     * Obtener todas las solicitudes realizadas por un usuario específico.
     */
    List<Solicitud> findByUsuarioUsername(String username);
}
