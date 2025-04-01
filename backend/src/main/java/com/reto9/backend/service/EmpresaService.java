package com.reto9.backend.service;

import com.reto9.backend.model.Empresa;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz de servicio para la gestión de entidades Empresa.
 */
public interface EmpresaService {

    /**
     * Devuelve una lista con todas las empresas.
     */
    List<Empresa> findAll();

    /**
     * Busca una empresa por su identificador.
     */
    Optional<Empresa> findById(Integer id);

    /**
     * Guarda o actualiza una empresa.
     */
    Empresa save(Empresa empresa);

    /**
     * Elimina una empresa por su ID.
     */
    void deleteById(Integer id);
}
