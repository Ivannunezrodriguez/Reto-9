package com.reto9.backend.controller;

import com.reto9.backend.model.Usuario;
import com.reto9.backend.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> findAll() {
        return usuarioService.findAll();
    }

    @GetMapping("/{username}")
    public ResponseEntity<Usuario> findByUsername(@PathVariable String username) {
        return usuarioService.findByUsername(username)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Usuario> create(@RequestBody Usuario usuario) {
        if (usuarioService.findByUsername(usuario.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body(null);
        }

        Usuario nuevo = usuarioService.save(usuario);
        return ResponseEntity.ok(nuevo);
    }

    @PutMapping("/{username}/desactivar")
    public ResponseEntity<Usuario> disable(@PathVariable String username) {
        return usuarioService.findByUsername(username).map(user -> {
            user.setEnabled(0); // Usuario deshabilitado
            Usuario actualizado = usuarioService.save(user);
            return ResponseEntity.ok(actualizado);
        }).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{username}")
    public ResponseEntity<Usuario> update(@PathVariable String username, @RequestBody Usuario usuario) {
        return usuarioService.findByUsername(username).map(existing -> {
            usuario.setUsername(username);
            Usuario actualizado = usuarioService.save(usuario);
            return ResponseEntity.ok(actualizado);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<Void> delete(@PathVariable String username) {
        return usuarioService.findByUsername(username).map(u -> {
            usuarioService.deleteByUsername(username);
            return ResponseEntity.noContent().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
