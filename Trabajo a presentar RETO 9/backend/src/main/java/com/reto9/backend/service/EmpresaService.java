package com.reto9.backend.service;

import com.reto9.backend.dto.EmpresaDTO;

import java.util.List;

/**
 * Interfaz que define los métodos del servicio para la gestión de empresas.
 * Proporciona operaciones para listar, consultar, crear, actualizar y eliminar
 * registros de empresas dentro del sistema de gestión de vacantes.
 */
public interface EmpresaService {

    /**
     * Obtiene la lista de todas las empresas registradas.
     *
     * @return Lista de objetos EmpresaDTO representando cada empresa.
     */
    List<EmpresaDTO> findAll();

    /**
     * Obtiene una empresa específica según su identificador.
     *
     * @param id Identificador único de la empresa.
     * @return Objeto EmpresaDTO correspondiente al ID, o null si no se encuentra.
     */
    EmpresaDTO findById(Integer id);

    /**
     * Guarda una nueva empresa en el sistema.
     *
     * @param dto Objeto EmpresaDTO con los datos de la empresa a registrar.
     * @return EmpresaDTO creada con el ID asignado por la base de datos.
     */
    EmpresaDTO save(EmpresaDTO dto);

    /**
     * Actualiza una empresa existente con nuevos datos.
     *
     * @param id Identificador único de la empresa a actualizar.
     * @param dto Objeto EmpresaDTO con los datos modificados.
     * @return EmpresaDTO actualizado.
     */
    EmpresaDTO update(Integer id, EmpresaDTO dto);

    /**
     * Elimina una empresa del sistema según su identificador.
     *
     * @param id Identificador único de la empresa a eliminar.
     */
    void delete(Integer id);
}
