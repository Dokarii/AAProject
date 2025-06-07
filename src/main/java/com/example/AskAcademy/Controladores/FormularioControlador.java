package com.example.AskAcademy.Controladores;

import com.example.AskAcademy.Modelos.Formulario;
import com.example.AskAcademy.Servicios.FormularioServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/formularios")
public class FormularioControlador {

    @Autowired
    FormularioServicios servicio;

    @PostMapping()
    public ResponseEntity<?> guardarFormulario(@RequestBody Formulario formularioDatos) {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.servicio.guardarFormulario(formularioDatos));
        } catch (Exception errorAPI) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> modificarFormulario(@PathVariable Integer id, @RequestBody Formulario formularioDatos) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.servicio.modificarFormulario(id, formularioDatos));
        } catch (Exception errorAPI) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarFormularioPorId(@PathVariable Integer id) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.servicio.buscarFormularioPorId(id));
        } catch (Exception errorAPI) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());
        }
    }

    @GetMapping()
    public ResponseEntity<?> buscarTodosLosFormularios() {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.servicio.buscarTodosLosFormularios());
        } catch (Exception errorAPI) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());
        }
    }

    @GetMapping("/profesor/{profesorId}")
    public ResponseEntity<?> buscarFormulariosPorProfesor(@PathVariable Integer profesorId) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.servicio.buscarFormulariosPorProfesor(profesorId));
        } catch (Exception errorAPI) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());
        }
    }

    @GetMapping("/activos")
    public ResponseEntity<?> buscarFormulariosActivos() {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.servicio.buscarFormulariosActivos());
        } catch (Exception errorAPI) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarFormulario(@PathVariable Integer id) {
        try {
            this.servicio.eliminarFormulario(id);
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