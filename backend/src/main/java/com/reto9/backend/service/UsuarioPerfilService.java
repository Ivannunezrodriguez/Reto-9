package com.reto9.backend.service;

import com.reto9.backend.dto.UsuarioPerfilDTO;

import java.util.List;

/**
 * Servicio para gestionar la relación entre usuarios y sus perfiles (roles).
 * Permite asignar perfiles (como ADMIN, EMPRESA o USUARIO) a los usuarios del sistema.
 */
public interface UsuarioPerfilService {

    /**
     * Obtiene todos los registros de usuarios con sus respectivos perfiles asignados.
     * Solo accesible por ADMIN.
     *
     * @return Lista de objetos UsuarioPerfilDTO.
     */
    List<UsuarioPerfilDTO> findAll();

    /**
     * Recupera los perfiles asignados a un usuario específico.
     *
     * @param username Nombre de usuario.
     * @return Lista de objetos UsuarioPerfilDTO relacionados con ese usuario.
     */
    List<UsuarioPerfilDTO> findByUsername(String username);

    /**
     * Asigna un nuevo perfil a un usuario. Si ya tiene ese perfil, debe evitarse duplicado.
     *
     * @param dto DTO con la información de la relación usuario-perfil.
     * @return La relación creada en forma de DTO.
     */
    UsuarioPerfilDTO save(UsuarioPerfilDTO dto);

    /**
     * Elimina una relación usuario-perfil a partir de su ID.
     *
     * @param id ID de la relación usuario-perfil.
     */
    void delete(Integer id);
}
