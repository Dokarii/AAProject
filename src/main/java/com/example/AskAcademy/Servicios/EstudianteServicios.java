package com.example.AskAcademy.Servicios;

import com.example.AskAcademy.Modelos.Estudiante;
import com.example.AskAcademy.Repositorios.IEstudianteRepositorio;
import com.example.AskAcademy.Helpers.MensajesApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Java local
import java.util.List;
import java.util.Optional;

@Service
public class EstudianteServicios {
    @Autowired
    IEstudianteRepositorio repositorio;

    public Estudiante guardarEstudiante(Estudiante estudianteDatos) throws Exception {
        try {
            return this.repositorio.save(estudianteDatos);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public Estudiante modificarEstudiante(Integer id, Estudiante estudianteDatos) throws Exception {
        try {
            Optional<Estudiante> estudianteBuscado = this.repositorio.findById(id);

            if (estudianteBuscado.isPresent()) {
                Estudiante estudiante = estudianteBuscado.get();
                estudiante.setNota(estudianteDatos.getNota());
                return this.repositorio.save(estudiante);
            } else {
                throw new Exception(MensajesApi.ESTUDIANTE_NO_ENCONTRADO.getMensaje());
            }
        }catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public Estudiante buscarEstudiantePorId(Integer id) throws Exception {
        try {
            Optional<Estudiante> estudianteBuscado = this.repositorio.findById(id);
            if (estudianteBuscado.isPresent()) {
                return estudianteBuscado.get();
            } else {
                throw new Exception(MensajesApi.ESTUDIANTE_NO_ENCONTRADO.getMensaje());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public List<Estudiante> buscarTodosLosEstudiantes() throws Exception {
        try {
            return this.repositorio.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public boolean eliminarEstudiante(Integer id) throws Exception {
        try {
            Optional<Estudiante> estudianteBuscado = this.repositorio.findById(id);
            if (estudianteBuscado.isPresent()) {
                this.repositorio.deleteById(id);
                return true;
            } else {
                throw new Exception(MensajesApi.ESTUDIANTE_NO_ENCONTRADO.getMensaje());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}
