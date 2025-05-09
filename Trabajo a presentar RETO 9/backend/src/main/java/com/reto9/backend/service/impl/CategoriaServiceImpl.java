package com.reto9.backend.service.impl;

import com.reto9.backend.dto.CategoriaDTO;
import com.reto9.backend.model.Categoria;
import com.reto9.backend.repository.CategoriaRepository;
import com.reto9.backend.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementación del servicio de categorías.
 * Provee operaciones CRUD y conversión entre entidades y DTOs.
 */
@Service
@RequiredArgsConstructor
public class CategoriaServiceImpl implements CategoriaService {

    // Repositorio de acceso a datos para la entidad Categoría
    private final CategoriaRepository categoriaRepository;

    /**
     * Obtiene todas las categorías registradas en el sistema.
     * @return lista de DTOs de categoría
     */
    @Override
    public List<CategoriaDTO> findAll() {
        return categoriaRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    /**
     * Busca una categoría por su ID.
     * @param id identificador único
     * @return DTO de la categoría si existe, si no null
     */
    @Override
    public CategoriaDTO findById(Integer id) {
        return categoriaRepository.findById(id)
                .map(this::toDTO)
                .orElse(null);
    }

    /**
     * Guarda una nueva categoría en la base de datos.
     * @param dto DTO con los datos de la nueva categoría
     * @return DTO de la categoría guardada
     */
    @Override
    public CategoriaDTO save(CategoriaDTO dto) {
        Categoria categoria = toEntity(dto);
        return toDTO(categoriaRepository.save(categoria));
    }

    /**
     * Actualiza una categoría existente.
     * @param id identificador de la categoría a actualizar
     * @param dto datos nuevos para la categoría
     * @return DTO de la categoría actualizada
     */
    @Override
    public CategoriaDTO update(Integer id, CategoriaDTO dto) {
        Categoria categoria = categoriaRepository.findById(id).orElseThrow();
        categoria.setNombre(dto.getNombre());
        categoria.setDescripcion(dto.getDescripcion());
        return toDTO(categoriaRepository.save(categoria));
    }

    /**
     * Elimina una categoría por su ID.
     * @param id identificador de la categoría
     */
    @Override
    public void delete(Integer id) {
        categoriaRepository.deleteById(id);
    }

    /**
     * Convierte una entidad Categoria a un DTO.
     */
    private CategoriaDTO toDTO(Categoria c) {
        return CategoriaDTO.builder()
                .idCategoria(c.getIdCategoria())
                .nombre(c.getNombre())
                .descripcion(c.getDescripcion())
                .build();
    }

    /**
     * Convierte un DTO a una entidad Categoria.
     */
    private Categoria toEntity(CategoriaDTO dto) {
        return Categoria.builder()
                .idCategoria(dto.getIdCategoria())
                .nombre(dto.getNombre())
                .descripcion(dto.getDescripcion())
                .build();
    }
}
