package com.example.AskAcademy.Helpers;

public enum EstadoAsistencia {
    PRESENTE("Presente"),
    AUSENTE("Ausente"),
    JUSTIFICADO("Justificado");

    private final String descripcion;

    EstadoAsistencia(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}