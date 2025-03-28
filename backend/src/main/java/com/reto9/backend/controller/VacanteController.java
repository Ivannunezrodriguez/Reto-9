package com.reto9.backend.controller;

import com.reto9.backend.model.Vacante;
import com.reto9.backend.repository.VacanteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vacantes")
@RequiredArgsConstructor
public class VacanteController {

    private final VacanteRepository vacanteRepository;

    @GetMapping
    public List<Vacante> findAll() {
        return vacanteRepository.findAll();
    }

    @PostMapping
    public Vacante create(@RequestBody Vacante vacante) {
        return vacanteRepository.save(vacante);
    }
}
