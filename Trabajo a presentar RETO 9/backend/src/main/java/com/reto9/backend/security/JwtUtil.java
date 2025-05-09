package com.reto9.backend.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

/**
 * Clase utilitaria para gestionar tokens JWT.
 * Permite generar, validar y extraer información del token.
 */
@Component
public class JwtUtil {

    // Clave secreta usada para firmar el token (debe mantenerse privada)
    private final String SECRET = "supersecretjwtkeyparaelproyectoreto9deivan1234";

    // Duración del token en milisegundos (1 día = 86400000 ms)
    private final long EXPIRATION = 86400000;

    /**
     * Obtiene la clave criptográfica a partir del secreto.
     * @return clave HMAC para firmar/verificar el JWT
     */
    private Key getKey() {
        return Keys.hmacShaKeyFor(SECRET.getBytes());
    }

    /**
     * Genera un token JWT para un nombre de usuario específico.
     * @param username Nombre de usuario
     * @return Token JWT firmado y codificado
     */
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username) // el campo principal del token será el nombre de usuario
                .setIssuedAt(new Date()) // fecha de emisión
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION)) // fecha de expiración
                .signWith(getKey(), SignatureAlgorithm.HS256) // algoritmo y clave de firma
                .compact();
    }

    /**
     * Extrae el nombre de usuario desde un token JWT.
     * @param token Token JWT
     * @return Nombre de usuario (subject)
     */
    public String getUsernameFromToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    /**
     * Valida que el token JWT sea válido (firma correcta y no expirado).
     * @param token Token JWT
     * @return true si es válido, false si es inválido o expirado
     */
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(getKey())
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (JwtException e) {
            // Si ocurre cualquier excepción (firma inválida, expirado, etc.)
            return false;
        }
    }
}
