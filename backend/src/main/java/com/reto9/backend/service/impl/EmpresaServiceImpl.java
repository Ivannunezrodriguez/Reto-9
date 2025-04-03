package com.reto9.backend.service.impl;

import com.reto9.backend.dto.EmpresaDTO;
import com.reto9.backend.model.Empresa;
import com.reto9.backend.repository.EmpresaRepository;
import com.reto9.backend.service.EmpresaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmpresaServiceImpl implements EmpresaService {

    private final EmpresaRepository empresaRepository;

    @Override
    public List<EmpresaDTO> findAll() {
        return empresaRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EmpresaDTO findById(Integer id) {
        return empresaRepository.findById(id)
                .map(this::toDTO)
                .orElse(null);
    }

    @Override
    public EmpresaDTO save(EmpresaDTO dto) {
        Empresa empresa = toEntity(dto);
        return toDTO(empresaRepository.save(empresa));
    }

    @Override
    public EmpresaDTO update(Integer id, EmpresaDTO dto) {
        Empresa empresa = empresaRepository.findById(id).orElseThrow();
        empresa.setRazonSocial(dto.getRazonSocial());
        empresa.setDireccionFiscal(dto.getDireccionFiscal());
        empresa.setPais(dto.getPais());
        return toDTO(empresaRepository.save(empresa));
    }

    @Override
    public void delete(Integer id) {
        empresaRepository.deleteById(id);
    }

    private EmpresaDTO toDTO(Empresa e) {
        return EmpresaDTO.builder()
                .idEmpresa(e.getIdEmpresa())
                .razonSocial(e.getRazonSocial())
                .direccionFiscal(e.getDireccionFiscal())
                .pais(e.getPais())
                .build();
    }

    private Empresa toEntity(EmpresaDTO dto) {
        return Empresa.builder()
                .idEmpresa(dto.getIdEmpresa())
                .razonSocial(dto.getRazonSocial())
                .direccionFiscal(dto.getDireccionFiscal())
                .pais(dto.getPais())
                .build();
    }
}
