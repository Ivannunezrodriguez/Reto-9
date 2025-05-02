package com.example.reto.model;

public class EmpresaVacante {
    private String nombre;
    private String cif;
    private String telefono;

    public EmpresaVacante(String nombre, String cif, String telefono) {
        this.nombre = nombre;
        this.cif = cif;
        this.telefono = telefono;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCif() { return cif; }
    public void setCif(String cif) { this.cif = cif; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
}
