package com.reto9.backend.repository;

import com.reto9.backend.model.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio JPA para la entidad {@link Perfil}.
 *
 * Este repositorio proporciona operaciones CRUD sobre la tabla `perfiles`,
 * gracias a la herencia de {@link JpaRepository}.
 *
 * Métodos heredados más comunes:
 * - List<Perfil> findAll()
 * - Optional<Perfil> findById(Integer id)
 * - Perfil save(Perfil perfil)
 * - void deleteById(Integer id)
 *
 * Tipo de entidad: Perfil
 * Tipo de clave primaria: Integer
 */
public interface PerfilRepository extends JpaRepository<Perfil, Integer> {
}
