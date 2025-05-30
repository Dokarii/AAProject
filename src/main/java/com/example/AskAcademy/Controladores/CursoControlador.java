package com.example.AskAcademy.Controladores;

import com.example.AskAcademy.Modelos.Curso;
import com.example.AskAcademy.Servicios.CursoServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cursos")
public class CursoControlador {

    @Autowired
    CursoServicios servicio;

    @PostMapping()
    public ResponseEntity<?> guardarCurso(@RequestBody Curso cursoDatos) {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.servicio.guardarCurso(cursoDatos));
        } catch (Exception errorAPI) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> modificarCurso(@PathVariable Integer id, @RequestBody Curso cursoDatos) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.servicio.modificarCurso(id, cursoDatos));
        } catch (Exception errorAPI) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarCursoPorId(@PathVariable Integer id) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.servicio.buscarCursoPorId(id));
        } catch (Exception errorAPI) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());
        }
    }
    @GetMapping()
    public ResponseEntity<?> buscarTodosLosCursos() {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.servicio.buscarTodosLosCursos());
        } catch (Exception errorAPI) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarCurso(@PathVariable Integer id) {
        try {
            this.servicio.eliminarCurso(id);
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
