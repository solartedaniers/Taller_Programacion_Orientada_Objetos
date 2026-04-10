package com.universidad.universidad_api.controllers;

import com.universidad.universidad_api.exceptions.BadRequestException;
import com.universidad.universidad_api.models.Profesor;
import com.universidad.universidad_api.services.ProfesorService;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/profesores")
public class ProfesorController {

    private final ProfesorService profesorService;

    public ProfesorController(ProfesorService profesorService) {
        this.profesorService = profesorService;
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> registrar(@RequestBody Map<String, String> body) {
        Profesor p = profesorService.registrar(
            body.get("nombre"),
            body.get("correo"),
            body.get("especialidad")
        );
        return ResponseEntity.ok(Map.of(
            "nombre", p.getNombre(),
            "correo", p.getCorreo(),
            "especialidad", p.getEspecialidad(),
            "mensaje", "Correo enviado con exito"
        ));
    }

    @GetMapping
    public ResponseEntity<List<Map<String, String>>> listar() {
        List<Map<String, String>> lista = profesorService.listarTodos().stream()
            .map(p -> Map.of(
                "nombre", p.getNombre(),
                "correo", p.getCorreo(),
                "especialidad", p.getEspecialidad()
            ))
            .toList();
        return ResponseEntity.ok(lista);
    }

    @PostMapping("/evaluar")
    public ResponseEntity<Map<String, String>> evaluar(@RequestBody Map<String, String> body) {
        String correoProfesor = body.get("correoProfesor");
        String codigoEstudiante = body.get("codigoEstudiante");
        String notaTexto = body.get("nota");

        if (correoProfesor == null || correoProfesor.isBlank()) {
            throw new BadRequestException("El campo correoProfesor es obligatorio");
        }
        if (codigoEstudiante == null || codigoEstudiante.isBlank()) {
            throw new BadRequestException("El campo codigoEstudiante es obligatorio");
        }
        if (notaTexto == null || notaTexto.isBlank()) {
            throw new BadRequestException("El campo nota es obligatorio");
        }

        final double nota;
        try {
            nota = Double.parseDouble(notaTexto);
        } catch (NumberFormatException ex) {
            throw new BadRequestException("La nota debe ser numerica, por ejemplo 4.5");
        }

        profesorService.evaluar(correoProfesor, codigoEstudiante, nota);
        return ResponseEntity.ok(Map.of(
            "mensaje", "Evaluacion registrada y correo enviado al estudiante"
        ));
    }
}
