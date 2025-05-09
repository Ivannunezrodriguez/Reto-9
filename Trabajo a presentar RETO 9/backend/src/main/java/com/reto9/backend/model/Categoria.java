package com.reto9.backend.model;

import jakarta.persistence.*;
import lombok.*;

/**
 * Entidad que representa una categoría de vacante en el sistema.
 * Las categorías permiten clasificar las vacantes por tipo o sector.
 */
@Entity
@Table(name = "categorias")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Categoria {

    /**
     * Identificador único de la categoría (clave primaria).
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Integer idCategoria;

    /**
     * Nombre de la categoría. No puede ser nulo.
     */
    @Column(length = 100, nullable = false)
    private String nombre;

    /**
     * Descripción extendida de la categoría (opcional).
     */
    @Column(length = 2000)
    private String descripcion;
}
