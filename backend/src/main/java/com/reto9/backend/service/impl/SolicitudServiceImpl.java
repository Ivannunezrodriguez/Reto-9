package com.reto9.backend.service.impl;

import com.reto9.backend.dto.SolicitudDTO;
import com.reto9.backend.model.Solicitud;
import com.reto9.backend.repository.SolicitudRepository;
import com.reto9.backend.service.SolicitudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SolicitudServiceImpl implements SolicitudService {

    private final SolicitudRepository solicitudRepository;

    @Override
    public List<SolicitudDTO> getAll() {
        return solicitudRepository.findAll()
                .stream()
                .map(s -> new SolicitudDTO(
                        s.getIdSolicitud(),
                        s.getComentarios(),
                        s.getFecha(),
                        s.getEstado(),
                        s.getUsuario().getUsername(),
                        s.getVacante().getIdVacante(),
                        s.getArchivo()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public List<SolicitudDTO> findByUsername(String username) {
        return solicitudRepository.findByUsuarioUsername(username).stream()
                .map(s -> new SolicitudDTO(
                        s.getIdSolicitud(),
                        s.getComentarios(),
                        s.getFecha(),
                        s.getEstado(),
                        s.getUsuario().getUsername(),
                        s.getVacante().getIdVacante(),
                                                s.getArchivo()

                ))
                .collect(Collectors.toList());
    }

    @Override
    public List<SolicitudDTO> findByVacante(int Vacante) {
        return solicitudRepository.findByVacanteId(Vacante).stream()
                .map(s -> new SolicitudDTO(
                        s.getIdSolicitud(),
                        s.getComentarios(),
                        s.getFecha(),
                        s.getEstado(),
                        s.getUsuario().getUsername(),
                        s.getVacante().getIdVacante()
                        ,
                        s.getArchivo()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public Solicitud save(Solicitud solicitud) {
        return solicitudRepository.save(solicitud);
    }

    @Override
    public Optional<Solicitud> findById(int id_solicitud) {
        return solicitudRepository.findById(id_solicitud);
    }

    @Override
    public void deleteById(int id_solicitud) {
        solicitudRepository.deleteById(id_solicitud);
    }
}
