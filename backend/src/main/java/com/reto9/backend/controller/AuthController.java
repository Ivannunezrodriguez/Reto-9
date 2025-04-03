package com.reto9.backend.controller;

import com.reto9.backend.model.Usuario;
import com.reto9.backend.repository.UsuarioRepository;
import com.reto9.backend.security.JwtUtil;
import com.reto9.backend.security.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Controlador REST para la autenticación y registro de usuarios.
 * Proporciona endpoints para iniciar sesión (login) y registrarse (register),
 * gestionando la seguridad mediante JWT.
 */
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "*") // Permite peticiones desde cualquier origen (útil para desarrollo frontend)
public class AuthController {

    // Inyecta automáticamente los componentes necesarios
    private final AuthenticationManager authManager;
    private final CustomUserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder encoder;

    /**
     * Endpoint de login. Autentica al usuario y devuelve un token JWT.
     * @param body Mapa con las credenciales: username y password.
     * @return Mapa con el token generado si la autenticación es exitosa.
     */
    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> body) {
        String username = body.get("username");
        String password = body.get("password");

        // Autenticación con el AuthenticationManager
        authManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

        // Si es exitoso, se genera el token JWT
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        String token = jwtUtil.generateToken(userDetails.getUsername());

        return Map.of("token", token);
    }

    /**
     * Endpoint de registro. Crea un nuevo usuario en el sistema.
     * @param usuario Objeto Usuario recibido desde el frontend.
     * @return Mensaje de confirmación tras registrar al usuario.
     */
    @PostMapping("/register")
    public Map<String, String> register(@RequestBody Usuario usuario) {
        // Codifica la contraseña antes de guardarla
        usuario.setPassword(encoder.encode(usuario.getPassword()));
        // Marca el usuario como habilitado
        usuario.setEnabled(1);
        // Registra la fecha actual como fecha de alta
        usuario.setFechaRegistro(new Date());
        // Guarda el usuario en la base de datos
        usuarioRepository.save(usuario);

        return Map.of("message", "Usuario registrado");
    }
}
