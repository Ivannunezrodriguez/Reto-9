package com.reto9.backend.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vacantes")
@RequiredArgsConstructor
public class VacanteController {

    private final com.reto9.backend.repository.VacanteRepository vacanteRepository;

    @GetMapping
    public List<com.reto9.backend.model.Vacante> getAll() {
        return vacanteRepository.findAll();
    }

    @PostMapping
    public com.reto9.backend.model.Vacante create(@RequestBody com.reto9.backend.model.Vacante vacante) {
        return vacanteRepository.save(vacante);
    }

    @PutMapping("/{id}")
    public com.reto9.backend.model.Vacante update(@PathVariable Integer id, @RequestBody com.reto9.backend.model.Vacante vacante) {
        vacante.setIdVacante(id);
        return vacanteRepository.save(vacante);
    }

    @DeleteMapping("/{id}")
    public void cancel(@PathVariable Integer id) {
        com.reto9.backend.model.Vacante vacante = vacanteRepository.findById(id).orElseThrow();
        vacante.setEstatus(com.reto9.backend.model.EstatusVacante.CANCELADA);
        vacanteRepository.save(vacante);
    }
}
