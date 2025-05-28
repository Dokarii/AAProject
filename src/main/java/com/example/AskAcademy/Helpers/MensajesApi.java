package com.example.AskAcademy.Helpers;

public enum MensajesApi {
    ERROR("Error"),
    SUCCESS("Éxito"),
    ESTUDIANTE_NO_ENCONTRADO("Estudiante no encontrado"),
    PROFESOR_NO_ENCONTRADO("Profesor no encontrado"),
    CURSO_NO_ENCONTRADO("Curso no encontrado"),
    MATERIA_NO_ENCONTRADA("Materia no encontrada"),
    USUARIO_NO_ENCONTRADO("Usuario no encontrado"),
    NOTA_NO_ENCONTRADA("Nota no encontrada");

    private final String mensaje;

    MensajesApi(String mensaje) {
        this.mensaje = mensaje;
    }
    public String getMensaje() {
        return mensaje;
    }
}
