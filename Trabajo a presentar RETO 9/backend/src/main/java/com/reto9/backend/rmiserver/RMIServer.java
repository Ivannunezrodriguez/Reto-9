package com.reto9.backend.rmiserver;

import com.reto9.backend.rmishared.VacanteServiceRMI;
import com.reto9.backend.service.VacanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

@Component
public class RMIServer {

    private final ApplicationContext context;

    @Autowired
    public RMIServer(ApplicationContext context) {
        this.context = context;
    }

    public void start() {
        try {
            // Obtener el servicio VacanteService desde el contexto de Spring
            VacanteService vacanteService = context.getBean(VacanteService.class);

            // Iniciar el registro en el puerto 1099
            LocateRegistry.createRegistry(1099);

            // Crear e instanciar el servicio RMI
            VacanteServiceRMI servicio = new VacanteServiceRMIImpl(vacanteService);

            // Enlazar el servicio al registro
            Naming.rebind("rmi://localhost/VacanteService", servicio);

            System.out.println("Servidor RMI disponible en: rmi://localhost/VacanteService");

        } catch (Exception e) {
            System.err.println("Error iniciando el servidor RMI:");
            e.printStackTrace();
        }
    }
}
