package com.reto9.backend.service.impl;

import com.reto9.backend.dto.EmpresaDTO;
import com.reto9.backend.model.Empresa;
import com.reto9.backend.repository.EmpresaRepository;
import com.reto9.backend.service.EmpresaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmpresaServiceImpl implements EmpresaService {

    private final EmpresaRepository empresaRepository;

    @Override
    public List<EmpresaDTO> findAllDTO() {
        return empresaRepository.findAll().stream()
                .map(e -> new EmpresaDTO(
                        e.getIdEmpresa(),
                        e.getRazonSocial(),
                        e.getDireccionFiscal(),
                        e.getPais()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Empresa> findAll() {
        return empresaRepository.findAll();
    }

    @Override
    public Optional<Empresa> findById(int idEmpresa) {
        return empresaRepository.findById(idEmpresa);
    }

    @Override
    public Empresa save(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    @Override
    public void deleteById(int idEmpresa) {
        empresaRepository.deleteById(idEmpresa);
    }
}
