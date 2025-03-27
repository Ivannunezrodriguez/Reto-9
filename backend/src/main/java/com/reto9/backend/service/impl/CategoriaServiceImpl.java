package com.reto9.backend.service.impl;

import com.reto9.backend.model.Categoria;
import com.reto9.backend.repository.CategoriaRepository;
import com.reto9.backend.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;

    @Override
    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public Categoria update(Integer id, Categoria categoria) {
        categoria.setIdCategoria(id);
        return categoriaRepository.save(categoria);
    }

    @Override
    public void delete(Integer id) {
        categoriaRepository.deleteById(id);
    }
}
