package com.universidad.universidad_api.repository;

import com.universidad.universidad_api.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {

    default Optional<String> buscarPorCorreo(String correo) {
        return findById(correo).map(Usuario::getPassword);
    }

    default boolean validarPassword(String correo, String password) {
        return findById(correo)
            .map(usuario -> usuario.getPassword().equals(password))
            .orElse(false);
    }
}
