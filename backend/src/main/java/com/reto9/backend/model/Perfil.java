package com.reto9.backend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "perfiles")
@Data
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_perfil")
    private int idPerfil;

    private String nombre;

    @OneToMany(mappedBy = "perfil")
    private List<UsuarioPerfil> usuarioPerfiles;
}
