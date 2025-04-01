package com.reto9.backend.service;

import com.reto9.backend.model.Vacante;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz de servicio para la gestión de vacantes.
 */
public interface VacanteService {

    /**
     * Devuelve todas las vacantes registradas.
     */
    List<Vacante> findAll();

    /**
     * Busca una vacante por su ID.
     */
    Optional<Vacante> findById(Integer id);

    /**
     * Crea o actualiza una vacante.
     */
    Vacante save(Vacante vacante);

    /**
     * Elimina una vacante por su ID.
     */
    void deleteById(Integer id);

    /**
     * Busca todas las vacantes publicadas por una empresa específica.
     */
    List<Vacante> findByEmpresaId(Integer empresaId);

    /**
     * Busca vacantes filtrando por estado.
     */
    List<Vacante> findByEstatus(String estatus);
}
