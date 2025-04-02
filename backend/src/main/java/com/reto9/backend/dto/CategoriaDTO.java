package com.reto9.backend.dto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoriaDTO {
    private int idCategoria;
    private String nombre;
    private String descripcion;

    public CategoriaDTO(int idCategoria, String nombre, String descripcion) {
        this.idCategoria = idCategoria;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    // Getters y setters
}
