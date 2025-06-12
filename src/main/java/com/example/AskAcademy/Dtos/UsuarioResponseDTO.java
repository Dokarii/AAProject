package com.example.AskAcademy.Dtos;

import com.example.AskAcademy.Modelos.Usuario;

public class UsuarioResponseDTO {
    private Integer id;
    private String nombre;
    private String email;
    private String telefono;
    private String tipoUsuario;

    public UsuarioResponseDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.nombre = usuario.getNombre();
        this.email = usuario.getEmail();
        this.telefono = usuario.getTelefono();
        this.tipoUsuario = usuario.getTipoUsuario().toString();
    }

    // Getters
    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }
}
