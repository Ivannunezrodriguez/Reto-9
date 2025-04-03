package com.reto9.backend.service.impl;

import com.reto9.backend.dto.UsuarioPerfilDTO;
import com.reto9.backend.model.UsuarioPerfil;
import com.reto9.backend.repository.UsuarioPerfilRepository;
import com.reto9.backend.service.UsuarioPerfilService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsuarioPerfilServiceImpl implements UsuarioPerfilService {

    private final UsuarioPerfilRepository usuarioPerfilRepository;

    @Override
    public List<UsuarioPerfilDTO> findAll() {
        return usuarioPerfilRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<UsuarioPerfilDTO> findByUsername(String username) {
        return usuarioPerfilRepository.findByUsername(username).stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UsuarioPerfilDTO save(UsuarioPerfilDTO dto) {
        return toDTO(usuarioPerfilRepository.save(toEntity(dto)));
    }

    @Override
    public void delete(Integer id) {
        usuarioPerfilRepository.deleteById(id);
    }

    private UsuarioPerfilDTO toDTO(UsuarioPerfil u) {
        return UsuarioPerfilDTO.builder()
                .idUsuarioPerfil(u.getIdUsuarioPerfil())
                .username(u.getUsername())
                .idPerfil(u.getIdPerfil())
                .build();
    }

    private UsuarioPerfil toEntity(UsuarioPerfilDTO dto) {
        return UsuarioPerfil.builder()
                .idUsuarioPerfil(dto.getIdUsuarioPerfil())
                .username(dto.getUsername())
                .idPerfil(dto.getIdPerfil())
                .build();
    }
}
