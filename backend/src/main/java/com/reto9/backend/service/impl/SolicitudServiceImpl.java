package com.reto9.backend.service.impl;


import com.reto9.backend.model.Solicitud;
import com.reto9.backend.repository.SolicitudRepository;
import com.reto9.backend.service.SolicitudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SolicitudServiceImpl implements SolicitudService {

    private final SolicitudRepository solicitudRepository;

    @Override
    public List<Solicitud> findAll() {
        return solicitudRepository.findAll();
    }

    @Override
    public Solicitud save(Solicitud solicitud) {
        return solicitudRepository.save(solicitud);
    }

    @Override
    public Solicitud update(Integer id, Solicitud solicitud) {
        solicitud.setIdSolicitud(id);
        return solicitudRepository.save(solicitud);
    }

    @Override
    public void delete(Integer id) {
        solicitudRepository.deleteById(id);
    }
}
