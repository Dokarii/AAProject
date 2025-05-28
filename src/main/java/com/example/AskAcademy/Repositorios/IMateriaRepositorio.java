package com.example.AskAcademy.Repositorios;

import com.example.AskAcademy.Modelos.Materia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMateriaRepositorio extends JpaRepository<Materia, Integer> {
    // Aquí se pueden agregar métodos personalizados
}
