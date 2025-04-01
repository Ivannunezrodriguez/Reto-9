package com.reto9.backend.service.impl;

import com.reto9.backend.model.Categoria;
import com.reto9.backend.repository.CategoriaRepository;
import com.reto9.backend.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementación del servicio para la entidad Categoria.
 */
@Service
@RequiredArgsConstructor
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;

    /**
     * Retorna todas las categorías registradas.
     */
    @Override
    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    /**
     * Busca una categoría por su ID.
     */
    @Override
    public Optional<Categoria> findById(Integer id) {
        return categoriaRepository.findById(id);
    }

    /**
     * Guarda o actualiza una categoría.
     */
    @Override
    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    /**
     * Elimina una categoría por su ID.
     */
    @Override
    public void deleteById(Integer id) {
        categoriaRepository.deleteById(id);
    }
}
