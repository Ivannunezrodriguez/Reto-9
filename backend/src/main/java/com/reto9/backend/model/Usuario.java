package com.reto9.backend.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    // Usuario.java
    @Id
    private String username;

    public String getUsername() { return username; }


    private String nombre;

    private String apellidos;

    private String email;

    private String password;

    private Integer enabled;

    @Column(name = "fecha_registro")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;

    @OneToMany(mappedBy = "usuario")
    private List<Solicitud> solicitudes;

    @OneToMany(mappedBy = "usuario")
    private List<UsuarioPerfil> perfiles;
}
