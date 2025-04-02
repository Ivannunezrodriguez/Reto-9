package com.reto9.backend.service;

import com.reto9.backend.dto.EmpresaDTO;
import com.reto9.backend.model.Empresa;

import java.util.List;
import java.util.Optional;

public interface EmpresaService {
    List<EmpresaDTO> findAllDTO();
    List<Empresa> findAll();
    Optional<Empresa> findById(int idEmpresa);
    Empresa save(Empresa empresa);
    void deleteById(int idEmpresa);
}
