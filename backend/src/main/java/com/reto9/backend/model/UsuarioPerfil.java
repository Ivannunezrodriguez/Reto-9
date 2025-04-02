package com.reto9.backend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usuarioperfil")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioPerfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer idUsuarioPerfil;

    @Column(length = 45)
    private String username;

    @Column(name = "id_perfil")
    private Integer idPerfil;
}
