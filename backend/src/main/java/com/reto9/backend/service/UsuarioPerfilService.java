package com.reto9.backend.service;

import com.reto9.backend.dto.UsuarioPerfilDTO;

import java.util.List;

public interface UsuarioPerfilService {
    List<UsuarioPerfilDTO> findAll();
    List<UsuarioPerfilDTO> findByUsername(String username);
    UsuarioPerfilDTO save(UsuarioPerfilDTO dto);
    void delete(Integer id);
}
