package com.reto9.backend.controller;

import com.reto9.backend.dto.EmpresaDTO;
import com.reto9.backend.service.EmpresaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empresas")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class EmpresaController {

    private final EmpresaService empresaService;

    @GetMapping
    public ResponseEntity<List<EmpresaDTO>> getAll() {
        return ResponseEntity.ok(empresaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpresaDTO> getOne(@PathVariable Integer id) {
        return ResponseEntity.ok(empresaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<EmpresaDTO> create(@RequestBody EmpresaDTO dto) {
        return ResponseEntity.ok(empresaService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpresaDTO> update(@PathVariable Integer id, @RequestBody EmpresaDTO dto) {
        return ResponseEntity.ok(empresaService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        empresaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
