package com.reto9.backend.controller;

import com.reto9.backend.dto.UsuarioPerfilDTO;
import com.reto9.backend.model.UsuarioPerfil;
import com.reto9.backend.service.UsuarioPerfilService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario-perfil")
@RequiredArgsConstructor
public class UsuarioPerfilController {

    private final UsuarioPerfilService usuarioPerfilService;

    @GetMapping("/{username}")
    public List<UsuarioPerfilDTO> getPerfiles(@PathVariable String username) {
        return usuarioPerfilService.findByUsername(username);
    }

    @PostMapping
    public UsuarioPerfil crear(@RequestBody UsuarioPerfil usuarioPerfil) {
        return usuarioPerfilService.save(usuarioPerfil);
    }
}
