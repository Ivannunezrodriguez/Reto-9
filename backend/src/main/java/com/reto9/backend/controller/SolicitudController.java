package com.reto9.backend.controller;

import com.reto9.backend.dto.SolicitudDTO;
import com.reto9.backend.model.Solicitud;
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

    @GetMapping("/usuario/{username}")
    public List<SolicitudDTO> getByUsuario(@PathVariable String username) {
        return solicitudService.findByUsername(username);
    }

    @GetMapping("/vacante/{idVacante}")
    public List<SolicitudDTO> getByVacante(@PathVariable int vacante) {
        return solicitudService.findByVacante(vacante);
    }

    @PostMapping
    public Solicitud crear(@RequestBody Solicitud solicitud) {
        return solicitudService.save(solicitud);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int idSolicitud) {
        solicitudService.deleteById(idSolicitud);
    }
}
