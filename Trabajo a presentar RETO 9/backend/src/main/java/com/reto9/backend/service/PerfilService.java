package com.reto9.backend.service;

import com.reto9.backend.dto.PerfilDTO;

import java.util.List;

/**
 * Interfaz para el servicio de gestión de perfiles de usuario.
 * Los perfiles representan los distintos roles del sistema como ADMIN, EMPRESA o USUARIO.
 */
public interface PerfilService {

    /**
     * Devuelve la lista de todos los perfiles disponibles en el sistema.
     *
     * @return Lista de objetos PerfilDTO.
     */
    List<PerfilDTO> findAll();

    /**
     * Busca un perfil por su identificador único.
     *
     * @param id ID del perfil a consultar.
     * @return Objeto PerfilDTO correspondiente o null si no se encuentra.
     */
    PerfilDTO findById(Integer id);

    /**
     * Registra un nuevo perfil en el sistema.
     *
     * @param dto Objeto PerfilDTO con los datos del perfil a guardar.
     * @return El perfil guardado con su ID asignado.
     */
    PerfilDTO save(PerfilDTO dto);

    /**
     * Actualiza los datos de un perfil existente.
     *
     * @param id ID del perfil a actualizar.
     * @param dto Objeto PerfilDTO con los nuevos datos.
     * @return El perfil actualizado.
     */
    PerfilDTO update(Integer id, PerfilDTO dto);

    /**
     * Elimina un perfil del sistema por su ID.
     *
     * @param id ID del perfil a eliminar.
     */
    void delete(Integer id);
}
