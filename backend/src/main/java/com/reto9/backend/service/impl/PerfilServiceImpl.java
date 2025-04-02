package com.reto9.backend.service.impl;

import com.reto9.backend.dto.PerfilDTO;
import com.reto9.backend.model.Perfil;
import com.reto9.backend.repository.PerfilRepository;
import com.reto9.backend.service.PerfilService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PerfilServiceImpl implements PerfilService {

    private final PerfilRepository perfilRepository;

    @Override
    public List<PerfilDTO> findAll() {
        return perfilRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PerfilDTO findById(Integer id) {
        return perfilRepository.findById(id).map(this::toDTO).orElse(null);
    }

    @Override
    public PerfilDTO save(PerfilDTO dto) {
        return toDTO(perfilRepository.save(toEntity(dto)));
    }

    @Override
    public PerfilDTO update(Integer id, PerfilDTO dto) {
        Perfil perfil = perfilRepository.findById(id).orElseThrow();
        perfil.setTipo(dto.getTipo());
        return toDTO(perfilRepository.save(perfil));
    }

    @Override
    public void delete(Integer id) {
        perfilRepository.deleteById(id);
    }

    private PerfilDTO toDTO(Perfil perfil) {
        return PerfilDTO.builder()
                .idPerfil(perfil.getIdPerfil())
                .tipo(perfil.getTipo())
                .build();
    }

    private Perfil toEntity(PerfilDTO dto) {
        return Perfil.builder()
                .idPerfil(dto.getIdPerfil())
                .tipo(dto.getTipo())
                .build();
    }
}
