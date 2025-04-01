package com.reto9.backend.service.impl;

import com.reto9.backend.model.Solicitud;
import com.reto9.backend.repository.SolicitudRepository;
import com.reto9.backend.service.SolicitudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementación del servicio para la entidad Solicitud.
 */
@Service
@RequiredArgsConstructor
public class SolicitudServiceImpl implements SolicitudService {

    private final SolicitudRepository solicitudRepository;

    /**
     * Devuelve todas las solicitudes existentes.
     */
    @Override
    public List<Solicitud> findAll() {
        return solicitudRepository.findAll();
    }

    /**
     * Busca una solicitud por su ID.
     */
    @Override
    public Optional<Solicitud> findById(Integer id) {
        return solicitudRepository.findById(id);
    }

    /**
     * Crea o actualiza una solicitud.
     */
    @Override
    public Solicitud save(Solicitud solicitud) {
        return solicitudRepository.save(solicitud);
    }

    /**
     * Elimina una solicitud por ID.
     */
    @Override
    public void deleteById(Integer id) {
        solicitudRepository.deleteById(id);
    }
}
