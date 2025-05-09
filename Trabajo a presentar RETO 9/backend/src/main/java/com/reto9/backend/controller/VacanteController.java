package com.reto9.backend.controller;

import com.reto9.backend.dto.VacanteDTO;
import com.reto9.backend.service.VacanteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para gestionar vacantes de empleo.
 * Define accesos y acciones basadas en roles: ADMIN, EMPRESA y USUARIO.
 */
@RestController
@RequestMapping("/api/vacantes")
@RequiredArgsConstructor
@CrossOrigin(origins = "*") // Permite solicitudes desde cualquier origen (útil para frontend separado)
public class VacanteController {

    private final VacanteService vacanteService;

    /**
     * Permite a una empresa crear una nueva vacante.
     * Solo accesible para usuarios con rol EMPRESA.
     *
     * @param dto Datos de la vacante a crear.
     * @return Vacante creada.
     */
    @PreAuthorize("hasRole('EMPRESA')")
    @PostMapping
    public ResponseEntity<VacanteDTO> create(@RequestBody VacanteDTO dto) {
        return ResponseEntity.ok(vacanteService.create(dto));
    }

    /**
     * Permite a una empresa actualizar una vacante existente.
     * Solo accesible para usuarios con rol EMPRESA.
     *
     * @param id  ID de la vacante.
     * @param dto Nuevos datos de la vacante.
     * @return Vacante actualizada.
     */
    @PreAuthorize("hasRole('EMPRESA')")
    @PutMapping("/{id}")
    public ResponseEntity<VacanteDTO> update(@PathVariable Integer id, @RequestBody VacanteDTO dto) {
        return ResponseEntity.ok(vacanteService.update(id, dto));
    }

    /**
     * Permite a una empresa cancelar una vacante.
     * Cambia el estado de la vacante a "CANCELADA".
     *
     * @param id ID de la vacante a cancelar.
     * @return Respuesta sin contenido (204) si se cancela correctamente.
     */
    @PreAuthorize("hasRole('EMPRESA')")
    @PutMapping("/{id}/cancelar")
    public ResponseEntity<Void> cancel(@PathVariable Integer id) {
        vacanteService.cancel(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Permite al ADMIN visualizar todas las vacantes del sistema,
     * independientemente del estado o empresa.
     *
     * @return Lista completa de vacantes.
     */
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public ResponseEntity<List<VacanteDTO>> findAll() {
        return ResponseEntity.ok(vacanteService.findAll());
    }

    /**
     * Permite a los USUARIOS ver solo las vacantes que están en estado "CREADA".
     *
     * @return Lista de vacantes disponibles para postulación.
     */
    @PreAuthorize("hasRole('USUARIO')")
    @GetMapping("/creadas")
    public ResponseEntity<List<VacanteDTO>> findCreadas() {
        return ResponseEntity.ok(vacanteService.findCreadas());
    }

    /**
     * Permite a las EMPRESAS ver las vacantes que han creado.
     *
     * @param idEmpresa ID de la empresa.
     * @return Lista de vacantes asociadas a la empresa.
     */
    @PreAuthorize("hasRole('EMPRESA')")
    @GetMapping("/empresa/{idEmpresa}")
    public ResponseEntity<List<VacanteDTO>> findByEmpresa(@PathVariable Integer idEmpresa) {
        return ResponseEntity.ok(vacanteService.findByEmpresa(idEmpresa));
    }

    /**
     * Permite al ADMIN o a una EMPRESA consultar los detalles de una vacante específica.
     *
     * @param id ID de la vacante.
     * @return Detalles de la vacante.
     */
    @PreAuthorize("hasRole('ADMIN') or hasRole('EMPRESA')")
    @GetMapping("/{id}")
    public ResponseEntity<VacanteDTO> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(vacanteService.findById(id));
    }
}
