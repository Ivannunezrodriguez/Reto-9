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

/**
 * Implementación del servicio para gestionar solicitudes de empleo.
 * Proporciona operaciones CRUD y reglas de negocio como adjudicar o cancelar solicitudes.
 */
@Service
@RequiredArgsConstructor
public class SolicitudServiceImpl implements SolicitudService {

    private final SolicitudRepository solicitudRepository;
    private final VacanteRepository vacanteRepository;

    /**
     * Crea una nueva solicitud en estado pendiente (estado = 0).
     * @param dto Datos de la solicitud a registrar
     * @return SolicitudDTO creada
     */
    @Override
    public SolicitudDTO create(SolicitudDTO dto) {
        Solicitud s = toEntity(dto);
        s.setEstado(0); // 0 = pendiente
        return toDTO(solicitudRepository.save(s));
    }

    /**
     * Devuelve todas las solicitudes del sistema (solo para administradores).
     * @return Lista de solicitudes en formato DTO
     */
    @Override
    public List<SolicitudDTO> findAll() {
        return solicitudRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    /**
     * Devuelve las solicitudes asociadas a un usuario.
     * @param username Nombre de usuario
     * @return Lista de solicitudes del usuario
     */
    @Override
    public List<SolicitudDTO> findByUsuario(String username) {
        return solicitudRepository.findByUsername(username).stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    /**
     * Devuelve las solicitudes asociadas a una vacante.
     * @param idVacante ID de la vacante
     * @return Lista de solicitudes relacionadas
     */
    @Override
    public List<SolicitudDTO> findByVacante(Integer idVacante) {
        return solicitudRepository.findByIdVacante(idVacante).stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    /**
     * Adjudica una solicitud (estado = 1) y actualiza la vacante como "ASIGNADA".
     * @param idSolicitud ID de la solicitud a adjudicar
     * @return SolicitudDTO actualizada
     */
    @Override
    public SolicitudDTO adjudicar(Integer idSolicitud) {
        Solicitud solicitud = solicitudRepository.findById(idSolicitud).orElseThrow();
        solicitud.setEstado(1); // 1 = adjudicada

        // Se actualiza el estado de la vacante también
        Vacante vacante = vacanteRepository.findById(solicitud.getIdVacante()).orElseThrow();
        vacante.setEstatus(Vacante.EstatusVacante.ASIGNADA);
        vacanteRepository.save(vacante);

        return toDTO(solicitudRepository.save(solicitud));
    }

    /**
     * Cancela una solicitud (estado = 2).
     * @param idSolicitud ID de la solicitud a cancelar
     * @return SolicitudDTO actualizada
     */
    @Override
    public SolicitudDTO cancelar(Integer idSolicitud) {
        Solicitud solicitud = solicitudRepository.findById(idSolicitud).orElseThrow();
        solicitud.setEstado(2); // 2 = cancelada
        return toDTO(solicitudRepository.save(solicitud));
    }

    /**
     * Busca una solicitud por su ID.
     * @param id ID de la solicitud
     * @return SolicitudDTO si existe, o null si no se encuentra
     */
    @Override
    public SolicitudDTO findById(Integer id) {
        return solicitudRepository.findById(id).map(this::toDTO).orElse(null);
    }

    /**
     * Convierte una entidad Solicitud a su DTO correspondiente.
     * @param s Entidad Solicitud
     * @return DTO de la solicitud
     */
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

    /**
     * Convierte un DTO de solicitud a su entidad correspondiente.
     * @param dto DTO de la solicitud
     * @return Entidad Solicitud
     */
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
