package com.reto9.backend.dto;

import java.util.Date;

public class SolicitudDTO {
    private int id;
    private String comentarios;
    private Date fecha;
    private int estado;
    private String username;
    private int idVacante;

    public SolicitudDTO(int id, String comentarios, Date fecha, int estado, String username, int idVacante) {
        this.id = id;
        this.comentarios = comentarios;
        this.fecha = fecha;
        this.estado = estado;
        this.username = username;
        this.idVacante = idVacante;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getComentarios() { return comentarios; }
    public void setComentarios(String comentarios) { this.comentarios = comentarios; }

    public Date getFecha() { return fecha; }
    public void setFecha(Date fecha) { this.fecha = fecha; }

    public int getEstado() { return estado; }
    public void setEstado(int estado) { this.estado = estado; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public int getIdVacante() { return idVacante; }
    public void setIdVacante(int idVacante) { this.idVacante = idVacante; }
}