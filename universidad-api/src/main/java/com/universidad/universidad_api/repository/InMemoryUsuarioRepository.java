package com.universidad.universidad_api.repository;

import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class InMemoryUsuarioRepository implements UsuarioRepository {

    // correo -> password (demo, sin cifrar)
    private final Map<String, String> usuarios = new HashMap<>();

    public InMemoryUsuarioRepository() {
        usuarios.put("admin@uni.edu", "admin123");
        usuarios.put("prof@uni.edu", "prof123");
        usuarios.put("est@uni.edu", "est123");
    }

    @Override
    public Optional<String> buscarPorCorreo(String correo) {
        return Optional.ofNullable(usuarios.get(correo));
    }

    @Override
    public boolean validarPassword(String correo, String password) {
        return password.equals(usuarios.get(correo));
    }
}
