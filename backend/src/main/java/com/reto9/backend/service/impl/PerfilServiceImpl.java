package com.reto9.backend.service.impl;

import com.reto9.backend.dto.PerfilDTO;
import com.reto9.backend.model.Perfil;
import com.reto9.backend.repository.PerfilRepository;
import com.reto9.backend.service.PerfilService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PerfilServiceImpl implements PerfilService {

    private final PerfilRepository perfilRepository;

    @Override
    public List<PerfilDTO> findAllDTO() {
        return perfilRepository.findAll().stream()
                .map(p -> new PerfilDTO(p.getIdPerfil(), p.getNombre()))
                .collect(Collectors.toList());
    }

    @Override
    public Perfil save(Perfil perfil) {
        return perfilRepository.save(perfil);
    }

    @Override
    public Optional<Perfil> findById(int idPerfil) {
        return perfilRepository.findById(idPerfil);
    }

    @Override
    public void deleteById(int idPerfil) {
        perfilRepository.deleteById(idPerfil);
    }
}
