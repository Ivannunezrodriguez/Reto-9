package com.reto9.backend.dto;

import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VacanteDTO {

    private Integer idVacante;
    private String nombre;
    private String descripcion;
    private Date fecha;
    private Double salario;
    private String estatus;
    private boolean destacado;
    private String imagen;
    private String detalles;
    private Integer idCategoria;
    private Integer idEmpresa;
}
