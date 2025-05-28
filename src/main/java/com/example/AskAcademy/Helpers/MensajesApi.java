package com.example.AskAcademy.Helpers;

public enum MensajesApi {
    ERROR("Error"),
    SUCCESS("Éxito"),
    USER_NOT_FOUND("Usuario no encontrado"),
    USER_ALREADY_EXISTS("El usuario ya existe"),
    INVALID_CREDENTIALS("Credenciales inválidas"),
    COURSE_NOT_FOUND("Curso no encontrado"),
    COURSE_ALREADY_EXISTS("El curso ya existe"),
    ASSIGNMENT_NOT_FOUND("Asignación no encontrada"),
    ASSIGNMENT_ALREADY_EXISTS("La asignación ya existe"),
    GRADE_NOT_FOUND("Nota no encontrada"),
    GRADE_ALREADY_EXISTS("La nota ya existe");

    private final String mensaje;

    MensajesApi(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getmensaje() {
        return mensaje;
    }
}
