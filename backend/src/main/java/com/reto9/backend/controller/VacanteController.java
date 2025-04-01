package com.reto9.backend.controller;

import com.reto9.backend.dto.VacanteDTO;
import com.reto9.backend.service.VacanteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vacantes")
@RequiredArgsConstructor
public class VacanteController {

    private final VacanteService vacanteService;

    @GetMapping
    public List<VacanteDTO> getAll() {
        return vacanteService.getAll();
    }

    @GetMapping("/empresa/{idEmpresa}")
    public List<VacanteDTO> getByEmpresa(@PathVariable Long idEmpresa) {
        return vacanteService.getByEmpresaId(idEmpresa);
    }
}
