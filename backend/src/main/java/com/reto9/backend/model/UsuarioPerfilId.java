package com.reto9.backend.model;

import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioPerfilId implements Serializable {
    private String username;
    private Integer idPerfil;
}
