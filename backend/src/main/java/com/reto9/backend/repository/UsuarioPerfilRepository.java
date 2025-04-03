package com.reto9.backend.repository;

import com.reto9.backend.model.UsuarioPerfil;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repositorio JPA para la entidad {@link UsuarioPerfil}.
 *
 * Gestiona la relación entre los usuarios y sus perfiles (roles) en el sistema.
 * Cada usuario puede tener uno o más perfiles asignados.
 *
 * Extiende {@link JpaRepository} para proporcionar métodos CRUD.
 *
 * Métodos personalizados:
 * - {@code findByUsername(String username)}: Devuelve todos los perfiles asignados a un usuario concreto.
 *
 * Tipo de entidad: UsuarioPerfil
 * Tipo de clave primaria: Integer
 */
public interface UsuarioPerfilRepository extends JpaRepository<UsuarioPerfil, Integer> {

    /**
     * Obtiene todos los perfiles asignados a un usuario específico.
     *
     * @param username nombre del usuario
     * @return lista de asignaciones de perfil del usuario
     */
    List<UsuarioPerfil> findByUsername(String username);
}
