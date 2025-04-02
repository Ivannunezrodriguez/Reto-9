package com.reto9.backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioPerfilDTO {
    private int id;
    private String username;
    private int idPerfil;

    public UsuarioPerfilDTO(int id, String username, int idPerfil) {
        this.id = id;
        this.username = username;
        this.idPerfil = idPerfil;
    }


}
