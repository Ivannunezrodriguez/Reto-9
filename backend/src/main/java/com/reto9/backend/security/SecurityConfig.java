package com.reto9.backend.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.*;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.authentication.configuration.*;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.*;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Clase de configuración de seguridad principal.
 * Configura la protección mediante JWT, manejo de sesiones, codificación de contraseñas y autorización por roles.
 */
@Configuration
@RequiredArgsConstructor
@EnableMethodSecurity(prePostEnabled = true) // Habilita el uso de @PreAuthorize y @PostAuthorize en los controladores
public class SecurityConfig {

    private final JwtFilter jwtFilter; // Filtro personalizado que valida el JWT
    private final CustomUserDetailsService userDetailsService; // Carga de usuarios y sus roles

    /**
     * Configura el filtro de seguridad para todas las peticiones HTTP.
     * - Desactiva CSRF (porque usamos JWT).
     * - Establece sesión stateless (sin estado, no se guarda nada en servidor).
     * - Permite libremente las peticiones a /api/auth/**
     * - Requiere autenticación para el resto.
     * - Añade el filtro JWT antes del filtro de autenticación por usuario/contraseña.
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable()) // Desactiva CSRF por ser API REST
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // JWT: sin sesiones
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/auth/**").permitAll() // acceso público a login y registro
                        .anyRequest().authenticated()) // todo lo demás requiere autenticación
                .userDetailsService(userDetailsService) // quién carga los usuarios
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class) // añade filtro JWT
                .build();
    }

    /**
     * Provee el `AuthenticationManager` a Spring Security para que pueda autenticar usuarios.
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config)
            throws Exception {
        return config.getAuthenticationManager();
    }

    /**
     * Codificador de contraseñas usando BCrypt.
     * Se usa tanto al registrar como al autenticar usuarios.
     */
    @Bean
    public BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}
