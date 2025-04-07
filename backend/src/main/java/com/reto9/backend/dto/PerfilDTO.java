package com.reto9.backend.dto;

import lombok.*;

/**
 * DTO (Data Transfer Object) para la entidad Perfil.
 * Se utiliza para transferir los datos relacionados con los perfiles de usuario
 * (como ADMIN, USUARIO o EMPRESA) entre las diferentes capas de la aplicación.
 */
@Data // Genera automáticamente getters, setters, toString, equals y hashCode.
@NoArgsConstructor // Genera constructor sin argumentos.
@AllArgsConstructor // Genera constructor con todos los argumentos.
@Builder // Permite construir objetos con el patrón Builder.
public class PerfilDTO {

    /**
     * Identificador único del perfil.
     */
    private Integer idPerfil;

    /**
     * Nombre del perfil. Ejemplo: "ADMIN", "USUARIO", "EMPRESA".
     */
    private String nombre;
}
