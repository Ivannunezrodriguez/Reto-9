package com.reto9.backend.service;


import com.reto9.backend.model.Usuario;

import java.util.List;

public interface UsuarioService {
    List<Usuario> findAll();

    Usuario save(Usuario usuario);

    Usuario update(String id, Usuario usuario);

    void delete(String id);
}
