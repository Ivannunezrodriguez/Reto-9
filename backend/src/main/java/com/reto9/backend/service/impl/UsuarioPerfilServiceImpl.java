package com.reto9.backend.service.impl;

import com.reto9.backend.dto.UsuarioPerfilDTO;
import com.reto9.backend.model.UsuarioPerfil;
import com.reto9.backend.repository.UsuarioPerfilRepository;
import com.reto9.backend.service.UsuarioPerfilService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioPerfilServiceImpl implements UsuarioPerfilService {

    private final UsuarioPerfilRepository usuarioPerfilRepository;

    @Override
    public List<UsuarioPerfilDTO> getPerfilesByUsuario(String username) {
        List<UsuarioPerfil> perfiles = usuarioPerfilRepository.findByUsuarioUsername(username);
        return perfiles.stream()
                .map(up -> new UsuarioPerfilDTO(
                        up.getUsuario().getUsername(),
                        up.getPerfil().getNombre()
                ))
                .toList();
    }
}
