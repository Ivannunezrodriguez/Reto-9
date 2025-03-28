package com.reto9.backend.service.impl;

import com.reto9.backend.model.Solicitud;
import com.reto9.backend.repository.SolicitudRepository;
import com.reto9.backend.service.SolicitudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SolicitudServiceImpl implements SolicitudService {

    private final SolicitudRepository solicitudRepository;

    @Override
    public List<Solicitud> findAll() {
        return solicitudRepository.findAll();
    }

    @Override
    public Optional<Solicitud> findById(Integer id) {
        return solicitudRepository.findById(id);
    }

    @Override
    public Solicitud save(Solicitud solicitud) {
        return solicitudRepository.save(solicitud);
    }

    @Override
    public void deleteById(Integer id) {
        solicitudRepository.deleteById(id);
    }
}
