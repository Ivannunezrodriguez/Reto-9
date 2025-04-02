package com.reto9.backend.dto;

import java.util.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class UsuarioDTO {
    private String username;
    private String nombre;
    private String apellidos;
    private String email;
    private Date fechaRegistro;
    private int enabled;

    public UsuarioDTO(String username, String nombre, String apellidos, String email, Date fechaRegistro, int enabled) {
        this.username = username;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.fechaRegistro = fechaRegistro;
        this.enabled = enabled;
    }

}
