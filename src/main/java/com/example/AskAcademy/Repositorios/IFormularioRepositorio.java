package com.example.AskAcademy.Repositorios;

import com.example.AskAcademy.Modelos.Formulario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IFormularioRepositorio extends JpaRepository<Formulario, Integer> {
    // Métodos personalizados para buscar formularios por profesor
    List<Formulario> findByProfesorId(Integer profesorId);

    // Buscar formularios activos
    List<Formulario> findByActivoTrue();

    // Buscar formularios por materia
    List<Formulario> findByMateriaId(Integer materiaId);
}