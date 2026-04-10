package com.universidad.universidad_api.repository;

import com.universidad.universidad_api.models.Administrativo;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryAdministrativoRepository implements AdministrativoRepository {

    private final List<Administrativo> storage = new ArrayList<>();

    @Override
    public Administrativo guardar(Administrativo a) {
        storage.add(a);
        return a;
    }

    @Override
    public List<Administrativo> buscarTodos() {
        return new ArrayList<>(storage);
    }
}
