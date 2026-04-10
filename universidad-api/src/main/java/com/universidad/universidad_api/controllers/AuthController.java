package com.universidad.universidad_api.controllers;

import com.universidad.universidad_api.services.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody Map<String, String> body) {
        String token = authService.login(body.get("correo"), body.get("password"));
        return ResponseEntity.ok(Map.of("token", token, "tipo", "Bearer"));
    }
}
