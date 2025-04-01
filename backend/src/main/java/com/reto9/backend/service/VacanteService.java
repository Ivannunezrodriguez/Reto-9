package com.reto9.backend.service;

import com.reto9.backend.dto.VacanteDTO;
import java.util.List;

public interface VacanteService {
    List<VacanteDTO> getAll();
    List<VacanteDTO> getByEmpresaId(Long idEmpresa);
}
