package com.reto9.backend.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioPerfilDTO {
    private Integer idUsuarioPerfil;
    private String username;
    private Integer idPerfil;
}
