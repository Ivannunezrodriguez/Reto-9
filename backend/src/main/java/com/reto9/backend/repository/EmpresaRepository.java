package com.reto9.backend.repository;

import com.reto9.backend.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio JPA para la entidad Empresa.
 */
public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {
}
