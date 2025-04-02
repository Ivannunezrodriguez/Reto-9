package com.reto9.backend.service;

import com.reto9.backend.dto.UsuarioDTO;

import java.util.List;

public interface UsuarioService {
    List<UsuarioDTO> findAll();
    UsuarioDTO findByUsername(String username);
    UsuarioDTO save(UsuarioDTO usuarioDTO);
    UsuarioDTO update(String username, UsuarioDTO usuarioDTO);
    void disable(String username); // cambia enabled a 0
}
