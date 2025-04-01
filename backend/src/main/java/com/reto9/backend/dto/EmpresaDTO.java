package com.reto9.backend.dto;

public class EmpresaDTO {
    private int id;
    private String razonSocial;
    private String pais;
    private String archivo;

    public EmpresaDTO(int id, String razonSocial, String pais, String archivo) {
        this.id = id;
        this.razonSocial = razonSocial;
        this.pais = pais;
        this.archivo = archivo;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getRazonSocial() { return razonSocial; }
    public void setRazonSocial(String razonSocial) { this.razonSocial = razonSocial; }

    public String getPais() { return pais; }
    public void setPais(String pais) { this.pais = pais; }

    public String getArchivo() { return archivo; }
    public void setArchivo(String archivo) { this.archivo = archivo; }
}
