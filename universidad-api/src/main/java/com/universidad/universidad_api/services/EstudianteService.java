package com.universidad.universidad_api.services;

import com.universidad.universidad_api.exceptions.ResourceNotFoundException;
import com.universidad.universidad_api.models.Estudiante;
import com.universidad.universidad_api.repository.EstudianteRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EstudianteService {

    private final EstudianteRepository estudianteRepository;
    private final NotificacionService notificacionService;

    public EstudianteService(EstudianteRepository estudianteRepository,
                             NotificacionService notificacionService) {
        this.estudianteRepository = estudianteRepository;
        this.notificacionService  = notificacionService;
    }

    public Estudiante registrar(String nombre, String correo, String codigo) {
        Estudiante e = new Estudiante(nombre, correo, codigo);
        estudianteRepository.guardar(e);
        notificacionService.enviarCorreo(
            correo,
            "Registro exitoso",
            "Bienvenido " + nombre + ", tu código es " + codigo
        );
        return e;
    }

    public Estudiante buscarPorCodigo(String codigo) {
        return estudianteRepository.buscarPorCodigo(codigo)
            .orElseThrow(() -> new ResourceNotFoundException("Estudiante no encontrado: " + codigo));
    }

    public List<Estudiante> listarTodos() {
        return estudianteRepository.buscarTodos();
    }

    public void eliminar(String codigo) {
        estudianteRepository.eliminar(codigo);
        notificacionService.enviarCorreo(
            "admin@uni.edu",
            "Estudiante eliminado",
            "El estudiante con código " + codigo + " fue eliminado."
        );
    }
}
