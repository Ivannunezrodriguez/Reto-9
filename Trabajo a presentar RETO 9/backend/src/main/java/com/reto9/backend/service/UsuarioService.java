package com.reto9.backend.service;

import com.reto9.backend.dto.UsuarioDTO;

import java.util.List;

/**
 * Servicio para la gestión de usuarios del sistema.
 * Incluye funcionalidades como creación, consulta, actualización y desactivación de usuarios.
 */
public interface UsuarioService {

    /**
     * Recupera la lista de todos los usuarios registrados.
     * Normalmente usada por el administrador del sistema.
     *
     * @return Lista de objetos UsuarioDTO.
     */
    List<UsuarioDTO> findAll();

    /**
     * Busca un usuario específico por su nombre de usuario (username).
     *
     * @param username Nombre de usuario.
     * @return UsuarioDTO correspondiente, o null si no existe.
     */
    UsuarioDTO findByUsername(String username);

    /**
     * Registra un nuevo usuario en el sistema. No se incluye lógica de roles aquí.
     *
     * @param usuarioDTO Objeto con los datos del nuevo usuario.
     * @return El usuario registrado.
     */
    UsuarioDTO save(UsuarioDTO usuarioDTO);

    /**
     * Actualiza la información de un usuario existente.
     * Usualmente accesible por el propio usuario o por el administrador.
     *
     * @param username Username del usuario a actualizar.
     * @param usuarioDTO Objeto con los nuevos datos del usuario.
     * @return Usuario actualizado.
     */
    UsuarioDTO update(String username, UsuarioDTO usuarioDTO);

    /**
     * Desactiva (da de baja lógica) a un usuario estableciendo su campo `enabled` a 0.
     * Solo accesible por un ADMIN.
     *
     * @param username Username del usuario a desactivar.
     */
    void disable(String username);
}
