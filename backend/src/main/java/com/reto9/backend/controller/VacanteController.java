package com.reto9.backend.controller;

import com.reto9.backend.dto.VacanteDTO;
import com.reto9.backend.service.VacanteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vacantes")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class VacanteController {

    private final VacanteService vacanteService;

    @PostMapping
    public ResponseEntity<VacanteDTO> create(@RequestBody VacanteDTO dto) {
        return ResponseEntity.ok(vacanteService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VacanteDTO> update(@PathVariable Integer id, @RequestBody VacanteDTO dto) {
        return ResponseEntity.ok(vacanteService.update(id, dto));
    }

    @PutMapping("/{id}/cancelar")
    public ResponseEntity<Void> cancel(@PathVariable Integer id) {
        vacanteService.cancel(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<VacanteDTO>> findAll() {
        return ResponseEntity.ok(vacanteService.findAll());
    }

    @GetMapping("/creadas")
    public ResponseEntity<List<VacanteDTO>> findCreadas() {
        return ResponseEntity.ok(vacanteService.findCreadas());
    }

    @GetMapping("/empresa/{idEmpresa}")
    public ResponseEntity<List<VacanteDTO>> findByEmpresa(@PathVariable Integer idEmpresa) {
        return ResponseEntity.ok(vacanteService.findByEmpresa(idEmpresa));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VacanteDTO> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(vacanteService.findById(id));
    }
}
