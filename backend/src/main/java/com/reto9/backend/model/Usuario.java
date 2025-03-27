package com.reto9.backend.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    private String username;

    private String nombre;
    private String apellidos;
    private String email;
    private String password;

    private int enabled;

    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;

    // Este campo es útil para el JWT y para la carga de roles
    private String roles; // Ejemplo: "ADMIN", "USUARIO"
}
