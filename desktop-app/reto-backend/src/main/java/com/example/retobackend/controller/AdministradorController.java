package com.example.retobackend.controller;

import com.example.retobackend.model.Administrador;
import com.example.retobackend.service.AdministradorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/administradores")
@CrossOrigin(origins = "*")
public class AdministradorController {

    private final AdministradorService service;

    public AdministradorController(AdministradorService service) {
        this.service = service;
    }

    @GetMapping
    public List<Administrador> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Administrador findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public Administrador save(@RequestBody Administrador administrador) {
        return service.save(administrador);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }

    @PutMapping("/{id}")
    public Administrador update(@PathVariable Long id, @RequestBody Administrador administradorActualizado) {
        Administrador existente = service.findById(id);
        if (existente != null) {
            existente.setNombre(administradorActualizado.getNombre());
            existente.setEmail(administradorActualizado.getEmail());
            existente.setTelefono(administradorActualizado.getTelefono());
            return service.save(existente);
        } else {
            return null;
        }
    }

}
