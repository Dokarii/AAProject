package com.example.AskAcademy.Servicios;

import com.example.AskAcademy.Modelos.Materia;
import com.example.AskAcademy.Repositorios.IMateriaRepositorio;
import com.example.AskAcademy.Helpers.MensajesApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Java local
import java.util.List;
import java.util.Optional;

@Service
public class MateriaServicios {
    @Autowired
    IMateriaRepositorio repositorio;

    public Materia guardarMateria(Materia materiaDatos) throws Exception {
        try {
            return this.repositorio.save(materiaDatos);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public Materia modificarMateria(Integer id, Materia materiaDatos) throws Exception {
        try {
            Optional<Materia> searchedSubject = this.repositorio.findById(id);
            if (searchedSubject.isPresent()) {
                searchedSubject.get().setNombre(materiaDatos.getNombre());
                searchedSubject.get().setCurso(materiaDatos.getCurso());
                return this.repositorio.save(searchedSubject.get());
            } else {
                throw new Exception(MensajesApi.MATERIA_NO_ENCONTRADA.getMensaje());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public Materia buscarMateriaPorId(Integer id) throws Exception {
        try {
            Optional<Materia> searched = this.repositorio.findById(id);
            if (searched.isPresent()) {
                return searched.get();
            } else {
                throw new Exception(MensajesApi.MATERIA_NO_ENCONTRADA.getMensaje());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public List<Materia> buscarTodasLasMaterias() throws Exception {
        try {
            return this.repositorio.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public boolean eliminarMateria(Integer id) throws Exception {
        try {
            Optional<Materia> searched = this.repositorio.findById(id);
            if (searched.isPresent()) {
                this.repositorio.deleteById(id);
                return true;
            } else {
                throw new Exception(MensajesApi.MATERIA_NO_ENCONTRADA.getMensaje());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}
