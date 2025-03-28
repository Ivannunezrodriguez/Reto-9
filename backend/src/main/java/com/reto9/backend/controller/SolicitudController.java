package com.reto9.backend.controller;

import com.reto9.backend.model.Solicitud;
import com.reto9.backend.repository.SolicitudRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/solicitudes")
@RequiredArgsConstructor
public class SolicitudController {

    private final SolicitudRepository solicitudRepository;

    @GetMapping
    public List<Solicitud> findAll() {
        return solicitudRepository.findAll();
    }

    @PostMapping
    public Solicitud create(@RequestBody Solicitud solicitud) {
        return solicitudRepository.save(solicitud);
    }
}
