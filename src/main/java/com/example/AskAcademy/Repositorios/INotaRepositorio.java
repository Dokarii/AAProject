package com.example.AskAcademy.Repositorios;

import com.example.AskAcademy.Modelos.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INotaRepositorio extends JpaRepository<Nota, Integer> {
    // Aquí se pueden agregar métodos personalizados
}
