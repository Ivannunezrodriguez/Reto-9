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

    private String password;
    private String nombre;
    private String apellidos;
    private String email;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    private Integer enabled; // 1 = activo, 0 = inactivo

    private String roles; // "ADMIN", "USUARIO", etc.
}
