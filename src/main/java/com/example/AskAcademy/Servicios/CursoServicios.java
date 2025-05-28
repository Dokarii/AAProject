package com.example.AskAcademy.Servicios;

import com.example.AskAcademy.Modelos.Curso;
import com.example.AskAcademy.Repositorios.ICursoRepositorio;
import com.example.AskAcademy.Helpers.MensajesApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CursoServicios {

    @Autowired
    ICursoRepositorio repositorio;

    public Curso guardarCurso(Curso cursoDatos) throws Exception {
        try {
            return this.repositorio.save(cursoDatos);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public Curso modificarCurso(Integer id, Curso cursoDatos) throws Exception {
        try {
            return this.repositorio.findById(id)
                    .map(curso -> {
                        curso.setNombre(cursoDatos.getNombre());
                        return this.repositorio.save(curso);
                    })
                    .orElseThrow(() -> new Exception(MensajesApi.CURSO_NO_ENCONTRADO.getMensaje()));
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public Curso buscarCursoPorId(Integer id) throws Exception {
        try {
            return this.repositorio.findById(id)
                    .orElseThrow(() -> new Exception(MensajesApi.CURSO_NO_ENCONTRADO.getMensaje()));
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public List<Curso> buscarTodosLosCursos() throws Exception {
        try {
            return this.repositorio.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
    
    public void eliminarCurso(Integer id) throws Exception {
        try {
            if (this.repositorio.existsById(id)) {
                this.repositorio.deleteById(id);
            } else {
                throw new Exception(MensajesApi.CURSO_NO_ENCONTRADO.getMensaje());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}
