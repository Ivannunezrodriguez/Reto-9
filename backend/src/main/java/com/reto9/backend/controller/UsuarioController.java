package com.reto9.backend.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final com.reto9.backend.repository.UsuarioRepository usuarioRepository;

    @GetMapping
    public List<com.reto9.backend.model.Usuario> getAll() {
        return usuarioRepository.findAll();
    }

    @PutMapping("/{username}/baja")
    public com.reto9.backend.model.Usuario darDeBaja(@PathVariable String username) {
        com.reto9.backend.model.Usuario usuario = usuarioRepository.findByUsername(username).orElseThrow();
        usuario.setEnabled(0);
        return usuarioRepository.save(usuario);
    }
}
