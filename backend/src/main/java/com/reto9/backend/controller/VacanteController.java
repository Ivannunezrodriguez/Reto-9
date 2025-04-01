package com.reto9.backend.controller;

import com.reto9.backend.model.EstatusVacante;
import com.reto9.backend.model.Solicitud;
import com.reto9.backend.model.Vacante;
import com.reto9.backend.service.SolicitudService;
import com.reto9.backend.service.VacanteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vacantes")
@RequiredArgsConstructor
public class VacanteController {

    private final VacanteService vacanteService;
    private final SolicitudService solicitudService;

    @GetMapping
    public List<Vacante> findAll() {
        return vacanteService.findAll();
    }

    @PostMapping
    public ResponseEntity<Vacante> create(@RequestBody Vacante vacante) {
        vacante.setEstatus(EstatusVacante.CREADA);
        Vacante creada = vacanteService.save(vacante);
        return ResponseEntity.ok(creada);
    }

    @GetMapping("/empresa/{empresaId}")
    public List<Vacante> getVacantesByEmpresa(@PathVariable Integer empresaId) {
        return vacanteService.findByEmpresaId(empresaId);
    }

    @PutMapping("/{id}/cancelar")
    public ResponseEntity<Vacante> cancelarVacante(@PathVariable Integer id) {
        return vacanteService.findById(id).map(vacante -> {
            vacante.setEstatus(EstatusVacante.CANCELADA);
            Vacante actualizada = vacanteService.save(vacante);
            return ResponseEntity.ok(actualizada);
        }).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{vacanteId}/asignar/{solicitudId}")
    public ResponseEntity<?> asignarVacante(@PathVariable Integer vacanteId, @PathVariable Integer solicitudId) {
        Optional<Vacante> optionalVacante = vacanteService.findById(vacanteId);
        Optional<Solicitud> optionalSolicitud = solicitudService.findById(solicitudId);

        if (optionalVacante.isEmpty() || optionalSolicitud.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Vacante vacante = optionalVacante.get();
        vacante.setEstatus(EstatusVacante.ASIGNADA);
        vacanteService.save(vacante);

        Solicitud solicitud = optionalSolicitud.get();
        solicitud.setEstado(1); // adjudicada
        solicitudService.save(solicitud);

        return ResponseEntity.ok("Vacante asignada correctamente.");
    }

    @GetMapping("/publicas")
    public List<Vacante> findPublicadas() {
        return vacanteService.findByEstatus("CREADA");
    }
}
