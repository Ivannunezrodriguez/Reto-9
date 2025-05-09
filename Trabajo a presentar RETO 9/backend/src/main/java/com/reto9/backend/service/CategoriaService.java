package com.reto9.backend.service;

import com.reto9.backend.dto.CategoriaDTO;

import java.util.List;

/**
 * Interfaz que define los métodos del servicio para la gestión de categorías.
 * Se encarga de las operaciones CRUD necesarias para manejar las categorías
 * utilizadas en el sistema de vacantes.
 */
public interface CategoriaService {

    /**
     * Obtiene todas las categorías disponibles.
     * @return Lista de objetos CategoriaDTO.
     */
    List<CategoriaDTO> findAll();

    /**
     * Busca una categoría por su ID.
     * @param id Identificador único de la categoría.
     * @return Objeto CategoriaDTO si existe, o null si no se encuentra.
     */
    CategoriaDTO findById(Integer id);

    /**
     * Guarda una nueva categoría en el sistema.
     * @param dto Objeto DTO con los datos de la nueva categoría.
     * @return Objeto CategoriaDTO creado.
     */
    CategoriaDTO save(CategoriaDTO dto);

    /**
     * Actualiza los datos de una categoría existente.
     * @param id Identificador único de la categoría a actualizar.
     * @param dto Objeto DTO con los nuevos datos.
     * @return Objeto CategoriaDTO actualizado.
     */
    CategoriaDTO update(Integer id, CategoriaDTO dto);

    /**
     * Elimina una categoría del sistema.
     * @param id Identificador único de la categoría a eliminar.
     */
    void delete(Integer id);
}
