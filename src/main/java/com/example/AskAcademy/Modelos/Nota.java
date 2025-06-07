package com.example.AskAcademy.Modelos;

import jakarta.persistence.*;

@Entity
@Table(name = "notas")
public class Nota {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "id_nota")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_estudiante", nullable = false)
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "id_materia", nullable = false)
    private Materia materia;

    @Column(nullable = false)
    private Double calificacion;

    @Column(name = "fecha_evaluacion", nullable = false)
    private String fechaEvaluacion;

    public Nota() {
    }

    public Nota(Integer id, Estudiante estudiante, Materia materia, Double calificacion, String fechaEvaluacion) {
        this.id = id;
        this.estudiante = estudiante;
        this.materia = materia;
        this.calificacion = calificacion;
        this.fechaEvaluacion = fechaEvaluacion;
    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }
    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Materia getMateria() {
        return materia;
    }
    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Double getCalificacion() {
        return calificacion;
    }
    public void setCalificacion(Double calificacion) {
        this.calificacion = calificacion;
    }

    public String getFechaEvaluacion() {
        return fechaEvaluacion;
    }
    public void setFechaEvaluacion(String fechaEvaluacion) {
        this.fechaEvaluacion = fechaEvaluacion;
    }
}
