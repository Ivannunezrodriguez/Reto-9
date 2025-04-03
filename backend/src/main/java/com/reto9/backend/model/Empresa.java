package com.reto9.backend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "empresas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empresa")
    private Integer idEmpresa;

    @Column(name = "razon_social", length = 45, nullable = false)
    private String razonSocial;

    @Column(name = "direccion_fiscal", length = 45)
    private String direccionFiscal;

    @Column(length = 45)
    private String pais;
}
