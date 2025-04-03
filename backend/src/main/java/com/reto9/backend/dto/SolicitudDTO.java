package com.reto9.backend.dto;

import lombok.*;
import java.util.Date;

/**
 * DTO (Data Transfer Object) para representar una solicitud de empleo.
 * Este objeto es utilizado para transferir información entre el backend y el frontend
 * sobre las solicitudes que los usuarios realizan a las vacantes.
 */
@Data // Genera automáticamente getters, setters, equals, hashCode y toString.
@NoArgsConstructor // Constructor vacío.
@AllArgsConstructor // Constructor con todos los campos.
@Builder // Implementación del patrón Builder para crear instancias fácilmente.
public class SolicitudDTO {

    /**
     * Identificador único de la solicitud.
     */
    private Integer idSolicitud;

    /**
     * Fecha en la que se realizó la solicitud.
     */
    private Date fecha;

    /**
     * Ruta o nombre del archivo adjunto (normalmente el currículum).
     */
    private String archivo;

    /**
     * Comentarios opcionales que el usuario desea agregar a la solicitud.
     */
    private String comentarios;

    /**
     * Estado de la solicitud:
     * 0 = Enviada
     * 1 = Adjudicada
     * 2 = Cancelada
     */
    private Integer estado;

    /**
     * Identificador de la vacante a la que se aplica.
     */
    private Integer idVacante;

    /**
     * Nombre de usuario del solicitante.
     */
    private String username;
}
