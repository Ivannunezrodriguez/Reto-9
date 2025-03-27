package com.reto9.backend.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "solicitudes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSolicitud;

    @Temporal(TemporalType.DATE)
    private Date fecha;

    private String archivo;
    private String comentarios;
    private int estado; // 0: pendiente, 1: adjudicada

    @ManyToOne
    @JoinColumn(name = "id_vacante")
    private Vacante vacante;

    @ManyToOne
    @JoinColumn(name = "username")
    private Usuario usuario;
}
