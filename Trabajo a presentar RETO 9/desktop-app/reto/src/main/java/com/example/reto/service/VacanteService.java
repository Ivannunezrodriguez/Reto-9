package com.example.reto.service;

import com.example.reto.model.Vacante;
import javafx.concurrent.Task;

import java.util.List;

public interface VacanteService {

    // Obtener todas las vacantes
    Task<List<Vacante>> obtenerVacantes();

    // Crear una nueva vacante
    Task<Void> crearVacante(Vacante vacante);

    // Editar una vacante
    Task<Void> editarVacante(Long id, Vacante vacante);

    // Eliminar una vacante
    Task<Void> eliminarVacante(Long id);
}
