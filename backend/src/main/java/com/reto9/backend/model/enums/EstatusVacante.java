package com.reto9.backend.model.enums;

/**
 * Enumeración que define los posibles estados de una vacante.
 * Esta enum se utiliza para controlar el ciclo de vida de una vacante.
 */
public enum EstatusVacante {

    /**
     * La vacante ha sido creada pero aún no ha sido asignada ni cancelada.
     * Es visible para los usuarios para que puedan postularse.
     */
    CREADA,

    /**
     * La vacante ha sido cancelada por la empresa.
     * Ya no está disponible para nuevos postulantes, pero no se elimina de la base de datos.
     */
    CANCELADA,

    /**
     * La vacante ha sido asignada a un candidato.
     * Se considera cerrada y no aceptará más postulaciones.
     */
    ASIGNADA
}
