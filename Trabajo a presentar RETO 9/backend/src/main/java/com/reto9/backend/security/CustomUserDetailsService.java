package com.reto9.backend.security;

import com.reto9.backend.model.Usuario;
import com.reto9.backend.model.UsuarioPerfil;
import com.reto9.backend.repository.UsuarioPerfilRepository;
import com.reto9.backend.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Servicio personalizado para la autenticación de usuarios mediante Spring Security.
 *
 * Implementa la interfaz {@link UserDetailsService} para cargar detalles del usuario desde la base de datos,
 * incluyendo sus credenciales y roles (perfiles).
 */
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioPerfilRepository usuarioPerfilRepository;

    /**
     * Carga los detalles del usuario a partir del nombre de usuario (username).
     *
     * Este método es invocado automáticamente por Spring Security durante el proceso de autenticación.
     *
     * @param username Nombre de usuario
     * @return UserDetails que contiene la información de autenticación del usuario
     * @throws UsernameNotFoundException si el usuario no existe
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Buscar al usuario en la base de datos
        Usuario usuario = usuarioRepository.findById(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        // Obtener roles del usuario desde la tabla usuarioperfil y convertirlos en autoridades (prefijados con "ROLE_")
        List<SimpleGrantedAuthority> roles = usuarioPerfilRepository.findByUsername(username).stream()
                .map(up -> new SimpleGrantedAuthority("ROLE_" + up.getPerfil().getNombre())) // Ej: ROLE_ADMIN, ROLE_USUARIO
                .collect(Collectors.toList());

        // Imprimir los roles obtenidos (útil para depuración en consola/log)
        System.out.println("Usuario " + username + " tiene los roles: " + roles);

        // Devolver un objeto User (implementación de UserDetails) con los datos del usuario y sus roles
        return new User(
                usuario.getUsername(),
                usuario.getPassword(),
                usuario.getEnabled() == 1, // habilitado
                true,  // cuenta no expirada
                true,  // credenciales no expiradas
                true,  // cuenta no bloqueada
                roles
        );
    }
}
