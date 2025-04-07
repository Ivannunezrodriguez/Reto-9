package com.reto9.backend.rmishared;

import com.reto9.backend.dto.VacanteDTO;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface VacanteServiceRMI extends Remote {
    List<VacanteDTO> listarVacantes() throws RemoteException;
    VacanteDTO obtenerVacantePorId(Integer id) throws RemoteException;
    void cancelarVacante(Integer id) throws RemoteException;
}
