package com.reto9.backend.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

/**
 * Entidad que representa a un usuario registrado en el sistema.
 * Contiene información básica de perfil, credenciales y estado de habilitación.
 */
@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {

    /**
     * Nombre de usuario único (clave primaria). Se utiliza como identificador principal.
     */
    @Id
    @Column(length = 45)
    private String username;

    /**
     * Nombre del usuario. Campo obligatorio.
     */
    @Column(length = 45, nullable = false)
    private String nombre;

    /**
     * Apellidos del usuario. Campo opcional.
     */
    @Column(length = 100)
    private String apellidos;

    /**
     * Dirección de correo electrónico del usuario. Campo opcional.
     */
    @Column(length = 100)
    private String email;

    /**
     * Contraseña cifrada del usuario. Campo obligatorio.
     */
    @Column(length = 100, nullable = false)
    private String password;

    /**
     * Estado de habilitación del usuario:
     * 1 = Activo, 0 = Inactivo (por ejemplo, por mal uso del sistema).
     */
    @Column(nullable = false)
    private int enabled;

    /**
     * Fecha en la que el usuario se registró en el sistema.
     */
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_registro")
    private Date fechaRegistro;
}
