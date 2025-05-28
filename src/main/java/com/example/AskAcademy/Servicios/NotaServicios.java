package com.example.AskAcademy.Servicios;

import com.example.AskAcademy.Modelos.Nota;
import com.example.AskAcademy.Repositorios.INotaRepositorio;
import com.example.AskAcademy.Helpers.MensajesApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Java local
import java.util.List;
import java.util.Optional;

@Service
public class NotaServicios {
    @Autowired
    INotaRepositorio repositorio;

    public Nota guardarNota(Nota notaDatos) throws Exception {
        try {
            return this.repositorio.save(notaDatos);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public Nota modificarNota(Integer id, Nota notaDatos) throws Exception {
        try {
            Optional<Nota> notaEncontrada = this.repositorio.findById(id);
            if (notaEncontrada.isPresent()) {
                notaEncontrada.get().setEstudiante(notaDatos.getEstudiante());
                notaEncontrada.get().setMateria(notaDatos.getMateria());
                notaEncontrada.get().setCalificacion(notaDatos.getCalificacion());
                notaEncontrada.get().setFechaEvaluacion(notaDatos.getFechaEvaluacion());
                return this.repositorio.save(notaEncontrada.get());
            } else {
                throw new Exception(MensajesApi.NOTA_NO_ENCONTRADA.getMensaje());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public Nota buscarNotaPorId(Integer id) throws Exception {
        try {
            Optional<Nota> notaEncontrada = this.repositorio.findById(id);
            if (notaEncontrada.isPresent()) {
                return notaEncontrada.get();
            } else {
                throw new Exception(MensajesApi.NOTA_NO_ENCONTRADA.getMensaje());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public List<Nota> buscarTodasLasNotas() throws Exception {
        try {
            return this.repositorio.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public boolean eliminarNota(Integer id) throws Exception {
        try {
            Optional<Nota> notaEncontrada = this.repositorio.findById(id);
            if (notaEncontrada.isPresent()) {
                this.repositorio.deleteById(id);
                return true;
            } else {
                throw new Exception(MensajesApi.NOTA_NO_ENCONTRADA.getMensaje());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

}
