package com.universidad.universidad_api.controllers;

import com.universidad.universidad_api.models.Administrativo;
import com.universidad.universidad_api.services.AdministrativoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/administrativos")
public class AdministrativoController {

    private final AdministrativoService administrativoService;

    public AdministrativoController(AdministrativoService administrativoService) {
        this.administrativoService = administrativoService;
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> registrar(@RequestBody Map<String, String> body) {
        Administrativo a = administrativoService.registrar(
            body.get("nombre"),
            body.get("correo"),
            body.get("area")
        );
        return ResponseEntity.ok(Map.of(
            "nombre",  a.getNombre(),
            "correo",  a.getCorreo(),
            "area",    a.getArea(),
            "mensaje", "Correo enviado con éxito"
        ));
    }

    @GetMapping
    public ResponseEntity<List<Map<String, String>>> listar() {
        List<Map<String, String>> lista = administrativoService.listarTodos().stream()
            .map(a -> Map.of(
                "nombre", a.getNombre(),
                "correo", a.getCorreo(),
                "area",   a.getArea()
            ))
            .toList();
        return ResponseEntity.ok(lista);
    }

    @PostMapping("/aprobar")
    public ResponseEntity<Map<String, String>> aprobar(@RequestBody Map<String, String> body) {
        administrativoService.aprobarSolicitud(
            body.get("codigoSolicitud"),
            body.get("correoAdmin")
        );
        return ResponseEntity.ok(Map.of(
            "mensaje", "Solicitud aprobada y correo enviado con éxito"
        ));
    }
}
