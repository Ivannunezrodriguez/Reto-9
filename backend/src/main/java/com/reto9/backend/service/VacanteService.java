package com.reto9.backend.service;

import com.reto9.backend.dto.VacanteDTO;

import java.util.List;

/**
 * Servicio para gestionar las vacantes de empleo en el sistema.
 * Permite crear, actualizar, cancelar y consultar vacantes según distintos criterios.
 */
public interface VacanteService {

    /**
     * Crea una nueva vacante con estado inicial "CREADA".
     * Solo accesible por usuarios con rol EMPRESA.
     *
     * @param dto Datos de la vacante a crear.
     * @return VacanteDTO con la información de la vacante creada.
     */
    VacanteDTO create(VacanteDTO dto);

    /**
     * Actualiza los datos de una vacante existente.
     * Solo accesible por EMPRESA que publicó la vacante.
     *
     * @param id ID de la vacante a actualizar.
     * @param dto Nuevos datos para la vacante.
     * @return VacanteDTO actualizado.
     */
    VacanteDTO update(Integer id, VacanteDTO dto);

    /**
     * Cancela una vacante cambiando su estatus a "CANCELADA".
     * No se elimina de la base de datos.
     * Solo accesible por EMPRESA.
     *
     * @param id ID de la vacante a cancelar.
     */
    void cancel(Integer id);

    /**
     * Recupera todas las vacantes del sistema, sin filtrar por estatus.
     * Solo accesible por ADMIN.
     *
     * @return Lista de todas las vacantes.
     */
    List<VacanteDTO> findAll();

    /**
     * Recupera las vacantes creadas por una empresa específica.
     * Solo accesible por EMPRESA.
     *
     * @param idEmpresa ID de la empresa.
     * @return Lista de vacantes asociadas a esa empresa.
     */
    List<VacanteDTO> findByEmpresa(Integer idEmpresa);

    /**
     * Recupera las vacantes con estado "CREADA".
     * Solo accesible por USUARIO para ver vacantes disponibles.
     *
     * @return Lista de vacantes activas para postularse.
     */
    List<VacanteDTO> findCreadas();

    /**
     * Recupera una vacante específica por su ID.
     * Accesible por ADMIN o la EMPRESA que la publicó.
     *
     * @param id ID de la vacante.
     * @return VacanteDTO correspondiente, o null si no existe.
     */
    VacanteDTO findById(Integer id);
}
