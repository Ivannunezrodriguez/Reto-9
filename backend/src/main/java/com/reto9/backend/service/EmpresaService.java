package com.reto9.backend.service;

import com.reto9.backend.dto.EmpresaDTO;

import java.util.List;

public interface EmpresaService {
    List<EmpresaDTO> findAll();
    EmpresaDTO findById(Integer id);
    EmpresaDTO save(EmpresaDTO dto);
    EmpresaDTO update(Integer id, EmpresaDTO dto);
    void delete(Integer id);
}
