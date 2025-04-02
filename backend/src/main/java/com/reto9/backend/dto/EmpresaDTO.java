package com.reto9.backend.dto;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class EmpresaDTO {
    private int idEmpresa;
    private String razonSocial;
    private String direccionFiscal;
    private String pais;

    public EmpresaDTO(int idEmpresa, String razonSocial, String direccionFiscal, String pais) {
        this.idEmpresa = idEmpresa;
        this.razonSocial = razonSocial;
        this.direccionFiscal = direccionFiscal;
        this.pais = pais;
    }

    // Getters y setters
}
