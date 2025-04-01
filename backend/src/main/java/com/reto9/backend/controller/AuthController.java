package com.reto9.backend.controller;

import com.reto9.backend.dto.AuthRequest;
import com.reto9.backend.dto.AuthResponse;
import com.reto9.backend.model.Usuario;
import com.reto9.backend.service.UsuarioService;
import com.reto9.backend.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UsuarioService usuarioService;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request) {
        Optional<Usuario> optionalUser = usuarioService.findByUsername(request.getUsername());

        if (optionalUser.isEmpty()) {
            return ResponseEntity.status(401).body("Usuario no encontrado");
        }

        Usuario usuario = optionalUser.get();

        if (!passwordEncoder.matches(request.getPassword(), usuario.getPassword())) {
            return ResponseEntity.status(401).body("Contraseña incorrecta");
        }

        if (usuario.getEnabled() == 0) {
            return ResponseEntity.status(403).body("Usuario deshabilitado");
        }

        String token = jwtUtil.generarToken(usuario.getUsername(), usuario.getRoles());
        return ResponseEntity.ok(new AuthResponse(token));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Usuario usuario) {
        if (usuarioService.findByUsername(usuario.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body("El usuario ya existe");
        }

        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        usuario.setFechaRegistro(new Date());
        usuario.setEnabled(1);
        usuario.setRoles("USUARIO");

        usuarioService.save(usuario);

        return ResponseEntity.ok("Usuario registrado correctamente");
    }
}
