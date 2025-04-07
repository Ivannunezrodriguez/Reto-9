package com.reto9.backend.repository;

import com.reto9.backend.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio JPA para la entidad {@link Categoria}.
 *
 * Proporciona operaciones CRUD (crear, leer, actualizar, eliminar)
 * y consultas adicionales sobre la tabla `categorias` sin necesidad
 * de implementar código SQL explícito.
 *
 * Hereda de {@link JpaRepository}, que incluye métodos como:
 * - findAll()
 * - findById()
 * - save()
 * - deleteById()
 * - count()
 *
 * El tipo de entidad es {@link Categoria} y su clave primaria es {@link Integer}.
 */
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}
