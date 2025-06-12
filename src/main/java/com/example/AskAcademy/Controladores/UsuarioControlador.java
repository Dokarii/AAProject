package com.example.AskAcademy.Controladores;

import com.example.AskAcademy.Dtos.UsuarioResponseDTO;
import com.example.AskAcademy.Modelos.Usuario;
import com.example.AskAcademy.Servicios.UsuarioServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioControlador {

    @Autowired
    UsuarioServicios servicio;

    @PostMapping
    public ResponseEntity<?> guardarUsuario(@RequestBody Usuario usuarioDatos) {
        try {
            Usuario nuevo = this.servicio.guardarUsuario(usuarioDatos);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(new UsuarioResponseDTO(nuevo));
        } catch (Exception errorAPI) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> modificarUsuario(@PathVariable Integer id, @RequestBody Usuario usuarioDatos) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.servicio.modificarUsuario(id, usuarioDatos));
        } catch (Exception errorAPI) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarUsuarioPorId(@PathVariable Integer id) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.servicio.buscarUsuarioPorId(id));
        } catch (Exception errorAPI) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());
        }
    }

    @GetMapping()
    public ResponseEntity<?> buscarTodosLosUsuarios() {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.servicio.buscarTodosLosUsuarios());
        } catch (Exception errorAPI) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarUsuario(@PathVariable Integer id) {
        try {
            this.servicio.eliminarUsuario(id);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body("Usuario eliminado correctamente");
        } catch (Exception errorAPI) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());
        }
    }
}
