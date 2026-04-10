package com.universidad.universidad_api.repository;

import com.universidad.universidad_api.models.Estudiante;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class InMemoryEstudianteRepository implements EstudianteRepository {

    private final Map<String, Estudiante> storage = new HashMap<>();

    @Override
    public Estudiante guardar(Estudiante e) {
        storage.put(e.getCodigo(), e);
        return e;
    }

    @Override
    public Optional<Estudiante> buscarPorCodigo(String codigo) {
        return Optional.ofNullable(storage.get(codigo));
    }

    @Override
    public List<Estudiante> buscarTodos() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public void eliminar(String codigo) {
        storage.remove(codigo);
    }
}
