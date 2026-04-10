package com.universidad.universidad_api.repository;

import com.universidad.universidad_api.models.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface EstudianteRepository extends JpaRepository<Estudiante, String> {

    default Estudiante guardar(Estudiante e) {
        return save(e);
    }

    default Optional<Estudiante> buscarPorCodigo(String codigo) {
        return findById(codigo);
    }

    default List<Estudiante> buscarTodos() {
        return findAll();
    }

    default void eliminar(String codigo) {
        deleteById(codigo);
    }
}
