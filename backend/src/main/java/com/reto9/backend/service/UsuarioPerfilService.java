package com.reto9.backend.service;

import com.reto9.backend.dto.UsuarioPerfilDTO;
import com.reto9.backend.model.UsuarioPerfil;

import java.util.List;

public interface UsuarioPerfilService {
    List<UsuarioPerfilDTO> findByUsername(String username);
    UsuarioPerfil save(UsuarioPerfil usuarioPerfil);
}
