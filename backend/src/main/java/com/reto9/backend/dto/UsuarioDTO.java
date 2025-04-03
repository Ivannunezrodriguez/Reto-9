package com.reto9.backend.dto;

import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioDTO {
    private String username;
    private String nombre;
    private String apellidos;
    private String email;
    private int enabled;
    private Date fechaRegistro;
}
