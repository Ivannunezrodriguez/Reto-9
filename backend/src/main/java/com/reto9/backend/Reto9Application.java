package com.reto9.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal que lanza la aplicación Spring Boot para el proyecto Reto 9.
 *
 * <p>Esta clase actúa como el punto de entrada de la aplicación.
 * Contiene el método {@code main}, que inicia el contexto de Spring y configura todos los componentes.
 *
 * <p>Gracias a la anotación {@link SpringBootApplication}, se habilitan automáticamente:
 * <ul>
 *     <li>La configuración automática de Spring (auto-configuration).</li>
 *     <li>El escaneo de componentes en el paquete base y sus subpaquetes.</li>
 *     <li>La posibilidad de definir Beans adicionales si se necesitan.</li>
 * </ul>
 */
@SpringBootApplication
public class Reto9Application {

	/**
	 * Método principal que arranca la aplicación Spring Boot.
	 *
	 * @param args Argumentos de línea de comandos.
	 */
	public static void main(String[] args) {
		SpringApplication.run(Reto9Application.class, args);
	}
}
