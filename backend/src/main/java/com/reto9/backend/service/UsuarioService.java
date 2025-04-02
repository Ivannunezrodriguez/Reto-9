package com.reto9.backend.service;

import com.reto9.backend.dto.UsuarioDTO;
import com.reto9.backend.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    List<UsuarioDTO> findAllDTO();
    List<Usuario> findAll();
    Optional<Usuario> findByUsername(String username);
    Usuario save(Usuario usuario);
    void deleteByUsername(String username);
    void deshabilitarUsuario(String username);
}
