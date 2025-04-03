package com.reto9.backend.controller;

import com.reto9.backend.dto.SolicitudDTO;
import com.reto9.backend.service.SolicitudService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para gestionar las solicitudes de los usuarios a las vacantes de empleo.
 * Los permisos están controlados por roles (USUARIO, EMPRESA, ADMIN).
 */
@RestController
@RequestMapping("/api/solicitudes")
@RequiredArgsConstructor
@CrossOrigin(origins = "*") // Permite peticiones desde cualquier origen
public class SolicitudController {

    private final SolicitudService solicitudService;

    /**
     * Crea una nueva solicitud para postular a una vacante.
     * Solo los usuarios con rol USUARIO pueden realizar esta acción.
     *
     * @param dto Datos de la solicitud.
     * @return Solicitud creada.
     */
    @PreAuthorize("hasRole('USUARIO')")
    @PostMapping
    public ResponseEntity<SolicitudDTO> create(@RequestBody SolicitudDTO dto) {
        return ResponseEntity.ok(solicitudService.create(dto));
    }

    /**
     * Devuelve la lista completa de solicitudes del sistema.
     * Solo accesible por usuarios con rol ADMIN.
     *
     * @return Lista de solicitudes.
     */
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public ResponseEntity<List<SolicitudDTO>> getAll() {
        return ResponseEntity.ok(solicitudService.findAll());
    }

    /**
     * Devuelve todas las solicitudes hechas por un usuario específico.
     * Solo accesible por el propio usuario (rol USUARIO).
     *
     * @param username Nombre de usuario.
     * @return Lista de solicitudes del usuario.
     */
    @PreAuthorize("hasRole('USUARIO')")
    @GetMapping("/usuario/{username}")
    public ResponseEntity<List<SolicitudDTO>> getByUsuario(@PathVariable String username) {
        return ResponseEntity.ok(solicitudService.findByUsuario(username));
    }

    /**
     * Devuelve todas las solicitudes recibidas para una vacante específica.
     * Solo accesible por usuarios con rol EMPRESA.
     *
     * @param idVacante ID de la vacante.
     * @return Lista de solicitudes asociadas a la vacante.
     */
    @PreAuthorize("hasRole('EMPRESA')")
    @GetMapping("/vacante/{idVacante}")
    public ResponseEntity<List<SolicitudDTO>> getByVacante(@PathVariable Integer idVacante) {
        return ResponseEntity.ok(solicitudService.findByVacante(idVacante));
    }

    /**
     * Permite a la EMPRESA adjudicar una solicitud (cambia el estado a "ADJUDICADA").
     * Esto también cambia el estado de la vacante a "ASIGNADA".
     *
     * @param id ID de la solicitud a adjudicar.
     * @return Solicitud adjudicada.
     */
    @PreAuthorize("hasRole('EMPRESA')")
    @PutMapping("/{id}/adjudicar")
    public ResponseEntity<SolicitudDTO> adjudicar(@PathVariable Integer id) {
        return ResponseEntity.ok(solicitudService.adjudicar(id));
    }

    /**
     * Permite al USUARIO cancelar una solicitud si no ha sido adjudicada aún.
     * El estado de la solicitud se actualiza a "CANCELADA".
     *
     * @param id ID de la solicitud.
     * @return Solicitud cancelada.
     */
    @PreAuthorize("hasRole('USUARIO')")
    @PutMapping("/{id}/cancelar")
    public ResponseEntity<SolicitudDTO> cancelar(@PathVariable Integer id) {
        return ResponseEntity.ok(solicitudService.cancelar(id));
    }

    /**
     * Devuelve los datos de una solicitud específica.
     * Solo accesible por el ADMIN o por el propio USUARIO.
     *
     * @param id ID de la solicitud.
     * @return Detalles de la solicitud.
     */
    @PreAuthorize("hasRole('ADMIN') or hasRole('USUARIO')")
    @GetMapping("/{id}")
    public ResponseEntity<SolicitudDTO> getOne(@PathVariable Integer id) {
        return ResponseEntity.ok(solicitudService.findById(id));
    }
}
