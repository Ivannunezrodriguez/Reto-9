package com.reto9.backend.service.impl;

import com.reto9.backend.dto.VacanteDTO;
import com.reto9.backend.model.Vacante;
import com.reto9.backend.repository.VacanteRepository;
import com.reto9.backend.service.VacanteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VacanteServiceImpl implements VacanteService {

    private final VacanteRepository vacanteRepository;

    @Override
    public List<VacanteDTO> getAll() {
        return vacanteRepository.findAll()
                .stream()
                .map(v -> new VacanteDTO(
                        v.getId(),
                        v.getNombre(),
                        v.getDescripcion(),
                        v.getDetalles(),
                        v.getUbicacion(),
                        v.getEmpresa().getId()
                ))
                .toList();
    }

    @Override
    public List<VacanteDTO> getByEmpresaId(Long idEmpresa) {
        return vacanteRepository.findByEmpresaId(idEmpresa)
                .stream()
                .map(v -> new VacanteDTO(
                        v.getId(),
                        v.getNombre(),
                        v.getDescripcion(),
                        v.getDetalles(),
                        v.getUbicacion(),
                        v.getEmpresa().getId()
                ))
                .toList();
    }
}
