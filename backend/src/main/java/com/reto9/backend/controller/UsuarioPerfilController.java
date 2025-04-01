package com.reto9.backend.controller;

import com.reto9.backend.dto.UsuarioPerfilDTO;
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
    public List<UsuarioPerfilDTO> getPerfilesUsuario(@PathVariable String username) {
        return usuarioPerfilService.getPerfilesByUsuario(username);
    }
}
