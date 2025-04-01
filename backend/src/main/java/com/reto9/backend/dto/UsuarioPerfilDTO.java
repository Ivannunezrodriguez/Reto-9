package com.reto9.backend.dto;

public class UsuarioPerfilDTO {
    private String username;
    private String perfil;

    public UsuarioPerfilDTO(String username, String perfil) {
        this.username = username;
        this.perfil = perfil;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
}
