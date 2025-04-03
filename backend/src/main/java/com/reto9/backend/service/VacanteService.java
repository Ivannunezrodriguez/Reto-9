package com.reto9.backend.service;

import com.reto9.backend.dto.VacanteDTO;

import java.util.List;

public interface VacanteService {
    VacanteDTO create(VacanteDTO dto);
    VacanteDTO update(Integer id, VacanteDTO dto);
    void cancel(Integer id);
    List<VacanteDTO> findAll();
    List<VacanteDTO> findByEmpresa(Integer idEmpresa);
    List<VacanteDTO> findCreadas(); // Solo las con estatus "CREADA"
    VacanteDTO findById(Integer id);
}
