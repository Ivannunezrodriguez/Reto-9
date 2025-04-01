package com.reto9.backend.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "empresas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empresa")
    private Integer id;

    @Column(name = "razon_social", nullable = false)
    private String razonSocial;

    @Column(name = "direccion_fiscal")
    private String direccionFiscal;

    private String pais;

    @OneToMany(mappedBy = "empresa")
    private List<Vacante> vacantes;
}
