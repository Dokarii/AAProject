package com.example.AskAcademy.Servicios;

import com.example.AskAcademy.Modelos.Formulario;
import com.example.AskAcademy.Repositorios.IFormularioRepositorio;
import com.example.AskAcademy.Helpers.MensajesApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FormularioServicios {

    @Autowired
    IFormularioRepositorio repositorio;

    public Formulario guardarFormulario(Formulario formularioDatos) throws Exception {
        try {
            return this.repositorio.save(formularioDatos);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public Formulario modificarFormulario(Integer id, Formulario formularioDatos) throws Exception {
        try {
            return this.repositorio.findById(id)
                    .map(formulario -> {
                        formulario.setTitulo(formularioDatos.getTitulo());
                        formulario.setDescripcion(formularioDatos.getDescripcion());
                        formulario.setFechaLimite(formularioDatos.getFechaLimite());
                        formulario.setActivo(formularioDatos.getActivo());
                        formulario.setMateria(formularioDatos.getMateria());
                        return this.repositorio.save(formulario);
                    })
                    .orElseThrow(() -> new Exception("Formulario no encontrado"));
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public Formulario buscarFormularioPorId(Integer id) throws Exception {
        try {
            return this.repositorio.findById(id)
                    .orElseThrow(() -> new Exception("Formulario no encontrado"));
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public List<Formulario> buscarTodosLosFormularios() throws Exception {
        try {
            return this.repositorio.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public List<Formulario> buscarFormulariosPorProfesor(Integer profesorId) throws Exception {
        try {
            return this.repositorio.findByProfesorId(profesorId);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public List<Formulario> buscarFormulariosActivos() throws Exception {
        try {
            return this.repositorio.findByActivoTrue();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public void eliminarFormulario(Integer id) throws Exception {
        try {
            if (this.repositorio.existsById(id)) {
                this.repositorio.deleteById(id);
            } else {
                throw new Exception("Formulario no encontrado");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}