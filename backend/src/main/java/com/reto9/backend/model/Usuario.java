package com.reto9.backend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "usuarios")
@Data
public class Usuario {

    @Id
    private String username;

    private String nombre;
    private String apellidos;
    private String email;
    private String password;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_registro")
    private Date fechaRegistro;

    private int enabled;

    @OneToMany(mappedBy = "usuario")
    private List<Solicitud> solicitudes;

    @OneToMany(mappedBy = "usuario")
    private List<UsuarioPerfil> perfiles;
}
