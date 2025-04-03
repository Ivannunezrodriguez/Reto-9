package com.reto9.backend.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "solicitudes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Solicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_solicitud")
    private Integer idSolicitud;

    @Temporal(TemporalType.DATE)
    private Date fecha;

    @Column(length = 250)
    private String archivo;

    @Column(length = 2000)
    private String comentarios;

    // Estado: 0 (pendiente), 1 (adjudicada), 2 (cancelada)
    private Integer estado;

    @Column(name = "id_vacante")
    private Integer idVacante;

    @Column(length = 45)
    private String username;
}
