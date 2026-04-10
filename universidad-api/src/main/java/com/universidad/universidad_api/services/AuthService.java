package com.universidad.universidad_api.services;

import com.universidad.universidad_api.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final JwtUtil jwtUtil;

    public AuthService(UsuarioRepository usuarioRepository, JwtUtil jwtUtil) {
        this.usuarioRepository = usuarioRepository;
        this.jwtUtil = jwtUtil;
    }

    public String login(String correo, String password) {
        if (!usuarioRepository.validarPassword(correo, password)) {
            throw new RuntimeException("Credenciales inválidas");
        }
        return jwtUtil.generarToken(correo);
    }

    public boolean validarToken(String token) {
        return jwtUtil.validarToken(token);
    }
}
