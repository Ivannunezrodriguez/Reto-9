package com.reto9.backend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;
@Data
@Entity
@Table(name = "vacantes")

public class Vacante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vacante")
    private int idVacante;

    private double salario;
    private String descripcion;
    private String detalles;
    private Date fecha;
    private int destacado;
    private String nombre;
    @Column(name = "imagen_vacante")
    private String imagenVacante;

    @Enumerated(EnumType.STRING)
    @Column(name = "estatus")
    private EstatusVacante estatus;


    @ManyToOne
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    @OneToMany(mappedBy = "vacante")
    private List<Solicitud> solicitudes;


}
