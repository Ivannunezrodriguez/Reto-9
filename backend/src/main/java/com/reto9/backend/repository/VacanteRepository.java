package com.reto9.backend.repository;


import com.reto9.backend.model.Vacante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacanteRepository extends JpaRepository<Vacante, Integer> {
}
