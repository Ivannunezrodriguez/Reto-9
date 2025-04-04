package com.reto9.backend.dto;

import lombok.*;
import java.util.Date;

/**
 * DTO (Data Transfer Object) para representar a un usuario del sistema.
 * Se utiliza para transferir datos del usuario sin exponer entidades directamente.
 */

@Data // Genera getters, setters, equals, hashCode y toString automáticamente.
@NoArgsConstructor // Constructor sin argumentos.
@AllArgsConstructor // Constructor con todos los atributos.
@Builder // Permite crear objetos usando el patrón builder.
public class UsuarioDTO {

    /**
     * Nombre de usuario único que identifica al usuario en el sistema.
     */
    private String username;

    /**
     * Nombre propio del usuario.
     */
    private String nombre;

    /**
     * Apellidos del usuario.
     */
    private String apellidos;

    /**
     * Correo electrónico del usuario.
     */
    private String email;

    /**
     * Estado del usuario:
     * 1 = Activo
     * 0 = Inactivo o dado de baja.
     */
    private int enabled;

    /**
     * Fecha en que el usuario se registró en el sistema.
     */
    private Date fechaRegistro;
}
