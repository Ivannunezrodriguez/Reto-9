package com.reto9.backend.repository;

import com.reto9.backend.model.Vacante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VacanteRepository extends JpaRepository<Vacante, Integer> {
    List<Vacante> findByEstatus(Vacante.EstatusVacante estatus);
    List<Vacante> findByIdEmpresa(Integer idEmpresa);
}
