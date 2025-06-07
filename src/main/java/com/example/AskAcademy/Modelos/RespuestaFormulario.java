package com.example.AskAcademy.Modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "respuestas_formulario")
public class RespuestaFormulario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_respuesta")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "fk_formulario", referencedColumnName = "id_formulario", nullable = false)
    @JsonBackReference(value = "formulario-respuestas")
    private Formulario formulario;

    @ManyToOne
    @JoinColumn(name = "fk_estudiante", referencedColumnName = "id_estudiante", nullable = false)
    @JsonBackReference(value = "estudiante-respuestas")
    private Estudiante estudiante;

    @Column(name = "respuesta_texto", columnDefinition = "TEXT")
    private String respuestaTexto;

    @Column(name = "fecha_respuesta", nullable = false)
    private String fechaRespuesta;

    @Column(name = "calificacion")
    private Double calificacion;

    public RespuestaFormulario() {
    }

    public RespuestaFormulario(Integer id, Formulario formulario, Estudiante estudiante,
                               String respuestaTexto, String fechaRespuesta, Double calificacion) {
        this.id = id;
        this.formulario = formulario;
        this.estudiante = estudiante;
        this.respuestaTexto = respuestaTexto;
        this.fechaRespuesta = fechaRespuesta;
        this.calificacion = calificacion;
    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Formulario getFormulario() {
        return formulario;
    }

    public void setFormulario(Formulario formulario) {
        this.formulario = formulario;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public String getRespuestaTexto() {
        return respuestaTexto;
    }

    public void setRespuestaTexto(String respuestaTexto) {
        this.respuestaTexto = respuestaTexto;
    }

    public String getFechaRespuesta() {
        return fechaRespuesta;
    }

    public void setFechaRespuesta(String fechaRespuesta) {
        this.fechaRespuesta = fechaRespuesta;
    }

    public Double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Double calificacion) {
        this.calificacion = calificacion;
    }
}