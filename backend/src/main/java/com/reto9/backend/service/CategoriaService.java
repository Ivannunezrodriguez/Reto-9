package com.reto9.backend.service;

import com.reto9.backend.dto.CategoriaDTO;
import com.reto9.backend.model.Categoria;

import java.util.List;
import java.util.Optional;

public interface CategoriaService {
    List<CategoriaDTO> findAllDTO();
    Categoria save(Categoria categoria);
    Optional<Categoria> findById(int idCategoria);
    void deleteById(int idCategoria);
}
