package com.reto9.backend.service;

import com.reto9.backend.model.Solicitud;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz de servicio para operaciones sobre Solicitudes.
 */
public interface SolicitudService {

    /**
     * Devuelve todas las solicitudes existentes.
     */
    List<Solicitud> findAll();

    /**
     * Busca una solicitud por su ID.
     */
    Optional<Solicitud> findById(Integer id);

    /**
     * Crea o actualiza una solicitud.
     */
    Solicitud save(Solicitud solicitud);

    /**
     * Elimina una solicitud por ID.
     */
    void deleteById(Integer id);
}
