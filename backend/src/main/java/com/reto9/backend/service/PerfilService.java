package com.reto9.backend.service;

import com.reto9.backend.dto.PerfilDTO;

import java.util.List;

public interface PerfilService {
    List<PerfilDTO> findAll();
    PerfilDTO findById(Integer id);
    PerfilDTO save(PerfilDTO dto);
    PerfilDTO update(Integer id, PerfilDTO dto);
    void delete(Integer id);
}
