package com.reto9.backend.dto;

import lombok.*;

/**
 * DTO (Data Transfer Object) para la entidad de Categoría.
 * Se utiliza para transferir datos entre las capas del sistema sin exponer la entidad directamente.
 */
@Data // Genera getters, setters, toString, equals y hashCode automáticamente
@NoArgsConstructor // Constructor sin argumentos
@AllArgsConstructor // Constructor con todos los argumentos
@Builder // Permite construir objetos de forma fluida usando el patrón Builder
public class CategoriaDTO {

    /**
     * Identificador único de la categoría.
     */
    private Integer idCategoria;

    /**
     * Nombre de la categoría.
     * Ejemplo: "Desarrollo Web", "Administración", etc.
     */
    private String nombre;

    /**
     * Descripción breve de la categoría.
     */
    private String descripcion;
}
