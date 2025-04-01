package com.reto9.backend.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "solicitudes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Solicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_solicitud")
    private Integer id;

    @Temporal(TemporalType.DATE)
    private Date fecha;

    private String archivo;

    private String comentarios;

    private Integer estado; // 0 = pendiente, 1 = adjudicada

    @ManyToOne
    @JoinColumn(name = "id_vacante")
    private Vacante vacante;

    @ManyToOne
    @JoinColumn(name = "username")
    private Usuario usuario;
}
