// CategoriaService.java
package com.reto9.service;

import com.reto9.dto.CategoriaDTO;
import com.reto9.dto.CategoriaRequestDTO;

import java.util.List;

public interface CategoriaService {
    List<CategoriaDTO> findAll();
    CategoriaDTO findById(Integer id);
    CategoriaDTO save(CategoriaRequestDTO dto);
    CategoriaDTO update(Integer id, CategoriaRequestDTO dto);
    void delete(Integer id);
}
