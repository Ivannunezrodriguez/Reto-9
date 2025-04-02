package com.reto9.backend.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoriaDTO {
    private Integer idCategoria;
    private String nombre;
    private String descripcion;
}
