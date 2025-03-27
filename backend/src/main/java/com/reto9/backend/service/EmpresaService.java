package com.reto9.backend.service;

import com.reto9.backend.model.Empresa;

import java.util.List;

public interface EmpresaService {
    List<Empresa> findAll();

    Empresa save(Empresa empresa);

    Empresa update(Integer id, Empresa empresa);

    void delete(Integer id);
}
