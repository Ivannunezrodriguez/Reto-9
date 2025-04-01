package com.reto9.backend.service;

import com.reto9.backend.dto.UsuarioPerfilDTO;

import java.util.List;

public interface UsuarioPerfilService {
    List<UsuarioPerfilDTO> getPerfilesByUsuario(String username);
}
