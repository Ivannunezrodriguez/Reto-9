package com.reto9.backend.service;

import com.reto9.backend.model.Empresa;

import java.util.List;
import java.util.Optional;

public interface EmpresaService {
    List<Empresa> findAll();
    Optional<Empresa> findById(Integer id);
    Empresa save(Empresa empresa);
    void deleteById(Integer id);
}
