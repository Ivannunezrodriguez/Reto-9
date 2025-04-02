package com.reto9.backend.dto;

import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SolicitudDTO {
    private Integer idSolicitud;
    private Date fecha;
    private String archivo;
    private String comentarios;
    private Integer estado;
    private Integer idVacante;
    private String username;
}
