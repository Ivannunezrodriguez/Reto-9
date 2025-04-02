package com.reto9.backend.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PerfilDTO {
    private Integer idPerfil;
    private String tipo;
}
