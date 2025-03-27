package com.reto9.backend.service.impl;


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
    public List<Vacante> findAll() {
        return vacanteRepository.findAll();
    }

    @Override
    public Vacante save(Vacante vacante) {
        return vacanteRepository.save(vacante);
    }

    @Override
    public Vacante update(Integer id, Vacante vacante) {
        vacante.setIdVacante(id);
        return vacanteRepository.save(vacante);
    }

    @Override
    public void delete(Integer id) {
        vacanteRepository.deleteById(id);
    }
}
