package com.reto9.backend.dto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PerfilDTO {
    private int idPerfil;
    private String nombre;

    public PerfilDTO(int idPerfil, String nombre) {
        this.idPerfil = idPerfil;
        this.nombre = nombre;
    }

    // Getters y setters
}
