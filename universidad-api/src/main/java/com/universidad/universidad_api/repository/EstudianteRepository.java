package com.universidad.universidad_api.repository;

import com.universidad.universidad_api.models.Estudiante;
import java.util.List;
import java.util.Optional;

public interface EstudianteRepository {
    Estudiante guardar(Estudiante e);
    Optional<Estudiante> buscarPorCodigo(String codigo);
    List<Estudiante> buscarTodos();
    void eliminar(String codigo);
}
