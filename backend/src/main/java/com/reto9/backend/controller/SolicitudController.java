package com.reto9.backend.controller;

import com.reto9.backend.dto.SolicitudDTO;
import com.reto9.backend.service.SolicitudService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/solicitudes")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class SolicitudController {

    private final SolicitudService solicitudService;

    @PostMapping
    public ResponseEntity<SolicitudDTO> create(@RequestBody SolicitudDTO dto) {
        return ResponseEntity.ok(solicitudService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<SolicitudDTO>> getAll() {
        return ResponseEntity.ok(solicitudService.findAll());
    }

    @GetMapping("/usuario/{username}")
    public ResponseEntity<List<SolicitudDTO>> getByUsuario(@PathVariable String username) {
        return ResponseEntity.ok(solicitudService.findByUsuario(username));
    }

    @GetMapping("/vacante/{idVacante}")
    public ResponseEntity<List<SolicitudDTO>> getByVacante(@PathVariable Integer idVacante) {
        return ResponseEntity.ok(solicitudService.findByVacante(idVacante));
    }

    @PutMapping("/{id}/adjudicar")
    public ResponseEntity<SolicitudDTO> adjudicar(@PathVariable Integer id) {
        return ResponseEntity.ok(solicitudService.adjudicar(id));
    }

    @PutMapping("/{id}/cancelar")
    public ResponseEntity<SolicitudDTO> cancelar(@PathVariable Integer id) {
        return ResponseEntity.ok(solicitudService.cancelar(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SolicitudDTO> getOne(@PathVariable Integer id) {
        return ResponseEntity.ok(solicitudService.findById(id));
    }
}
