package com.universidad.universidad_api.repository;

import com.universidad.universidad_api.models.Administrativo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface AdministrativoRepository extends JpaRepository<Administrativo, Long> {

    default Administrativo guardar(Administrativo a) {
        return save(a);
    }

    default List<Administrativo> buscarTodos() {
        return findAll();
    }

    default Optional<Administrativo> buscarPorCorreo(String correo) {
        return findByCorreo(correo);
    }

    Optional<Administrativo> findByCorreo(String correo);
}
