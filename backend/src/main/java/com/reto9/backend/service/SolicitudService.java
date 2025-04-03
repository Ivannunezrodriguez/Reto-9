package com.reto9.backend.service;

import com.reto9.backend.dto.SolicitudDTO;

import java.util.List;

public interface SolicitudService {
    SolicitudDTO create(SolicitudDTO dto);
    List<SolicitudDTO> findAll();
    List<SolicitudDTO> findByUsuario(String username);
    List<SolicitudDTO> findByVacante(Integer idVacante);
    SolicitudDTO adjudicar(Integer idSolicitud);
    SolicitudDTO cancelar(Integer idSolicitud);
    SolicitudDTO findById(Integer id);
}
