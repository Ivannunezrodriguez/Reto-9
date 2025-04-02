package com.reto9.backend.controller;

import com.reto9.backend.dto.UsuarioDTO;
import com.reto9.backend.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping
    public List<UsuarioDTO> getAll() {
        return usuarioService.findAllDTO();
    }

    @DeleteMapping("/{username}")
    public void eliminarUsuario(@PathVariable String username) {
        usuarioService.deleteByUsername(username);
    }

    @PutMapping("/deshabilitar/{username}")
    public void deshabilitarUsuario(@PathVariable String username) {
        usuarioService.deshabilitarUsuario(username);
    }
}
