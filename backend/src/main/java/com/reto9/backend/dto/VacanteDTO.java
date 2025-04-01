package com.reto9.backend.dto;

public class VacanteDTO {
    private int id;
    private String nombre;
    private String descripcion;
    private String detalles;
    private String ubicacion;
    private int idEmpresa;

    public VacanteDTO(int id, String nombre, String descripcion, String detalles, String ubicacion, int idEmpresa) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.detalles = detalles;
        this.ubicacion = ubicacion;
        this.idEmpresa = idEmpresa;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getDetalles() { return detalles; }
    public void setDetalles(String detalles) { this.detalles = detalles; }

    public String getUbicacion() { return ubicacion; }
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }

    public int getIdEmpresa() { return idEmpresa; }
    public void setIdEmpresa(int idEmpresa) { this.idEmpresa = idEmpresa; }
}
