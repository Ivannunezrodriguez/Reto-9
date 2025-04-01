package com.reto9.backend.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Clase utilitaria para generar contraseñas encriptadas con BCrypt.
 * Uso recomendado solo para pruebas y generación manual de contraseñas.
 */
public class PasswordEncoderUtil {

    public static void main(String[] args) {
        PasswordEncoder encoder = new BCryptPasswordEncoder();

        String rawPassword = "admin"; // Cambia aquí la contraseña que quieras encriptar
        String encodedPassword = encoder.encode(rawPassword);

        System.out.println("BCrypt password for '" + rawPassword + "': " + encodedPassword);
    }
}
