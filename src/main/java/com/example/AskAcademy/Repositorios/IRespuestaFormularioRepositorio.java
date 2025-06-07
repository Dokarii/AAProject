package com.example.AskAcademy.Repositorios;

import com.example.AskAcademy.Modelos.RespuestaFormulario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IRespuestaFormularioRepositorio extends JpaRepository<RespuestaFormulario, Integer> {
    // Buscar respuestas por formulario
    List<RespuestaFormulario> findByFormularioId(Integer formularioId);

    // Buscar respuestas por estudiante
    List<RespuestaFormulario> findByEstudianteId(Integer estudianteId);

    // Verificar si un estudiante ya respondió un formulario
    boolean existsByFormularioIdAndEstudianteId(Integer formularioId, Integer estudianteId);
}