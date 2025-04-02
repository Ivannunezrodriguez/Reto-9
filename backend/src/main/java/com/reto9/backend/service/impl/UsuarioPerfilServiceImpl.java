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
    public List<UsuarioPerfilDTO> findByUsername(String username) {
        return usuarioPerfilRepository.findByUsuarioUsername(username)
                .stream()
                .map(up -> new UsuarioPerfilDTO(
                        up.getId(),
                        up.getUsuario().getUsername(),
                        up.getPerfil().getIdPerfil()))
                .collect(Collectors.toList());
    }

    @Override
    public UsuarioPerfil save(UsuarioPerfil usuarioPerfil) {
        return usuarioPerfilRepository.save(usuarioPerfil);
    }
}
