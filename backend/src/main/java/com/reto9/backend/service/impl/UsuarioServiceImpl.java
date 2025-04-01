package com.reto9.backend.service.impl;

import com.reto9.backend.model.Usuario;
import com.reto9.backend.repository.UsuarioRepository;
import com.reto9.backend.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import com.reto9.backend.dto.UsuarioDTO;


import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService, UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario> findByUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }

    @Override
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public void deleteByUsername(String username) {
        usuarioRepository.deleteById(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + username));
        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_USER"); // Se ajusta en el filtro de perfil
        return new User(usuario.getUsername(), usuario.getPassword(), Collections.singletonList(authority));
    }
    @Override
    public List<UsuarioDTO> getAllUsuariosDTO() {
        return usuarioRepository.findAll()
                .stream()
                .map(u -> new UsuarioDTO(
                        u.getUsername(),
                        u.getNombre(),
                        u.getApellidos(),
                        u.getEmail(),
                        u.getEnabled()
                ))
                .toList();
    }

}
