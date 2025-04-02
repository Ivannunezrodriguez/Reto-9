package com.reto9.backend.service;

import com.reto9.backend.dto.SolicitudDTO;
import com.reto9.backend.model.Solicitud;

import java.util.List;
import java.util.Optional;

public interface SolicitudService {
    List<SolicitudDTO> getAll();
    List<SolicitudDTO> findByUsername(String username);
    List<SolicitudDTO> findByVacante(int Vacante);
    Solicitud save(Solicitud solicitud);
    Optional<Solicitud> findById(int idSolicitud);
    void deleteById(int id_solicitud);
}
