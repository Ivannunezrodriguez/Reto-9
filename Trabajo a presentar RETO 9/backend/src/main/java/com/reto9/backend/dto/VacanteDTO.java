package com.reto9.backend.dto;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * DTO (Data Transfer Object) que representa una vacante de empleo.
 * Se utiliza para transportar información entre capas sin exponer directamente la entidad.
 */
@Data // Genera getters, setters, toString, equals y hashCode.
@NoArgsConstructor // Constructor sin argumentos requerido por frameworks como Jackson.
@AllArgsConstructor // Constructor con todos los campos.
@Builder // Permite construir instancias de forma fluida.
public class VacanteDTO implements Serializable {
    private static final long serialVersionUID = 1L ;

    /**
     * Identificador único de la vacante.
     */
    private Integer idVacante;

    /**
     * Nombre o título de la vacante (ej. Desarrollador Java).
     */
    private String nombre;

    /**
     * Breve descripción de la vacante.
     */
    private String descripcion;

    /**
     * Fecha de publicación de la vacante.
     */
    private Date fecha;

    /**
     * Salario ofrecido para el puesto.
     */
    private Double salario;

    /**
     * Estatus actual de la vacante.
     * Ejemplos: "CREADA", "CANCELADA", "ASIGNADA".
     */
    private String estatus;

    /**
     * Indica si la vacante está destacada en la plataforma.
     */
    private boolean destacado;

    /**
     * Ruta o nombre del archivo de imagen asociado a la vacante.
     */
    private String imagen;

    /**
     * Detalles adicionales o condiciones del puesto.
     */
    private String detalles;

    /**
     * Identificador de la categoría a la que pertenece la vacante.
     */
    private Integer idCategoria;

    /**
     * Identificador de la empresa que publica la vacante.
     */
    private Integer idEmpresa;
}
