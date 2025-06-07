package com.example.AskAcademy.Modelos;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "materias")
public class Materia {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "id_materia")
    private Integer id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "id_curso", nullable = false)
    private Curso curso;

    @OneToMany(mappedBy = "materia", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "materia-formularios")
    private List<Formulario> formularios;

    public Materia() {
    }

    public Materia(Integer id, String nombre, Curso curso) {
        this.id = id;
        this.nombre = nombre;
        this.curso = curso;
    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Curso getCurso() {
        return curso;
    }
    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<Formulario> getFormularios() {
        return formularios;
    }
    public void setFormularios(List<Formulario> formularios) {
        this.formularios = formularios;
    }
}
