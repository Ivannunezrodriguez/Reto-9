package com.reto9.backend.service;

import com.reto9.backend.model.Vacante;

import java.util.List;
import java.util.Optional;

public interface VacanteService {
    List<Vacante> findAll();
    Optional<Vacante> findById(Integer id);
    Vacante save(Vacante vacante);
    void deleteById(Integer id);
}
