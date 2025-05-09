package com.reto9.backend.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Clase utilitaria para generar contraseñas encriptadas utilizando el algoritmo BCrypt.
 *
 * <p>Este utilitario es útil para:
 * <ul>
 *     <li>Crear contraseñas encriptadas manualmente para insertar en la base de datos.</li>
 *     <li>Probar la funcionalidad de encriptación antes de la autenticación real.</li>
 *     <li>Evitar almacenar contraseñas en texto plano.</li>
 * </ul>
 *
 * <strong>Importante:</strong> No debe ser utilizada en producción directamente,
 * sino solo con fines de prueba, desarrollo o configuración inicial del sistema.
 */
public class PasswordEncoderUtil {

    /**
     * Método principal que encripta una contraseña definida en la variable {@code rawPassword}
     * y la imprime por consola en formato BCrypt.
     *
     * @param args Argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        // Se crea un encriptador basado en el algoritmo BCrypt
        PasswordEncoder encoder = new BCryptPasswordEncoder();

        // Contraseña en texto plano a encriptar (modificar según necesidad)
        String rawPassword = "usuario";

        // Encriptación de la contraseña
        String encodedPassword = encoder.encode(rawPassword);

        // Impresión de la contraseña resultante
        System.out.println("BCrypt password for '" + rawPassword + "': " + encodedPassword);
    }
}
