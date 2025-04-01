package com.reto9.backend.controller;

import com.reto9.backend.model.Solicitud;
import com.reto9.backend.model.Usuario;
import com.reto9.backend.model.Vacante;
import com.reto9.backend.service.SolicitudService;
import com.reto9.backend.service.UsuarioService;
import com.reto9.backend.service.VacanteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/solicitudes")
@RequiredArgsConstructor
public class SolicitudController {

    private final SolicitudService solicitudService;
    private final VacanteService vacanteService;
    private final UsuarioService usuarioService;

    @GetMapping
    public List<Solicitud> findAll() {
        return solicitudService.findAll();
    }

    @GetMapping("/vacante/{vacanteId}")
    public List<Solicitud> findByVacante(@PathVariable Integer vacanteId) {
        return solicitudService.findByVacanteId(vacanteId);
    }

    @GetMapping("/usuario/{username}")
    public List<Solicitud> findByUsuario(@PathVariable String username) {
        return solicitudService.findByUsuarioUsername(username);
    }

    @PostMapping("/postular/{vacanteId}/{username}")
    public ResponseEntity<?> postular(@PathVariable Integer vacanteId,
                                      @PathVariable String username,
                                      @RequestBody Solicitud solicitud) {
        Optional<Vacante> optionalVacante = vacanteService.findById(vacanteId);
        Optional<Usuario> optionalUsuario = usuarioService.findByUsername(username);

        if (optionalVacante.isEmpty() || optionalUsuario.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        solicitud.setVacante(optionalVacante.get());
        solicitud.setUsuario(optionalUsuario.get());
        solicitud.setFechaSolicitud(new Date());
        solicitud.setEstado(0); // Pendiente

        Solicitud guardada = solicitudService.save(solicitud);
        return ResponseEntity.ok(guardada);
    }

    @DeleteMapping("/{id}/cancelar")
    public ResponseEntity<?> cancelar(@PathVariable Integer id) {
        Optional<Solicitud> optional = solicitudService.findById(id);

        if (optional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Solicitud solicitud = optional.get();
        if (solicitud.getEstado() == 1) {
            return ResponseEntity.badRequest().body("La solicitud ya fue adjudicada, no se puede cancelar.");
        }

        solicitudService.deleteById(id);
        return ResponseEntity.ok("Solicitud cancelada.");
    }
}
