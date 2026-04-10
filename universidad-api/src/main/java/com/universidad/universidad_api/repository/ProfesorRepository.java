package com.universidad.universidad_api.repository;

import com.universidad.universidad_api.models.Profesor;
import java.util.List;
import java.util.Optional;

public interface ProfesorRepository {
    Profesor guardar(Profesor p);
    Optional<Profesor> buscarPorCorreo(String correo);
    List<Profesor> buscarTodos();
}
