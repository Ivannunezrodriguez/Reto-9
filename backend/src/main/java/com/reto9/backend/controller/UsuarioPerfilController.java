package com.reto9.backend.controller;

import com.reto9.backend.dto.UsuarioPerfilDTO;
import com.reto9.backend.service.UsuarioPerfilService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario-perfiles")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class UsuarioPerfilController {

    private final UsuarioPerfilService usuarioPerfilService;

    @GetMapping
    public ResponseEntity<List<UsuarioPerfilDTO>> getAll() {
        return ResponseEntity.ok(usuarioPerfilService.findAll());
    }

    @GetMapping("/usuario/{username}")
    public ResponseEntity<List<UsuarioPerfilDTO>> getByUsuario(@PathVariable String username) {
        return ResponseEntity.ok(usuarioPerfilService.findByUsername(username));
    }

    @PostMapping
    public ResponseEntity<UsuarioPerfilDTO> create(@RequestBody UsuarioPerfilDTO dto) {
        return ResponseEntity.ok(usuarioPerfilService.save(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        usuarioPerfilService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
