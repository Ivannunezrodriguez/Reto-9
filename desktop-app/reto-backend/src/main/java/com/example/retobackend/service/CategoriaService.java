package com.example.retobackend.service;

import com.example.retobackend.model.Categoria;

import java.util.List;

public interface CategoriaService {
    List<Categoria> obtenerTodas();
    Categoria guardarCategoria(Categoria categoria);
    Categoria obtenerCategoriaPorId(Long id);
    void eliminarCategoria(Long id);
}
