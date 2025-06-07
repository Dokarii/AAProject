package com.example.AskAcademy.Helpers;

public enum TipoUsuario {
    DOCENTE("Docente"),
    ESTUDIANTE("Estudiante");

    private String descripcion;
    
    TipoUsuario(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getdescripcion() {
        return descripcion;
    }
}
