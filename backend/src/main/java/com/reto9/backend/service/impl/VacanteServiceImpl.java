package com.reto9.backend.service.impl;

import com.reto9.backend.model.EstatusVacante;
import com.reto9.backend.model.Vacante;
import com.reto9.backend.repository.VacanteRepository;
import com.reto9.backend.service.VacanteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementación del servicio para la entidad Vacante.
 */
@Service
@RequiredArgsConstructor
public class VacanteServiceImpl implements VacanteService {

    private final VacanteRepository vacanteRepository;

    /**
     * Devuelve todas las vacantes existentes.
     */
    @Override
    public List<Vacante> findAll() {
        return vacanteRepository.findAll();
    }

    /**
     * Busca una vacante por ID.
     */
    @Override
    public Optional<Vacante> findById(Integer id) {
        return vacanteRepository.findById(id);
    }

    /**
     * Crea o actualiza una vacante.
     */
    @Override
    public Vacante save(Vacante vacante) {
        return vacanteRepository.save(vacante);
    }

    /**
     * Elimina una vacante por su ID.
     */
    @Override
    public void deleteById(Integer id) {
        vacanteRepository.deleteById(id);
    }

    /**
     * Devuelve las vacantes asociadas a una empresa específica.
     */
    @Override
    public List<Vacante> findByEmpresaId(Integer empresaId) {
        return vacanteRepository.findByEmpresaId(empresaId);
    }

    /**
     * Devuelve las vacantes que están en un estado determinado.
     */
    @Override
    public List<Vacante> findByEstatus(String estatus) {
        return vacanteRepository.findByEstatus(EstatusVacante.valueOf(estatus));
    }
}
