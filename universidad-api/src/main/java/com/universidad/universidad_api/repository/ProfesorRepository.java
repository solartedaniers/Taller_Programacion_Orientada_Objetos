package com.universidad.universidad_api.repository;

import com.universidad.universidad_api.models.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface ProfesorRepository extends JpaRepository<Profesor, Long> {

    default Profesor guardar(Profesor p) {
        return save(p);
    }

    default Optional<Profesor> buscarPorCorreo(String correo) {
        return findByCorreo(correo);
    }

    default List<Profesor> buscarTodos() {
        return findAll();
    }

    Optional<Profesor> findByCorreo(String correo);
}
