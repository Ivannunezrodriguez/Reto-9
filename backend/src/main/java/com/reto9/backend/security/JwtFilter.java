package com.reto9.backend.security;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * Filtro personalizado para interceptar cada petición HTTP y verificar si incluye un JWT válido.
 *
 * Si el token es válido, establece el contexto de seguridad con la autenticación del usuario.
 */
@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil; // Utilidad para gestionar JWT (validación, extracción de usuario, etc.)
    private final CustomUserDetailsService userDetailsService; // Servicio para cargar los datos del usuario

    /**
     * Método principal del filtro. Se ejecuta en cada petición HTTP entrante.
     *
     * @param request  La petición HTTP
     * @param response La respuesta HTTP
     * @param filterChain La cadena de filtros que continúa después de este
     * @throws ServletException En caso de error en el procesamiento del servlet
     * @throws IOException En caso de error de E/S
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        // Obtener el valor del header Authorization
        String authHeader = request.getHeader("Authorization");

        // Verificar si existe y comienza con "Bearer "
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7); // Extraer solo el token (sin el "Bearer ")

            // Validar el token con JwtUtil
            if (jwtUtil.validateToken(token)) {
                // Extraer el username del token
                String username = jwtUtil.getUsernameFromToken(token);

                // Cargar los detalles del usuario desde la base de datos
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);

                // Crear el objeto de autenticación
                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());

                // Adjuntar detalles de la solicitud actual
                auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                // Establecer la autenticación en el contexto de seguridad
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        }

        // Continuar con el resto de filtros
        filterChain.doFilter(request, response);
    }
}
