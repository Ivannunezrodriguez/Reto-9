package com.reto9.backend.model;

import jakarta.persistence.*;
import lombok.*;

/**
 * Entidad que representa la relación entre un usuario y un perfil (rol).
 * Se utiliza para asignar uno o más perfiles a un usuario.
 */
@Entity
@Table(name = "usuarioperfil")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioPerfil {

    /**
     * ID autogenerado de la relación usuario-perfil.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer idUsuarioPerfil;

    /**
     * Nombre de usuario al que se le asigna el perfil.
     * Corresponde a la clave primaria en la entidad Usuario.
     */
    @Column(length = 45)
    private String username;

    /**
     * Relación con la entidad Perfil.
     * Se realiza join sobre la columna id_perfil, pero no se actualiza ni inserta desde aquí.
     * Permite acceder a los datos del perfil (por ejemplo, su nombre).
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_perfil", insertable = false, updatable = false)
    private Perfil perfil;
}
