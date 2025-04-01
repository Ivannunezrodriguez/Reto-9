package com.reto9.backend.service;

import com.reto9.backend.dto.EmpresaDTO;
import java.util.List;

public interface EmpresaService {
    List<EmpresaDTO> getAll();
    EmpresaDTO getById(Long id);
}
