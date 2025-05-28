package com.example.AskAcademy.Repositorios;

import com.example.AskAcademy.Modelos.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProfesorRepositorio extends JpaRepository<Profesor, Integer> {
    // Aquí se pueden agregar métodos personalizados
}
