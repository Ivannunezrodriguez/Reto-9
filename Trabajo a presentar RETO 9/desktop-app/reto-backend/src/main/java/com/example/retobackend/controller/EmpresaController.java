package com.example.retobackend.controller;

import com.example.retobackend.model.Empresa;
import com.example.retobackend.service.EmpresaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empresas")
@CrossOrigin(origins = "*")
public class EmpresaController {

    private final EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @GetMapping
    public List<Empresa> getAllEmpresas() {
        return empresaService.findAll();
    }

    @GetMapping("/{id}")
    public Empresa getEmpresaById(@PathVariable Long id) {
        return empresaService.findById(id);
    }

    @PostMapping
    public Empresa createEmpresa(@RequestBody Empresa empresa) {
        return empresaService.save(empresa);
    }

    @PutMapping("/{id}")
    public Empresa updateEmpresa(@PathVariable Long id, @RequestBody Empresa empresa) {
        empresa.setId(id);
        return empresaService.save(empresa);
    }

    @DeleteMapping("/{id}")
    public void deleteEmpresa(@PathVariable Long id) {
        empresaService.deleteById(id);
    }
}
