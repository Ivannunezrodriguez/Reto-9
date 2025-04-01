package com.reto9.backend.repository;

import com.reto9.backend.model.EstatusVacante;
import com.reto9.backend.model.Vacante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repositorio JPA para la entidad Vacante.
 * Incluye consultas personalizadas por empresa y por estado.
 */
public interface VacanteRepository extends JpaRepository<Vacante, Integer> {

    /**
     * Obtener todas las vacantes publicadas por una empresa específica.
     */
    List<Vacante> findByEmpresaId(Integer empresaId);

    /**
     * Buscar vacantes por estado (como string).
     */
    List<Vacante> findByEstatus(String estatus);

    /**
     * Buscar vacantes por estado (como enum).
     */
    List<Vacante> findByEstatus(EstatusVacante estatus);
}
