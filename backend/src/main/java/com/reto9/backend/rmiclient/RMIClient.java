package com.reto9.backend.rmiclient;

import com.reto9.backend.dto.VacanteDTO;
import com.reto9.backend.rmishared.VacanteServiceRMI;

import java.rmi.Naming;
import java.util.List;
import java.util.Scanner;

public class RMIClient {
    public static void main(String[] args) {
        try {
            VacanteServiceRMI servicio = (VacanteServiceRMI) Naming.lookup("rmi://localhost/VacanteService");

            // Mostrar las vacantes disponibles
            List<VacanteDTO> vacantes = servicio.listarVacantes();

            System.out.println("🧾 Lista de Vacantes disponibles:");
            System.out.println("------------------------------------------------------");
            System.out.printf("%-5s %-30s %-10s\n", "ID", "Nombre", "Salario");
            System.out.println("------------------------------------------------------");

            for (VacanteDTO v : vacantes) {
                System.out.printf("%-5d %-30s %.2f\n", v.getIdVacante(), v.getNombre(), v.getSalario());
            }

            // Solicitar al usuario un ID para consultar una vacante
            Scanner scanner = new Scanner(System.in);
            System.out.print("\nIntroduce el ID de la vacante que deseas consultar: ");
            int id = scanner.nextInt();

            // Consultar vacante por ID
            VacanteDTO vacante = servicio.obtenerVacantePorId(id);

            if (vacante != null) {
                // Mostrar detalles de la vacante consultada
                System.out.println("\n📝 Detalles de la vacante:");
                System.out.println("------------------------------------------------------");
                System.out.printf("ID: %-5d\n", vacante.getIdVacante());
                System.out.printf("Nombre: %-30s\n", vacante.getNombre());
                System.out.printf("Salario: %.2f\n", vacante.getSalario());
            } else {
                System.out.println("No se encontró la vacante con el ID proporcionado.");
            }

        } catch (Exception e) {
            System.out.println("Error al conectar con el servidor RMI:");
            e.printStackTrace();
        }
    }
}
