package com.example.AskAcademy.Servicios;

import com.example.AskAcademy.Modelos.Usuario;
import com.example.AskAcademy.Repositorios.IUsuarioRepositorio;
import com.example.AskAcademy.Helpers.MensajesApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Java local
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicios {
    @Autowired
    IUsuarioRepositorio repository;

    public Usuario saveUsuario(Usuario UsuarioData) throws Exception {
        try {
            return this.repository.save(UsuarioData);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public Usuario modifyUsuario(Integer id, Usuario UsuarioDatos) throws Exception {
        try {
            Optional<Usuario> searchedUsuario = this.repository.findById(id);
            if (searchedUsuario.isPresent()) {
                searchedUsuario.get().setNombre(UsuarioDatos.getNombre());
                searchedUsuario.get().setEmail(UsuarioDatos.getEmail());
                searchedUsuario.get().setContrasena(UsuarioDatos.getContrasena());
                searchedUsuario.get().setTelefono(UsuarioDatos.getTelefono());
                searchedUsuario.get().setTipoUsuario(UsuarioDatos.getTipoUsuario());
                return this.repository.save(searchedUsuario.get());
            } else {
                throw new Exception(MensajesApi.USUARIO_NO_ENCONTRADO.getMensaje());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public Usuario searchUsuarioById(Integer id) throws Exception {
        try {
            Optional<Usuario> searchedUsuario = this.repository.findById(id);
            if (searchedUsuario.isPresent()) {
                return searchedUsuario.get();
            } else {
                throw new Exception(MensajesApi.USUARIO_NO_ENCONTRADO.getMensaje());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public List<Usuario> searchAllUsuarios() throws Exception {
        try {
            return this.repository.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public boolean deleteUsuario(Integer id) throws Exception {
        try {
            Optional<Usuario> searchedUsuario = this.repository.findById(id);
            if (searchedUsuario.isPresent()) {
                this.repository.deleteById(id);
                return true;
            } else {
                throw new Exception(MensajesApi.USUARIO_NO_ENCONTRADO.getMensaje());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

}
