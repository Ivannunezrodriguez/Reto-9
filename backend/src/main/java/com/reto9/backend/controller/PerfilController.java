package com.reto9.backend.controller;

import com.reto9.backend.dto.PerfilDTO;
import com.reto9.backend.model.Perfil;
import com.reto9.backend.service.PerfilService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/perfiles")
@RequiredArgsConstructor
public class PerfilController {

    private final PerfilService perfilService;

    @GetMapping
    public List<PerfilDTO> getAll() {
        return perfilService.findAllDTO();
    }

    @PostMapping
    public Perfil crear(@RequestBody Perfil perfil) {
        return perfilService.save(perfil);
    }

    @PutMapping
    public Perfil actualizar(@RequestBody Perfil perfil) {
        return perfilService.save(perfil);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int idPerfil) {
        perfilService.deleteById(idPerfil);
    }
}
