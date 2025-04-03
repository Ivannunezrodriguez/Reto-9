package com.reto9.backend.controller;

import com.reto9.backend.dto.PerfilDTO;
import com.reto9.backend.service.PerfilService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/perfiles")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class PerfilController {

    private final PerfilService perfilService;

    @GetMapping
    public ResponseEntity<List<PerfilDTO>> getAll() {
        return ResponseEntity.ok(perfilService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PerfilDTO> getOne(@PathVariable Integer id) {
        return ResponseEntity.ok(perfilService.findById(id));
    }

    @PostMapping
    public ResponseEntity<PerfilDTO> create(@RequestBody PerfilDTO dto) {
        return ResponseEntity.ok(perfilService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PerfilDTO> update(@PathVariable Integer id, @RequestBody PerfilDTO dto) {
        return ResponseEntity.ok(perfilService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        perfilService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
