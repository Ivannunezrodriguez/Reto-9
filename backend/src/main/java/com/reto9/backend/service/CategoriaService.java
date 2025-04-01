package com.reto9.backend.service;

import com.reto9.backend.model.Categoria;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz de servicio para operaciones CRUD sobre Categorías.
 */
public interface CategoriaService {

    /**
     * Obtiene todas las categorías disponibles.
     */
    List<Categoria> findAll();

    /**
     * Busca una categoría por su ID.
     */
    Optional<Categoria> findById(Integer id);

    /**
     * Guarda o actualiza una categoría.
     */
    Categoria save(Categoria categoria);

    /**
     * Elimina una categoría por su ID.
     */
    void deleteById(Integer id);
}
