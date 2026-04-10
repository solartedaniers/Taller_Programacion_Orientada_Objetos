package com.universidad.universidad_api;

import com.universidad.universidad_api.models.Usuario;
import com.universidad.universidad_api.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initUsuarios(UsuarioRepository usuarioRepository) {
        return args -> {
            crearUsuarioSiNoExiste(usuarioRepository, "admin@uni.edu", "admin123");
            crearUsuarioSiNoExiste(usuarioRepository, "prof@uni.edu", "prof123");
            crearUsuarioSiNoExiste(usuarioRepository, "est@uni.edu", "est123");
        };
    }

    private void crearUsuarioSiNoExiste(UsuarioRepository usuarioRepository, String correo, String password) {
        if (usuarioRepository.findById(correo).isEmpty()) {
            usuarioRepository.save(new Usuario(correo, password));
        }
    }
}
