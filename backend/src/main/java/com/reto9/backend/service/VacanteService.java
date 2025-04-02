package com.reto9.backend.service;

import com.reto9.backend.dto.VacanteDTO;
import com.reto9.backend.model.Vacante;

import java.util.List;
import java.util.Optional;

public interface VacanteService {
    List<VacanteDTO> findAllDTO();
    List<VacanteDTO> findByEstado(String estatus);
    List<Vacante> findAll();
    Optional<Vacante> findById(int idVacante);
    Vacante save(Vacante vacante);
    void deleteById(int idVacante);
    void asignarVacanteAUsuario(int idVacante, String username); // lógica de asignación
}
