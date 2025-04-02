package com.reto9.backend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "solicitudes")
@Data
public class Solicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_solicitud")
    private int idSolicitud;

    private String comentarios;

    @Temporal(TemporalType.DATE)
    private Date fecha;

    private String estado;
    private String archivo;

    @ManyToOne
    @JoinColumn(name = "username")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_vacante")
    private Vacante vacante;
}
