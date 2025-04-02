package com.reto9.backend.dto;

import java.util.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class SolicitudDTO {
    private int idSolicitud;
    private String comentarios;
    private Date fecha;
    private String estado;
    private String username;
    private int vacante;
    private String archivo;

    public SolicitudDTO(int idSolicitud, String comentarios, Date fecha, String estado, String username, int vacante , String archivo) {
        this.idSolicitud = idSolicitud;
        this.comentarios = comentarios;
        this.fecha = fecha;
        this.estado = estado;
        this.username = username;
        this.vacante = vacante;
        this.archivo = archivo;
    }

}
