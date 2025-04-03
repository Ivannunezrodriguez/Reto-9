package com.reto9.backend;

import com.reto9.backend.service.VacanteService;
import com.reto9.backend.rmiserver.RMIServer;
import com.reto9.backend.service.impl.VacanteServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Clase principal que lanza la aplicación Spring Boot para el proyecto Reto 9.
 */
@SpringBootApplication
public class Reto9Application {

	/**
	 * Método principal que arranca la aplicación Spring Boot y el servidor RMI.
	 *
	 * @param args Argumentos de línea de comandos.
	 */
	public static void main(String[] args) {
		// Inicia el contexto de Spring Boot
		ConfigurableApplicationContext context = SpringApplication.run(Reto9Application.class, args);
		// Configura el servicio y lanza el servidor RMI
		RMIServer rmiServer = context.getBean(RMIServer.class);
		rmiServer.start();
	}
}
