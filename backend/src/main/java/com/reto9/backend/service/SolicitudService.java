package com.reto9.backend.service;

import com.reto9.backend.dto.SolicitudDTO;

import java.util.List;

/**
 * Interfaz de servicio para gestionar las solicitudes de los usuarios a las vacantes publicadas.
 * Las solicitudes representan postulaciones de usuarios a empleos.
 */
public interface SolicitudService {

    /**
     * Crea una nueva solicitud con estado inicial "pendiente" (estado = 0).
     *
     * @param dto Objeto SolicitudDTO con los datos de la solicitud.
     * @return La solicitud creada con su ID asignado.
     */
    SolicitudDTO create(SolicitudDTO dto);

    /**
     * Recupera todas las solicitudes del sistema. Solo disponible para el rol ADMIN.
     *
     * @return Lista completa de objetos SolicitudDTO.
     */
    List<SolicitudDTO> findAll();

    /**
     * Recupera las solicitudes realizadas por un usuario específico.
     *
     * @param username Nombre de usuario.
     * @return Lista de solicitudes hechas por ese usuario.
     */
    List<SolicitudDTO> findByUsuario(String username);

    /**
     * Recupera las solicitudes asociadas a una vacante específica.
     *
     * @param idVacante ID de la vacante.
     * @return Lista de solicitudes a esa vacante.
     */
    List<SolicitudDTO> findByVacante(Integer idVacante);

    /**
     * Adjudica una solicitud: cambia su estado a adjudicada (estado = 1),
     * y cambia el estado de la vacante a "ASIGNADA".
     *
     * @param idSolicitud ID de la solicitud a adjudicar.
     * @return Solicitud actualizada.
     */
    SolicitudDTO adjudicar(Integer idSolicitud);

    /**
     * Cancela una solicitud cambiando su estado a cancelada (estado = 2).
     *
     * @param idSolicitud ID de la solicitud a cancelar.
     * @return Solicitud actualizada.
     */
    SolicitudDTO cancelar(Integer idSolicitud);

    /**
     * Busca una solicitud por su ID.
     *
     * @param id ID de la solicitud.
     * @return Solicitud encontrada o null si no existe.
     */
    SolicitudDTO findById(Integer id);
}
