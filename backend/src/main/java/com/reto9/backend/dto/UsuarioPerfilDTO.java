package com.reto9.backend.dto;

import lombok.*;

/**
 * DTO para representar la relación entre un usuario y un perfil/rol en el sistema.
 * Este objeto se usa para transferir datos entre capas sin exponer directamente la entidad JPA.
 */
@Data // Genera automáticamente getters, setters, toString, equals y hashCode.
@NoArgsConstructor // Constructor vacío necesario para algunas operaciones (ej. deserialización).
@AllArgsConstructor // Constructor con todos los campos.
@Builder // Permite la construcción de objetos con patrón Builder.
public class UsuarioPerfilDTO {

    /**
     * ID único de la relación usuario-perfil.
     */
    private Integer idUsuarioPerfil;

    /**
     * Nombre de usuario que tiene asignado este perfil.
     */
    private String username;

    /**
     * ID del perfil asignado al usuario (referencia a la tabla perfiles).
     * Ejemplos: 1 = ADMIN, 2 = EMPRESA, 3 = USUARIO.
     */
    private Integer idPerfil;
}
