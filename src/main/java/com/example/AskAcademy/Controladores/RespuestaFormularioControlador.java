package com.example.AskAcademy.Controladores;

import com.example.AskAcademy.Modelos.RespuestaFormulario;
import com.example.AskAcademy.Servicios.RespuestaFormularioServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/respuestas-formulario")
public class RespuestaFormularioControlador {
    // Aquí iría la implementación del controlador para manejar las respuestas de los formularios.
    // Por ejemplo, métodos para guardar, modificar, buscar respuestas, etc.
    // Este es un ejemplo de cómo podría comenzar el controlador.

    @Autowired
    RespuestaFormularioServicios servicio;

    @PostMapping()
    public ResponseEntity<?> guardarRespuesta(@RequestBody RespuestaFormulario respuestaDatos) {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.servicio.guardarRespuesta(respuestaDatos));
        } catch (Exception errorAPI) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> modificarRespuesta(@PathVariable Integer id, @RequestBody RespuestaFormulario respuestaDatos) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.servicio.modificarRespuesta(id, respuestaDatos));
        } catch (Exception errorAPI) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());
        }
    }

    @GetMapping("/formulario/{formularioId}")
    public ResponseEntity<?> buscarRespuestasPorFormulario(@PathVariable Integer formularioId) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.servicio.buscarRespuestasPorFormulario(formularioId));
        } catch (Exception errorAPI) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());
        }
    }

    @GetMapping("/estudiante/{estudianteId}")
    public ResponseEntity<?> buscarRespuestasPorEstudiante(@PathVariable Integer estudianteId) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.servicio.buscarRespuestasPorEstudiante(estudianteId));
        } catch (Exception errorAPI) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarRespuesta(@PathVariable Integer id) {
        try {
            this.servicio.eliminarRespuesta(id);
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .build();
        } catch (Exception errorAPI) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());
        }
    }
}