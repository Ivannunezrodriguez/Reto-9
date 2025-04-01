package com.reto9.backend.dto;

public class UsuarioDTO {
    private String username;
    private String nombre;
    private String apellidos;
    private String email;
    private int enabled;

    public UsuarioDTO(String username, String nombre, String apellidos, String email, int enabled) {
        this.username = username;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.enabled = enabled;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }
}
