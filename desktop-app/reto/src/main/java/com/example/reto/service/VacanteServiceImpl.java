package com.example.reto.service;

import com.example.reto.model.Vacante;
import javafx.concurrent.Task;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class VacanteServiceImpl implements VacanteService {

    private ObservableList<Vacante> vacantesList = FXCollections.observableArrayList();

    @Override
    public Task<List<Vacante>> obtenerVacantes() {
        return new Task<>() {
            @Override
            protected List<Vacante> call() {
                // Aquí iría la lógica para obtener las vacantes desde la base de datos o backend.
                return vacantesList;
            }
        };
    }

    @Override
    public Task<Void> crearVacante(Vacante vacante) {
        return new Task<>() {
            @Override
            protected Void call() {
                vacantesList.add(vacante);
                return null;
            }
        };
    }

    @Override
    public Task<Void> editarVacante(Long id, Vacante vacante) {
        return new Task<>() {
            @Override
            protected Void call() {
                for (int i = 0; i < vacantesList.size(); i++) {
                    if (vacantesList.get(i).getId().equals(id)) {
                        vacantesList.set(i, vacante);
                        break;
                    }
                }
                return null;
            }
        };
    }

    @Override
    public Task<Void> eliminarVacante(Long id) {
        return new Task<>() {
            @Override
            protected Void call() {
                vacantesList.removeIf(v -> v.getId().equals(id));
                return null;
            }
        };
    }
}
