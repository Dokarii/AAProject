package com.example.AskAcademy.Repositorios;

import org.springframework.stereotype.Repository;
import com.example.AskAcademy.Modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface IUsuarioRepositorio extends JpaRepository<Usuario, Integer> {
    // Aquí se pueden agregar métodos personalizados
}
