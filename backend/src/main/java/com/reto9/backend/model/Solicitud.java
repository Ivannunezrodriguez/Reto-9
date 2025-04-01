package com.reto9.backend.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Solicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(optional = false)
    private Usuario usuario;

    @ManyToOne(optional = false)
    private Vacante vacante;

    private String comentario;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSolicitud;

    @Column(nullable = false)
    private Integer estado = 0; // 0 = pendiente, 1 = adjudicada
}
