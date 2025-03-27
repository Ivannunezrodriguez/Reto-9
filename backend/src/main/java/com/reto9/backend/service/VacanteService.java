package com.reto9.backend.service;



import com.reto9.backend.model.Vacante;

import java.util.List;

public interface VacanteService {
    List<Vacante> findAll();

    Vacante save(Vacante vacante);

    Vacante update(Integer id, Vacante vacante);

    void delete(Integer id);
}
