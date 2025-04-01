package com.reto9.backend.service.impl;

import com.reto9.backend.dto.SolicitudDTO;
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
    public List<SolicitudDTO> getAll() {
        return solicitudRepository.findAll()
                .stream()
                .map(s -> new SolicitudDTO(
                        s.getId(),
                        s.getComentarios(),
                        s.getFecha(),
                        s.getEstado(),
                        s.getUsuario().getUsername(),
                        s.getVacante().getId()
                ))
                .toList();
    }
}
