package com.reto9.backend.model;

import jakarta.persistence.*;
import lombok.*;

/**
 * Entidad que representa una empresa registrada en el sistema.
 * Las empresas pueden publicar vacantes de empleo.
 */
@Entity
@Table(name = "empresas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Empresa {

    /**
     * Identificador único de la empresa (clave primaria).
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empresa")
    private Integer idEmpresa;

    /**
     * Razón social de la empresa. Es un campo obligatorio.
     */
    @Column(name = "razon_social", length = 45, nullable = false)
    private String razonSocial;

    /**
     * Dirección fiscal de la empresa. Campo opcional.
     */
    @Column(name = "direccion_fiscal", length = 45)
    private String direccionFiscal;

    /**
     * País donde se encuentra la sede de la empresa.
     */
    @Column(length = 45)
    private String pais;
}
