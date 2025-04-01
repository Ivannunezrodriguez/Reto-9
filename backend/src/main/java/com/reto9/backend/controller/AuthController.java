package com.reto9.backend.controller;

import com.reto9.backend.dto.AuthRequest;
import com.reto9.backend.dto.AuthResponse;
import com.reto9.backend.model.Usuario;
import com.reto9.backend.model.UsuarioPerfil;
import com.reto9.backend.security.JwtUtil;
import com.reto9.backend.service.UsuarioPerfilService;
import com.reto9.backend.service.UsuarioService;
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
    private final UsuarioPerfilService usuarioPerfilService;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request) {
        Optional<Usuario> optional = usuarioService.findByUsername(request.getUsername());

        if (optional.isEmpty()) {
            return ResponseEntity.status(401).body("Usuario no encontrado");
        }

        Usuario usuario = optional.get();

        if (!passwordEncoder.matches(request.getPassword(), usuario.getPassword())) {
            return ResponseEntity.status(401).body("Contraseña incorrecta");
        }

        String role = usuarioPerfilService.findByUsername(usuario.getUsername())
                .stream().map(up -> up.getPerfil().getNombre())
                .findFirst().orElse("USUARIO");

        String token = jwtUtil.generarToken(usuario.getUsername(), role);
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

        usuarioService.save(usuario);
        return ResponseEntity.ok("Usuario registrado correctamente");
    }
}
