package com.reto9.backend.repository;

import com.reto9.backend.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio para la entidad Categoria.
 */
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}
