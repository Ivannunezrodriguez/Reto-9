package com.reto9.backend.controller;

import com.reto9.backend.dto.UsuarioDTO;
import com.reto9.backend.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para gestionar usuarios dentro del sistema.
 * Permite registrar, consultar, actualizar y desactivar usuarios,
 * con acceso restringido según el rol (ADMIN o USUARIO).
 */
@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
@CrossOrigin(origins = "*") // Permite peticiones desde cualquier origen
public class UsuarioController {

    private final UsuarioService usuarioService;

    /**
     * Obtiene la lista completa de usuarios registrados en el sistema.
     * Solo accesible por usuarios con rol ADMIN.
     *
     * @return Lista de usuarios.
     */
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> getAll() {
        return ResponseEntity.ok(usuarioService.findAll());
    }

    /**
     * Obtiene los datos del usuario especificado por su username.
     * Solo el propio usuario o un ADMIN pueden consultar esta información.
     *
     * @param username Nombre de usuario.
     * @return Datos del usuario.
     */
    @PreAuthorize("hasRole('ADMIN') or #username == authentication.name")
    @GetMapping("/{username}")
    public ResponseEntity<UsuarioDTO> getOne(@PathVariable String username) {
        return ResponseEntity.ok(usuarioService.findByUsername(username));
    }

    /**
     * Permite el registro de un nuevo usuario en el sistema.
     * Este endpoint es de acceso público (sin restricción).
     *
     * @param dto Datos del nuevo usuario.
     * @return Usuario registrado.
     */
    @PostMapping
    public ResponseEntity<UsuarioDTO> create(@RequestBody UsuarioDTO dto) {
        return ResponseEntity.ok(usuarioService.save(dto));
    }

    /**
     * Actualiza los datos de un usuario existente.
     * Solo el propio usuario o un ADMIN pueden modificar su información.
     *
     * @param username Nombre de usuario.
     * @param dto Datos a actualizar.
     * @return Usuario actualizado.
     */
    @PreAuthorize("hasRole('ADMIN') or #username == authentication.name")
    @PutMapping("/{username}")
    public ResponseEntity<UsuarioDTO> update(@PathVariable String username, @RequestBody UsuarioDTO dto) {
        return ResponseEntity.ok(usuarioService.update(username, dto));
    }

    /**
     * Desactiva (da de baja) un usuario del sistema.
     * Esto se hace cambiando el campo 'enabled' a false (0).
     * Solo el ADMIN puede ejecutar esta acción.
     *
     * @param username Nombre de usuario a desactivar.
     * @return Sin contenido (204).
     */
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{username}")
    public ResponseEntity<Void> disable(@PathVariable String username) {
        usuarioService.disable(username);
        return ResponseEntity.noContent().build();
    }
}
