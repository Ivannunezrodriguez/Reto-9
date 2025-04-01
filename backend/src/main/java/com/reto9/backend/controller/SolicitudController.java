package com.reto9.backend.controller;

import com.reto9.backend.dto.SolicitudDTO;
import com.reto9.backend.service.SolicitudService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/solicitudes")
@RequiredArgsConstructor
public class SolicitudController {

    private final SolicitudService solicitudService;

    @GetMapping
    public List<SolicitudDTO> getAll() {
        return solicitudService.getAll();
    }
}
