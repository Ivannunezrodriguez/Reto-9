package com.reto9.backend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usuario_perfil")
@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(UsuarioPerfilId.class)
public class UsuarioPerfil {

    @Id
    private String username;

    @Id
    @Column(name = "id_perfil")
    private Integer idPerfil;

    @ManyToOne
    @JoinColumn(name = "username", insertable = false, updatable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_perfil", insertable = false, updatable = false)
    private Perfil perfil;
}
