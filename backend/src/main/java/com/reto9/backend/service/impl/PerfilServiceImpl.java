package com.reto9.backend.service.impl;

import com.reto9.backend.dto.PerfilDTO;
import com.reto9.backend.model.Perfil;
import com.reto9.backend.repository.PerfilRepository;
import com.reto9.backend.service.PerfilService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PerfilServiceImpl implements PerfilService {

    private final PerfilRepository perfilRepository;

    @Override
    public List<PerfilDTO> getAll() {
        return perfilRepository.findAll()
                .stream()
                .map(p -> new PerfilDTO(
                        p.getId(),
                        p.getNombre()
                ))
                .toList();
    }
}
