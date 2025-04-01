package com.reto9.backend.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Utilidad para generación y validación de tokens JWT.
 */
@Component
public class JwtUtil {

    private static final String SECRET_KEY = "esta_es_una_superclavepara_la_gestion_de_la_seguridad123123Aa";
    private static final long EXPIRATION_TIME = 1000 * 60 * 60 * 24; // 24 horas

    /**
     * Obtiene la clave secreta como objeto Key para firmar el token.
     */
    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

    /**
     * Genera un token JWT con nombre de usuario y rol.
     *
     * @param username Nombre del usuario
     * @param role     Rol del usuario
     * @return token JWT firmado
     */
    public String generarToken(String username, String role) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("roles", List.of(role));
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    /**
     * Extrae el nombre de usuario del token.
     *
     * @param token JWT
     * @return nombre de usuario
     */
    public String obtenerUsername(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    /**
     * Valida un token JWT.
     *
     * @param token JWT
     * @return true si es válido, false si ha expirado o es incorrecto
     */
    public boolean validarToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(getSigningKey()).build().parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }
}
