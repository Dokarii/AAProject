package com.example.AskAcademy.Repositorios;

import com.example.AskAcademy.Modelos.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICursoRepositorio extends JpaRepository<Curso, Integer> {
    // Aquí se pueden agregar métodos personalizados
}
