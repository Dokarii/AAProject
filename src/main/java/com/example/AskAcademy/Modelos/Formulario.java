package com.example.AskAcademy.Modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "formularios")
public class Formulario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_formulario")
    private Integer id;

    @Column(nullable = false, length = 200)
    private String titulo;

    @Column(length = 500)
    private String descripcion;

    @Column(name = "fecha_creacion", nullable = false)
    private String fechaCreacion;

    @Column(name = "fecha_limite")
    private String fechaLimite;

    @Column(nullable = false)
    private Boolean activo = true;

    @ManyToOne
    @JoinColumn(name = "fk_profesor", referencedColumnName = "id_profesor", nullable = false)
    @JsonBackReference(value = "profesor-formularios")
    private Profesor profesor;

    @ManyToOne
    @JoinColumn(name = "fk_materia", referencedColumnName = "id_materia", nullable = false)
    @JsonBackReference(value = "materia-formularios")
    private Materia materia;

    @OneToMany(mappedBy = "formulario", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "formulario-respuestas")
    private List<RespuestaFormulario> respuestas;

    public Formulario() {
    }

    public Formulario(Integer id, String titulo, String descripcion, String fechaCreacion,
                      String fechaLimite, Boolean activo, Profesor profesor, Materia materia) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.fechaLimite = fechaLimite;
        this.activo = activo;
        this.profesor = profesor;
        this.materia = materia;
    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(String fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public List<RespuestaFormulario> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(List<RespuestaFormulario> respuestas) {
        this.respuestas = respuestas;
    }
}