package com.reto9.backend.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "usuario_perfil")
@Data
public class UsuarioPerfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "username")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_perfil")
    private Perfil perfil;
}
