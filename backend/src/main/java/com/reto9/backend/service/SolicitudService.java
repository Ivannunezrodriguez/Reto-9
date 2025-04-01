package com.reto9.backend.service;

import com.reto9.backend.dto.SolicitudDTO;
import java.util.List;

public interface SolicitudService {
    List<SolicitudDTO> getAll();
}