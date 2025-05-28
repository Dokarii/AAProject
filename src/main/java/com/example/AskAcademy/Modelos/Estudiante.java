package com.example.AskAcademy.Modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "estudiantes")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "id_estudiante")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "fk_usuario", referencedColumnName = "id_usuario", nullable = false)
    @JsonBackReference(value = "estudiante-usuario")
    private Usuario usuario;

    @Column(name = "nota", nullable = false)
    private Integer nota;

    @Column(name = "fechaNacimiento", nullable = false, length = 100)
    private String fechaNacimiento;

    @Column(name = "direccion", nullable = false, length = 255)
    private String direccion;

    public Estudiante() {
    }

    public Estudiante(Integer id, Usuario usuario, Integer nota, String fechaNacimiento, String direccion) {
        this.id = id;
        this.usuario = usuario;
        this.nota = nota;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Integer getNota() {
        return nota;
    }
    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
