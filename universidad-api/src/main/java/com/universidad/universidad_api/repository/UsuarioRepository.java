package com.universidad.universidad_api.repository;

import java.util.Optional;

public interface UsuarioRepository {
    Optional<String> buscarPorCorreo(String correo);
    boolean validarPassword(String correo, String password);
}
