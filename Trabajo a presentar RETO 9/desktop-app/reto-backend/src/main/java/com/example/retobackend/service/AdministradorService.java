package com.example.retobackend.service;

import com.example.retobackend.model.Administrador;

import java.util.List;

public interface AdministradorService {
    List<Administrador> findAll();
    Administrador findById(Long id);
    Administrador save(Administrador administrador);
    void deleteById(Long id);
}
