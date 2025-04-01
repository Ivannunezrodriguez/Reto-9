package com.reto9.backend.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "perfiles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_perfil")
    private Integer id;

    private String nombre;

    @OneToMany(mappedBy = "perfil")
    private List<UsuarioPerfil> usuarios;
}
