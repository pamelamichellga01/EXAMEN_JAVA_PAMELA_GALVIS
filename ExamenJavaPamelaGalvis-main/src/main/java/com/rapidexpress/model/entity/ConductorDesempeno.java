package com.rapidexpress.model.entity;

/**
 * DTO de apoyo para reportes de rendimiento de conductores.
 */
public class ConductorDesempeno {
    private final int conductorId;
    private final String nombreCompleto;
    private final int totalEntregas;
    private final int posicion;

    public ConductorDesempeno(int conductorId, String nombreCompleto, int totalEntregas, int posicion) {
        this.conductorId = conductorId;
        this.nombreCompleto = nombreCompleto;
        this.totalEntregas = totalEntregas;
        this.posicion = posicion;
    }

    public int getConductorId() {
        return conductorId;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public int getTotalEntregas() {
        return totalEntregas;
    }

    public int getPosicion() {
        return posicion;
    }
}

