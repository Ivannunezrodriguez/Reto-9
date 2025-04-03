package com.reto9.backend.model;

import jakarta.persistence.*;
import lombok.*;

/**
 * Entidad que representa un perfil o rol dentro del sistema.
 * Los perfiles determinan el nivel de acceso de los usuarios (por ejemplo: ADMIN, EMPRESA, USUARIO).
 */
@Entity
@Table(name = "perfiles")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Perfil {

    /**
     * Identificador único del perfil (clave primaria).
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_perfil")
    private Integer idPerfil;

    /**
     * Nombre del perfil, como "ADMIN", "EMPRESA" o "USUARIO".
     * Este campo es utilizado en la lógica de roles y seguridad.
     */
    @Column(name = "nombre")
    private String nombre;
}
