package com.reto9.backend.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "vacantes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vacante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVacante;

    private String nombre;
    private String descripcion;

    @Temporal(TemporalType.DATE)
    private Date fecha;

    private Double salario;

    @Enumerated(EnumType.STRING)
    private EstatusVacante estatus;

    private Boolean destacado;
    private String imagenVacante;
    private String detalles;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;
}
