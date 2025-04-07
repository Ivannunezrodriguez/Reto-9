package com.reto9.backend.rmiserver;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Configuración de Spring Boot para iniciar solo el contexto y permitir
 * la inyección de servicios en el servidor RMI.
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.reto9.backend") // Escanea todos los paquetes necesarios
public class RMIServerConfig {
}
