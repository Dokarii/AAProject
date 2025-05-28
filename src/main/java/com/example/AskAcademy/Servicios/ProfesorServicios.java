package com.example.AskAcademy.Servicios;

import com.example.AskAcademy.Modelos.Profesor;
import com.example.AskAcademy.Repositorios.IProfesorRepositorio;
import com.example.AskAcademy.Helpers.MensajesApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Java local
import java.util.List;
import java.util.Optional;

@Service
public class ProfesorServicios {

    @Autowired
    IProfesorRepositorio repositorio;

    public Profesor guardarProfesor(Profesor profesorDatos) throws Exception {
        try {
            return this.repositorio.save(profesorDatos);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public Profesor modificarProfesor(Integer id, Profesor profesorDatos) throws Exception {
        try {
            Optional<Profesor> searchedTeacher=this.repositorio.findById(id);

            if(searchedTeacher.isPresent()){
                searchedTeacher.get().setEspecialidad(profesorDatos.getEspecialidad());
                return this.repositorio.save(searchedTeacher.get());
            }else{
                throw new Exception(MensajesApi.PROFESOR_NO_ENCONTRADO.getMensaje());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public Profesor buscarProfesorPorId(Integer id) throws Exception {
        try {
            Optional<Profesor> searchedTeacherForMe=this.repositorio.findById(id);
            if(searchedTeacherForMe.isPresent()){
                return searchedTeacherForMe.get();
            }else{
                throw new Exception(MensajesApi.PROFESOR_NO_ENCONTRADO.getMensaje());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public List<Profesor> buscarTodosLosProfesores() throws Exception {
        try {
            return this.repositorio.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public void eliminarProfesor(Integer id) throws Exception {
        try {
            if (this.repositorio.existsById(id)) {
                this.repositorio.deleteById(id);
            } else {
                throw new Exception(MensajesApi.PROFESOR_NO_ENCONTRADO.getMensaje());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}
