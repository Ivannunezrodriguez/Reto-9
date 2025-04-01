package com.reto9.backend.model;

/**
 * Estados posibles de una vacante.
 */
public enum EstatusVacante {
    CREADA,      // Vacante recién publicada y disponible
    CANCELADA,   // Vacante cancelada por la empresa (no se elimina de BD)
    ASIGNADA     // Vacante adjudicada a un candidato
}
