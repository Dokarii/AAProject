package com.example.AskAcademy.Repositorios;

import org.springframework.stereotype.Repository;
import com.example.AskAcademy.Modelos.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface IEstudianteRepositorio extends JpaRepository<Estudiante, Integer> {
    // Aquí se pueden agregar métodos personalizados
}
