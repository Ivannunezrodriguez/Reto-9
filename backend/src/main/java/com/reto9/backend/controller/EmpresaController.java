package com.reto9.backend.controller;

import com.reto9.backend.dto.EmpresaDTO;
import com.reto9.backend.service.EmpresaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empresas")
@RequiredArgsConstructor
public class EmpresaController {

    private final EmpresaService empresaService;

    @GetMapping
    public List<EmpresaDTO> getAll() {
        return empresaService.getAll();
    }

    @GetMapping("/{id}")
    public EmpresaDTO getById(@PathVariable Long id) {
        return empresaService.getById(id);
    }
}
