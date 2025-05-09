package com.example.retobackend.service;

import com.example.retobackend.model.Usuario;

import java.util.List;

public interface UsuarioService {
    List<Usuario> obtenerTodos();
    Usuario guardarUsuario(Usuario usuario);
    Usuario obtenerUsuarioPorId(Long id);
    void eliminarUsuario(Long id);
}
