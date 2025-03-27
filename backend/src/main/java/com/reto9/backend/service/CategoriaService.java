package com.reto9.backend.service;

import com.reto9.backend.model.Categoria;

import java.util.List;

public interface CategoriaService {
    List<Categoria> findAll();

    Categoria save(Categoria categoria);

    Categoria update(Integer id, Categoria categoria);

    void delete(Integer id);
}
