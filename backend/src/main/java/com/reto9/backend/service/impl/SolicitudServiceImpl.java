package com.reto9.backend.service.impl;

import com.reto9.backend.dto.SolicitudDTO;
import com.reto9.backend.model.Solicitud;
import com.reto9.backend.model.Vacante;
import com.reto9.backend.repository.SolicitudRepository;
import com.reto9.backend.repository.VacanteRepository;
import com.reto9.backend.service.SolicitudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SolicitudServiceImpl implements SolicitudService {

    private final SolicitudRepository solicitudRepository;
    private final VacanteRepository vacanteRepository;

    @Override
    public SolicitudDTO create(SolicitudDTO dto) {
        Solicitud s = toEntity(dto);
        s.setEstado(0); // pendiente
        return toDTO(solicitudRepository.save(s));
    }

    @Override
    public List<SolicitudDTO> findAll() {
        return solicitudRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<SolicitudDTO> findByUsuario(String username) {
        return solicitudRepository.findByUsername(username).stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<SolicitudDTO> findByVacante(Integer idVacante) {
        return solicitudRepository.findByIdVacante(idVacante).stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SolicitudDTO adjudicar(Integer idSolicitud) {
        Solicitud solicitud = solicitudRepository.findById(idSolicitud).orElseThrow();
        solicitud.setEstado(1); // adjudicada

        // también actualiza la vacante a "ASIGNADA"
        Vacante vacante = vacanteRepository.findById(solicitud.getIdVacante()).orElseThrow();
        vacante.setEstatus(Vacante.EstatusVacante.ASIGNADA);
        vacanteRepository.save(vacante);

        return toDTO(solicitudRepository.save(solicitud));
    }

    @Override
    public SolicitudDTO cancelar(Integer idSolicitud) {
        Solicitud solicitud = solicitudRepository.findById(idSolicitud).orElseThrow();
        solicitud.setEstado(2); // cancelada
        return toDTO(solicitudRepository.save(solicitud));
    }

    @Override
    public SolicitudDTO findById(Integer id) {
        return solicitudRepository.findById(id).map(this::toDTO).orElse(null);
    }

    private SolicitudDTO toDTO(Solicitud s) {
        return SolicitudDTO.builder()
                .idSolicitud(s.getIdSolicitud())
                .fecha(s.getFecha())
                .archivo(s.getArchivo())
                .comentarios(s.getComentarios())
                .estado(s.getEstado())
                .idVacante(s.getIdVacante())
                .username(s.getUsername())
                .build();
    }

    private Solicitud toEntity(SolicitudDTO dto) {
        return Solicitud.builder()
                .idSolicitud(dto.getIdSolicitud())
                .fecha(dto.getFecha())
                .archivo(dto.getArchivo())
                .comentarios(dto.getComentarios())
                .estado(dto.getEstado())
                .idVacante(dto.getIdVacante())
                .username(dto.getUsername())
                .build();
    }
}
