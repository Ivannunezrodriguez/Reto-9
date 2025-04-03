package com.reto9.backend.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "vacantes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vacante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVacante;

    @Column(length = 200, nullable = false)
    private String nombre;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Temporal(TemporalType.DATE)
    private Date fecha;

    private Double salario;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private EstatusVacante estatus;

    private Boolean destacado;

    @Column(length = 250)
    private String imagen;

    @Column(columnDefinition = "TEXT")
    private String detalles;

    @Column(name = "id_categoria")
    private Integer idCategoria;

    @Column(name = "id_empresa")
    private Integer idEmpresa;

    public enum EstatusVacante {
        CREADA, CANCELADA, ASIGNADA
    }
}
