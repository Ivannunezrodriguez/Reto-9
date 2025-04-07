package com.reto9.backend.rmiserver;

import com.reto9.backend.dto.VacanteDTO;
import com.reto9.backend.rmishared.VacanteServiceRMI;
import com.reto9.backend.service.VacanteService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class VacanteServiceRMIImpl extends UnicastRemoteObject implements VacanteServiceRMI {

    private final VacanteService vacanteService;
    private static int clientesConectados = 0;

    public VacanteServiceRMIImpl(VacanteService vacanteService) throws RemoteException {
        this.vacanteService = vacanteService;
    }

    @Override
    public List<VacanteDTO> listarVacantes() throws RemoteException {
        clientesConectados++;
        System.out.println("Cliente conectado. Total de clientes conectados: " + clientesConectados);
        return vacanteService.findAll();
    }

    @Override
    public VacanteDTO obtenerVacantePorId(Integer id) throws RemoteException {
        System.out.println("Cliente conectado y solicitando vacante con ID: " + id);
        return vacanteService.findById(id);
    }

    @Override
    public void cancelarVacante(Integer id) throws RemoteException {
        System.out.println("Cliente conectado y solicitando cancelar vacante con ID: " + id);
        vacanteService.cancel(id);
    }

    public static void clienteDesconectado() {
        clientesConectados--;
        System.out.println("Cliente desconectado. Total de clientes conectados: " + clientesConectados);
    }
}
