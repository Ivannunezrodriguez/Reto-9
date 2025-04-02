package com.reto9.backend.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmpresaDTO {
    private Integer idEmpresa;
    private String razonSocial;
    private String direccionFiscal;
    private String pais;
}
