package com.reto9.backend.controller;

import com.reto9.backend.dto.PerfilDTO;
import com.reto9.backend.service.PerfilService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para la gestión de perfiles de usuario (ADMIN, USUARIO, EMPRESA).
 * Solo accesible por usuarios con el rol ADMIN.
 */
@RestController
@RequestMapping("/api/perfiles")
@RequiredArgsConstructor
@CrossOrigin(origins = "*") // Permite peticiones desde cualquier origen (útil para frontend en desarrollo)
public class PerfilController {

    private final PerfilService perfilService;

    /**
     * Obtiene todos los perfiles del sistema (ej. ADMIN, EMPRESA, USUARIO).
     * Solo accesible por el rol ADMIN.
     *
     * @return Lista de objetos PerfilDTO.
     */
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public ResponseEntity<List<PerfilDTO>> getAll() {
        return ResponseEntity.ok(perfilService.findAll());
    }

    /**
     * Obtiene los datos de un perfil específico por su ID.
     * Solo accesible por el rol ADMIN.
     *
     * @param id ID del perfil.
     * @return PerfilDTO correspondiente al ID.
     */
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<PerfilDTO> getOne(@PathVariable Integer id) {
        return ResponseEntity.ok(perfilService.findById(id));
    }

    /**
     * Crea un nuevo perfil (por ejemplo, para crear un perfil de tipo ADMIN).
     * Solo accesible por el rol ADMIN.
     *
     * @param dto Objeto PerfilDTO con la información del nuevo perfil.
     * @return PerfilDTO creado.
     */
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<PerfilDTO> create(@RequestBody PerfilDTO dto) {
        return ResponseEntity.ok(perfilService.save(dto));
    }

    /**
     * Actualiza un perfil existente según su ID.
     * Solo accesible por el rol ADMIN.
     *
     * @param id ID del perfil a actualizar.
     * @param dto Nuevos datos del perfil.
     * @return PerfilDTO actualizado.
     */
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<PerfilDTO> update(@PathVariable Integer id, @RequestBody PerfilDTO dto) {
        return ResponseEntity.ok(perfilService.update(id, dto));
    }

    /**
     * Elimina un perfil del sistema.
     * Solo accesible por el rol ADMIN.
     *
     * @param id ID del perfil a eliminar.
     * @return Respuesta HTTP sin contenido.
     */
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        perfilService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
