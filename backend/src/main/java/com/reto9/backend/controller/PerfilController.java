package com.reto9.backend.controller;

import com.reto9.backend.dto.PerfilDTO;
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
        return perfilService.getAll();
    }
}
