package com.reto9.backend.service;

import com.reto9.backend.model.Usuario;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz de servicio para la gestión de usuarios del sistema.
 */
public interface UsuarioService {

    /**
     * Obtiene todos los usuarios registrados.
     */
    List<Usuario> findAll();

    /**
     * Busca un usuario por su nombre de usuario.
     */
    Optional<Usuario> findByUsername(String username);

    /**
     * Guarda o actualiza un usuario.
     */
    Usuario save(Usuario usuario);

    /**
     * Elimina un usuario por su nombre de usuario.
     */
    void deleteByUsername(String username);
}
