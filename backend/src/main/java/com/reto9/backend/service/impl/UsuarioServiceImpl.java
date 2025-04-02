package com.reto9.backend.service.impl;

import com.reto9.backend.dto.UsuarioDTO;
import com.reto9.backend.model.Usuario;
import com.reto9.backend.repository.UsuarioRepository;
import com.reto9.backend.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public List<UsuarioDTO> findAll() {
        return usuarioRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UsuarioDTO findByUsername(String username) {
        return usuarioRepository.findById(username)
                .map(this::toDTO)
                .orElse(null);
    }

    @Override
    public UsuarioDTO save(UsuarioDTO dto) {
        Usuario usuario = toEntity(dto);
        return toDTO(usuarioRepository.save(usuario));
    }

    @Override
    public UsuarioDTO update(String username, UsuarioDTO dto) {
        Usuario usuario = usuarioRepository.findById(username).orElseThrow();
        usuario.setNombre(dto.getNombre());
        usuario.setApellidos(dto.getApellidos());
        usuario.setEmail(dto.getEmail());
        usuario.setEnabled(dto.getEnabled());
        usuario.setFechaRegistro(dto.getFechaRegistro());
        return toDTO(usuarioRepository.save(usuario));
    }

    @Override
    public void disable(String username) {
        Usuario usuario = usuarioRepository.findById(username).orElseThrow();
        usuario.setEnabled(0);
        usuarioRepository.save(usuario);
    }

    private UsuarioDTO toDTO(Usuario u) {
        return UsuarioDTO.builder()
                .username(u.getUsername())
                .nombre(u.getNombre())
                .apellidos(u.getApellidos())
                .email(u.getEmail())
                .enabled(u.getEnabled())
                .fechaRegistro(u.getFechaRegistro())
                .build();
    }

    private Usuario toEntity(UsuarioDTO dto) {
        return Usuario.builder()
                .username(dto.getUsername())
                .nombre(dto.getNombre())
                .apellidos(dto.getApellidos())
                .email(dto.getEmail())
                .enabled(dto.getEnabled())
                .fechaRegistro(dto.getFechaRegistro())
                .build();
    }
}
