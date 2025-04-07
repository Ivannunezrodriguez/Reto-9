package com.reto9.backend.repository;

import com.reto9.backend.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio JPA para la entidad {@link Usuario}.
 *
 * Proporciona operaciones CRUD para gestionar los datos de los usuarios del sistema.
 * La entidad {@link Usuario} utiliza como clave primaria el campo {@code username}, de tipo String.
 *
 * Métodos heredados útiles de JpaRepository:
 * - {@code findAll()}: lista todos los usuarios.
 * - {@code findById(String username)}: busca un usuario por su nombre de usuario.
 * - {@code save(Usuario usuario)}: guarda o actualiza un usuario.
 * - {@code deleteById(String username)}: elimina un usuario por su nombre de usuario.
 */
public interface UsuarioRepository extends JpaRepository<Usuario, String> {
}
