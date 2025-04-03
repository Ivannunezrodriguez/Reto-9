package com.reto9.backend.controller;

import com.reto9.backend.dto.UsuarioDTO;
import com.reto9.backend.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> getAll() {
        return ResponseEntity.ok(usuarioService.findAll());
    }

    @GetMapping("/{username}")
    public ResponseEntity<UsuarioDTO> getOne(@PathVariable String username) {
        return ResponseEntity.ok(usuarioService.findByUsername(username));
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> create(@RequestBody UsuarioDTO dto) {
        return ResponseEntity.ok(usuarioService.save(dto));
    }

    @PutMapping("/{username}")
    public ResponseEntity<UsuarioDTO> update(@PathVariable String username, @RequestBody UsuarioDTO dto) {
        return ResponseEntity.ok(usuarioService.update(username, dto));
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<Void> disable(@PathVariable String username) {
        usuarioService.disable(username);
        return ResponseEntity.noContent().build();
    }
}
