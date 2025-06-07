package com.example.AskAcademy.Servicios;

import com.example.AskAcademy.Modelos.RespuestaFormulario;
import com.example.AskAcademy.Repositorios.IRespuestaFormularioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RespuestaFormularioServicios {

    @Autowired
    IRespuestaFormularioRepositorio repositorio;

    public RespuestaFormulario guardarRespuesta(RespuestaFormulario respuestaDatos) throws Exception {
        try {
            // Verificar si el estudiante ya respondió este formulario
            if (repositorio.existsByFormularioIdAndEstudianteId(
                    respuestaDatos.getFormulario().getId(),
                    respuestaDatos.getEstudiante().getId())) {
                throw new Exception("El estudiante ya ha respondido este formulario");
            }
            return this.repositorio.save(respuestaDatos);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public RespuestaFormulario modificarRespuesta(Integer id, RespuestaFormulario respuestaDatos) throws Exception {
        try {
            return this.repositorio.findById(id)
                    .map(respuesta -> {
                        respuesta.setRespuestaTexto(respuestaDatos.getRespuestaTexto());
                        respuesta.setCalificacion(respuestaDatos.getCalificacion());
                        return this.repositorio.save(respuesta);
                    })
                    .orElseThrow(() -> new Exception("Respuesta no encontrada"));
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public List<RespuestaFormulario> buscarRespuestasPorFormulario(Integer formularioId) throws Exception {
        try {
            return this.repositorio.findByFormularioId(formularioId);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public List<RespuestaFormulario> buscarRespuestasPorEstudiante(Integer estudianteId) throws Exception {
        try {
            return this.repositorio.findByEstudianteId(estudianteId);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public void eliminarRespuesta(Integer id) throws Exception {
        try {
            if (this.repositorio.existsById(id)) {
                this.repositorio.deleteById(id);
            } else {
                throw new Exception("Respuesta no encontrada");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}