package com.reto9.backend.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "vacantes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vacante {

    // Vacante.java
    @Id
    private int id; // o Integer

    public int getId() { return id; }


    private String nombre;

    private String descripcion;

    private String ubicacion;

    private Double salario;

    @Enumerated(EnumType.STRING)
    private EstatusVacante estatus;

    @Temporal(TemporalType.DATE)
    private Date fecha;

    private String imagen;

    private String detalles;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;

    @OneToMany(mappedBy = "vacante")
    private List<Solicitud> solicitudes;
}
