package com.universidad.universidad_api.controllers;

import com.universidad.universidad_api.models.Estudiante;
import com.universidad.universidad_api.services.EstudianteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {

    private final EstudianteService estudianteService;

    public EstudianteController(EstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> registrar(@RequestBody Map<String, String> body) {
        Estudiante e = estudianteService.registrar(
            body.get("nombre"),
            body.get("correo"),
            body.get("codigo")
        );
        return ResponseEntity.ok(Map.of(
            "nombre", e.getNombre(),
            "correo", e.getCorreo(),
            "codigo", e.getCodigo(),
            "mensaje", "Correo enviado con éxito"
        ));
    }

    @GetMapping
    public ResponseEntity<List<Map<String, String>>> listar() {
        List<Map<String, String>> lista = estudianteService.listarTodos().stream()
            .map(e -> Map.of(
                "nombre", e.getNombre(),
                "correo", e.getCorreo(),
                "codigo", e.getCodigo()
            ))
            .toList();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Map<String, String>> buscar(@PathVariable String codigo) {
        Estudiante e = estudianteService.buscarPorCodigo(codigo);
        return ResponseEntity.ok(Map.of(
            "nombre", e.getNombre(),
            "correo", e.getCorreo(),
            "codigo", e.getCodigo()
        ));
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Map<String, String>> eliminar(@PathVariable String codigo) {
        estudianteService.eliminar(codigo);
        return ResponseEntity.ok(Map.of("mensaje", "Estudiante eliminado y correo enviado"));
    }
}
