package com.reto9.backend.repository;

import com.reto9.backend.model.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repositorio JPA para la entidad {@link Solicitud}.
 *
 * Este repositorio gestiona las operaciones de base de datos para las solicitudes
 * de vacantes por parte de los usuarios.
 *
 * Extiende {@link JpaRepository} para proporcionar operaciones CRUD automáticas.
 *
 * Métodos personalizados:
 * - {@code findByUsername(String username)}: Obtiene todas las solicitudes realizadas por un usuario específico.
 * - {@code findByIdVacante(Integer idVacante)}: Obtiene todas las solicitudes asociadas a una vacante.
 *
 * Tipo de entidad: Solicitud
 * Tipo de clave primaria: Integer
 */
public interface SolicitudRepository extends JpaRepository<Solicitud, Integer> {

    /**
     * Busca todas las solicitudes realizadas por un usuario concreto.
     *
     * @param username nombre de usuario
     * @return lista de solicitudes asociadas al usuario
     */
    List<Solicitud> findByUsername(String username);

    /**
     * Busca todas las solicitudes vinculadas a una vacante específica.
     *
     * @param idVacante ID de la vacante
     * @return lista de solicitudes asociadas a la vacante
     */
    List<Solicitud> findByIdVacante(Integer idVacante);
}
