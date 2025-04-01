package com.reto9.backend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usuarioPerfil")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioPerfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "username")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_perfil")
    private Perfil perfil;
}
