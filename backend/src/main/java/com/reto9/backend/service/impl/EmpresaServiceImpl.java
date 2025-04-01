package com.reto9.backend.service.impl;

import com.reto9.backend.model.Empresa;
import com.reto9.backend.repository.EmpresaRepository;
import com.reto9.backend.service.EmpresaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementación del servicio para la entidad Empresa.
 */
@Service
@RequiredArgsConstructor
public class EmpresaServiceImpl implements EmpresaService {

    private final EmpresaRepository empresaRepository;

    /**
     * Obtiene todas las empresas registradas.
     */
    @Override
    public List<Empresa> findAll() {
        return empresaRepository.findAll();
    }

    /**
     * Busca una empresa por ID.
     */
    @Override
    public Optional<Empresa> findById(Integer id) {
        return empresaRepository.findById(id);
    }

    /**
     * Crea o actualiza una empresa.
     */
    @Override
    public Empresa save(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    /**
     * Elimina una empresa por ID.
     */
    @Override
    public void deleteById(Integer id) {
        empresaRepository.deleteById(id);
    }
}
