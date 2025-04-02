package com.reto9.backend.service;

import com.reto9.backend.dto.CategoriaDTO;

import java.util.List;

public interface CategoriaService {
    List<CategoriaDTO> findAll();
    CategoriaDTO findById(Integer id);
    CategoriaDTO save(CategoriaDTO dto);
    CategoriaDTO update(Integer id, CategoriaDTO dto);
    void delete(Integer id);
}
