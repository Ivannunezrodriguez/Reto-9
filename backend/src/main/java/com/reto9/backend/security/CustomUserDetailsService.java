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

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioPerfilRepository usuarioPerfilRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findById(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        List<SimpleGrantedAuthority> roles = usuarioPerfilRepository.findByUsername(username).stream()
                .map(up -> new SimpleGrantedAuthority("ROLE_" + up.getIdPerfil())) // o recuperar tipo desde Perfil
                .collect(Collectors.toList());

        return new User(usuario.getUsername(), usuario.getPassword(), usuario.getEnabled() == 1, true, true, true, roles);
    }
}
