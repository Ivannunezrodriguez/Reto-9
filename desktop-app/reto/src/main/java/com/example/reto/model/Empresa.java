package com.example.reto.model;

public class Empresa {

    private Long id;
    private String nombre;
    private String cif;
    private String telefono;

    public Empresa() {
        // Constructor vacío necesario para JavaFX y para deserialización JSON
    }

    public Empresa(String nombre, String cif, String telefono) {
        this.nombre = nombre;
        this.cif = cif;
        this.telefono = telefono;
    }

    public Empresa(Long id, String nombre, String cif, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.cif = cif;
        this.telefono = telefono;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return nombre + " (" + cif + ")";
    }
}
