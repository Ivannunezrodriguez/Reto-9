package com.reto9.backend.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
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

    /**
     * Estado del usuario:
     * 1 = activo, 0 = inactivo (baja lógica)
     */
    private Integer enabled;

    /**
     * Rol del usuario:
     * Puede ser "ADMIN", "USUARIO", etc.
     */
    private String roles;
}
