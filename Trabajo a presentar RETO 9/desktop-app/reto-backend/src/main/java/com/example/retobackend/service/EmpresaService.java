package com.example.retobackend.service;

import com.example.retobackend.model.Empresa;

import java.util.List;

public interface EmpresaService {
    List<Empresa> findAll();
    Empresa findById(Long id);
    Empresa save(Empresa empresa);
    void deleteById(Long id);
}
