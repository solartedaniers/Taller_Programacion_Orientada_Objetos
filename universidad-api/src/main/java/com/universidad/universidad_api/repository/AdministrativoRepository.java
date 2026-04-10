package com.universidad.universidad_api.repository;

import com.universidad.universidad_api.models.Administrativo;
import java.util.List;

public interface AdministrativoRepository {
    Administrativo guardar(Administrativo a);
    List<Administrativo> buscarTodos();
}
