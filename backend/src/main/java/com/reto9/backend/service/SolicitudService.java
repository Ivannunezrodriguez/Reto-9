package com.reto9.backend.service;

import com.reto9.backend.model.Solicitud;

import java.util.List;
import java.util.Optional;

public interface SolicitudService {
    List<Solicitud> findAll();
    Optional<Solicitud> findById(Integer id);
    Solicitud save(Solicitud solicitud);
    void deleteById(Integer id);
}
