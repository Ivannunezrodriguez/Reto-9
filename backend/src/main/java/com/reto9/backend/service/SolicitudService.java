package com.reto9.backend.service;


import com.reto9.backend.model.Solicitud;

import java.util.List;

public interface SolicitudService {
    List<Solicitud> findAll();

    Solicitud save(Solicitud solicitud);

    Solicitud update(Integer id, Solicitud solicitud);

    void delete(Integer id);
}
