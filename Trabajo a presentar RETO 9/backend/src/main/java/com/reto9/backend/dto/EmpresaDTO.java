package com.reto9.backend.dto;

import lombok.*;

/**
 * DTO (Data Transfer Object) para la entidad Empresa.
 * Este objeto es utilizado para transferir información de las empresas entre el backend y el frontend,
 * o entre capas del sistema.
 */
@Data // Genera automáticamente getters, setters, equals, hashCode y toString.
@NoArgsConstructor // Constructor por defecto sin argumentos.
@AllArgsConstructor // Constructor con todos los argumentos.
@Builder // Permite usar el patrón Builder para construir objetos.
public class EmpresaDTO {

    /**
     * Identificador único de la empresa.
     */
    private Integer idEmpresa;

    /**
     * Razón social de la empresa (nombre legal).
     */
    private String razonSocial;

    /**
     * Dirección fiscal de la empresa.
     */
    private String direccionFiscal;

    /**
     * País en el que está registrada la empresa.
     */
    private String pais;
}
