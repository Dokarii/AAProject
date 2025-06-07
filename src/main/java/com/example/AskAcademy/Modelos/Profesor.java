package com.example.AskAcademy.Modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name = "profesores")
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_profesor")
    private Integer id;
    private String especialidad;

    @OneToMany(mappedBy = "profesor")
    @JsonBackReference
    private List<Curso> cursos;

    @OneToMany(mappedBy = "profesor", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "profesor-formularios")
    private List<Formulario> formularios;

    @OneToOne
    @JoinColumn(name = "fk_usuario", referencedColumnName = "id_usuario")
    @JsonBackReference(value = "profesor-usuario")
    private Usuario usuario;

    public Profesor() {
    }

    public Profesor(Integer id, String especialidad) {
        this.id = id;
        this.especialidad = especialidad;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getEspecialidad() {
        return especialidad;
    }
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public List<Formulario> getFormularios() {
        return formularios;
    }
    public void setFormularios(List<Formulario> formularios) {
        this.formularios = formularios;
    }
}
