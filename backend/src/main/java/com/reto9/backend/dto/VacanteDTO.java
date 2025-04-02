package com.reto9.backend.dto;

import com.reto9.backend.model.EstatusVacante;
import lombok.Data;

import java.util.Date;

@Data
public class VacanteDTO {
    private int idVacante;
    private double salario;
    private String descripcion;
    private String imagenVacante;
    private String nombre;
    private EstatusVacante estatus;
    private int idEmpresa;
    private int idCategoria;
    private int destacado;
    private Date fecha;


}
