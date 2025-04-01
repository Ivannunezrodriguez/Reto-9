package com.reto9.backend.repository;

import com.reto9.backend.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Repositorio JPA para la entidad Usuario.
 * Permite operaciones CRUD y búsqueda por nombre de usuario.
 */
public interface UsuarioRepository extends JpaRepository<Usuario, String> {

    /**
     * Buscar un usuario por su nombre de usuario (username).
     */
    Optional<Usuario> findByUsername(String username);
}
