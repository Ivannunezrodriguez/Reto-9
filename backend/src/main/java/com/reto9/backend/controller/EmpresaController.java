package com.reto9.backend.controller;

import com.reto9.backend.model.Empresa;
import com.reto9.backend.repository.EmpresaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empresas")
@RequiredArgsConstructor
public class EmpresaController {

    private final EmpresaRepository empresaRepository;

    @GetMapping
    public List<Empresa> findAll() {
        return empresaRepository.findAll();
    }

    @PostMapping
    public Empresa create(@RequestBody Empresa empresa) {
        return empresaRepository.save(empresa);
    }
}
