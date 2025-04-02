package com.reto9.backend.service;

import com.reto9.backend.dto.PerfilDTO;
import com.reto9.backend.model.Perfil;

import java.util.List;
import java.util.Optional;

public interface PerfilService {
    List<PerfilDTO> findAllDTO();
    Perfil save(Perfil perfil);
    Optional<Perfil> findById(int idPerfil);
    void deleteById(int idPerfil);
}
