package com.reto9.backend.service.impl;

import com.reto9.backend.dto.UsuarioDTO;
import com.reto9.backend.model.Usuario;
import com.reto9.backend.repository.UsuarioRepository;
import com.reto9.backend.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService, UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public List<UsuarioDTO> findAllDTO() {
        return usuarioRepository.findAll()
                .stream()
                .map(u -> new UsuarioDTO(
                        u.getUsername(),
                        u.getNombre(),
                        u.getApellidos(),
                        u.getEmail(),
                        u.getFechaRegistro(),
                        u.getEnabled()))
                .collect(Collectors.toList());
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
    public void deshabilitarUsuario(String username) {
        usuarioRepository.findByUsername(username).ifPresent(user -> {
            user.setEnabled(0);
            usuarioRepository.save(user);
        });
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + username));
        return new User(usuario.getUsername(), usuario.getPassword(), Collections.emptyList());
    }
}
