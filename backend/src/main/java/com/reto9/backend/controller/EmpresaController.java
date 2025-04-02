package com.reto9.backend.controller;

import com.reto9.backend.dto.EmpresaDTO;
import com.reto9.backend.model.Empresa;
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
        return empresaService.findAllDTO();
    }

    @PostMapping
    public Empresa crear(@RequestBody Empresa empresa) {
        return empresaService.save(empresa);
    }

    @PutMapping
    public Empresa actualizar(@RequestBody Empresa empresa) {
        return empresaService.save(empresa);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int idEmpresa) {
        empresaService.deleteById(idEmpresa);
    }
}
