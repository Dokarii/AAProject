package com.example.AskAcademy.Modelos;

import com.example.AskAcademy.Helpers.TipoUsuario;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer id;

//  @NotBlank(message = "El nombre es obligatorio")
    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(name = "email", unique = true)
    private String email;
    private String contrasena;
    private String telefono;
    @Enumerated(EnumType.STRING)
    private TipoUsuario tipoUsuario;

    @OneToOne(mappedBy = "usuario")
    @JsonBackReference(value = "profesor-usuario")
    private Profesor profesor;

    @OneToOne(mappedBy = "usuario")
    @JsonBackReference(value = "estudiante-usuario")
    private Profesor estudiante;

    public Usuario() {
    }

    public Usuario(Integer id, String nombre, String email, String contrasena, String telefono, TipoUsuario tipoUsuario)
    {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.contrasena = contrasena;
        this.telefono = telefono;
        this.tipoUsuario = tipoUsuario;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
