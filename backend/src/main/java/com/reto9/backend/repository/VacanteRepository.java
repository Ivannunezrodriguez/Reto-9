package com.reto9.backend.repository;

import com.reto9.backend.model.Vacante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repositorio JPA para la entidad {@link Vacante}.
 *
 * Proporciona operaciones CRUD y métodos personalizados para acceder a las vacantes registradas en el sistema.
 * La clave primaria de la entidad es {@code idVacante} de tipo Integer.
 *
 * Métodos personalizados:
 * - {@link #findByEstatus(Vacante.EstatusVacante)}: Devuelve una lista de vacantes filtradas por su estado (CREADA, ASIGNADA o CANCELADA).
 * - {@link #findByIdEmpresa(Integer)}: Devuelve todas las vacantes creadas por una empresa específica.
 *
 * Métodos heredados útiles de JpaRepository:
 * - {@code findAll()}: Lista todas las vacantes.
 * - {@code findById(Integer id)}: Busca una vacante por su ID.
 * - {@code save(Vacante vacante)}: Guarda o actualiza una vacante.
 * - {@code deleteById(Integer id)}: Elimina una vacante por su ID.
 */
public interface VacanteRepository extends JpaRepository<Vacante, Integer> {

    /**
     * Busca todas las vacantes que coincidan con un estado específico.
     * @param estatus Estado de la vacante (CREADA, CANCELADA, ASIGNADA).
     * @return Lista de vacantes con ese estado.
     */
    List<Vacante> findByEstatus(Vacante.EstatusVacante estatus);

    /**
     * Busca todas las vacantes publicadas por una empresa específica.
     * @param idEmpresa ID de la empresa.
     * @return Lista de vacantes de dicha empresa.
     */
    List<Vacante> findByIdEmpresa(Integer idEmpresa);
}
