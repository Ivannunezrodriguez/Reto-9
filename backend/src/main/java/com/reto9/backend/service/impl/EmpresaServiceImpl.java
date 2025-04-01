package com.reto9.backend.service.impl;

import com.reto9.backend.dto.EmpresaDTO;
import com.reto9.backend.model.Empresa;
import com.reto9.backend.repository.EmpresaRepository;
import com.reto9.backend.service.EmpresaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmpresaServiceImpl implements EmpresaService {

    private final EmpresaRepository empresaRepository;

    @Override
    public List<EmpresaDTO> getAll() {
        return empresaRepository.findAll()
                .stream()
                .map(e -> new EmpresaDTO(
                        e.getId(),
                        e.getRazonSocial(),
                        e.getPais(),
                        e.getArchivo()
                ))
                .toList();
    }

    @Override
    public EmpresaDTO getById(Long id) {
        Empresa e = empresaRepository.findById(id).orElseThrow();
        return new EmpresaDTO(e.getId(), e.getRazonSocial(), e.getPais(), e.getArchivo());
    }
}
