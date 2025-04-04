package com.reto9.backend.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

/**
 * Entidad que representa una vacante de empleo publicada por una empresa.
 */
@Entity
@Table(name = "vacantes")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vacante {

    /**
     * ID autogenerado de la vacante.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVacante;

    /**
     * Nombre o título de la vacante.
     */
    @Column(length = 200, nullable = false)
    private String nombre;

    /**
     * Descripción general del puesto. Puede ser texto largo.
     */
    @Column(columnDefinition = "TEXT")
    private String descripcion;

    /**
     * Fecha en la que se publicó o creó la vacante.
     */
    @Temporal(TemporalType.DATE)
    private Date fecha;

    /**
     * Salario ofrecido para la vacante.
     */
    private Double salario;

    /**
     * Estado actual de la vacante: CREADA, CANCELADA o ASIGNADA.
     */
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private EstatusVacante estatus;

    /**
     * Indicador si la vacante es destacada en la interfaz.
     */
    private Boolean destacado;

    /**
     * Ruta o nombre del archivo de imagen asociado a la vacante.
     */
    @Column(length = 250)
    private String imagen;

    /**
     * Detalles adicionales sobre la vacante. Texto largo.
     */
    @Column(columnDefinition = "TEXT")
    private String detalles;

    /**
     * ID de la categoría asociada a esta vacante.
     */
    @Column(name = "id_categoria")
    private Integer idCategoria;

    /**
     * ID de la empresa que publica esta vacante.
     */
    @Column(name = "id_empresa")
    private Integer idEmpresa;

    /**
     * Enumeración de estados posibles para una vacante.
     * CREADA: Publicada y visible.
     * CANCELADA: Ya no disponible.
     * ASIGNADA: Ha sido cubierta por un candidato.
     */
    public enum EstatusVacante {
        CREADA, CANCELADA, ASIGNADA
    }
}
