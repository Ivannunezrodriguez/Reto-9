package com.reto9.backend.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

/**
 * Entidad que representa una solicitud de empleo realizada por un usuario para una vacante.
 * Incluye información sobre la fecha, archivo adjunto (como currículum), comentarios y estado de la solicitud.
 */
@Entity
@Table(name = "solicitudes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Solicitud {

    /**
     * Identificador único de la solicitud (clave primaria).
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_solicitud")
    private Integer idSolicitud;

    /**
     * Fecha en la que el usuario envió la solicitud.
     */
    @Temporal(TemporalType.DATE)
    private Date fecha;

    /**
     * Ruta o nombre del archivo adjunto (por ejemplo, currículum en PDF).
     */
    @Column(length = 250)
    private String archivo;

    /**
     * Comentarios opcionales proporcionados por el usuario al enviar la solicitud.
     */
    @Column(length = 2000)
    private String comentarios;

    /**
     * Estado de la solicitud:
     * 0 = Pendiente,
     * 1 = Adjudicada,
     * 2 = Cancelada.
     */
    private Integer estado;

    /**
     * Identificador de la vacante a la que se ha postulado el usuario.
     * Es una clave foránea hacia la entidad Vacante (no está mapeada como relación por simplicidad).
     */
    @Column(name = "id_vacante")
    private Integer idVacante;

    /**
     * Nombre de usuario del solicitante. Clave foránea hacia la entidad Usuario.
     * Almacena el username como texto, sin relación explícita.
     */
    @Column(length = 45)
    private String username;
}
