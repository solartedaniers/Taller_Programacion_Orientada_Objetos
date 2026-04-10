package com.universidad.universidad_api.repository;

import com.universidad.universidad_api.models.Profesor;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryProfesorRepository implements ProfesorRepository {

    private final List<Profesor> storage = new ArrayList<>();

    @Override
    public Profesor guardar(Profesor p) {
        storage.add(p);
        return p;
    }

    @Override
    public Optional<Profesor> buscarPorCorreo(String correo) {
        return storage.stream()
            .filter(p -> p.getCorreo().equals(correo))
            .findFirst();
    }

    @Override
    public List<Profesor> buscarTodos() {
        return new ArrayList<>(storage);
    }
}
