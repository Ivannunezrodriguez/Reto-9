package com.reto9.backend.repository;

import com.reto9.backend.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio JPA para la entidad {@link Empresa}.
 *
 * Este repositorio proporciona las operaciones CRUD básicas para la tabla `empresas`
 * gracias a la herencia de {@link JpaRepository}.
 *
 * Métodos proporcionados automáticamente por JpaRepository:
 * - findAll()
 * - findById(Integer id)
 * - save(Empresa empresa)
 * - deleteById(Integer id)
 * - count()
 *
 * Parámetros genéricos:
 * - Empresa: tipo de entidad gestionada.
 * - Integer: tipo de la clave primaria.
 */
public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {
}
