package com.reto9.backend.controller;

import com.reto9.backend.dto.UsuarioPerfilDTO;
import com.reto9.backend.service.UsuarioPerfilService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para gestionar la asignación de perfiles (roles) a usuarios.
 * Solo los administradores pueden modificar las asignaciones.
 * Los usuarios pueden consultar únicamente sus propios perfiles.
 */
@RestController
@RequestMapping("/api/usuario-perfiles")
@RequiredArgsConstructor
@CrossOrigin(origins = "*") // Permite solicitudes desde cualquier origen
public class UsuarioPerfilController {

    private final UsuarioPerfilService usuarioPerfilService;

    /**
     * Obtiene todas las asignaciones de perfiles a usuarios.
     * Solo accesible para administradores.
     *
     * @return Lista de asignaciones usuario-perfil.
     */
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public ResponseEntity<List<UsuarioPerfilDTO>> getAll() {
        return ResponseEntity.ok(usuarioPerfilService.findAll());
    }

    /**
     * Obtiene los perfiles asignados a un usuario específico.
     * Solo el administrador o el propio usuario pueden consultar esta información.
     *
     * @param username Nombre de usuario.
     * @return Lista de perfiles asignados al usuario.
     */
    @PreAuthorize("hasRole('ADMIN') or #username == authentication.name")
    @GetMapping("/usuario/{username}")
    public ResponseEntity<List<UsuarioPerfilDTO>> getByUsuario(@PathVariable String username) {
        return ResponseEntity.ok(usuarioPerfilService.findByUsername(username));
    }

    /**
     * Asigna un nuevo perfil a un usuario.
     * Solo accesible para administradores.
     *
     * @param dto Datos de la asignación usuario-perfil.
     * @return Asignación creada.
     */
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<UsuarioPerfilDTO> create(@RequestBody UsuarioPerfilDTO dto) {
        return ResponseEntity.ok(usuarioPerfilService.save(dto));
    }

    /**
     * Elimina una asignación de perfil a un usuario.
     * Solo accesible para administradores.
     *
     * @param id ID de la asignación a eliminar.
     * @return Sin contenido (204) si se elimina correctamente.
     */
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        usuarioPerfilService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
