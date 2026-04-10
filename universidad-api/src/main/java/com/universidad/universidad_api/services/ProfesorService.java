package com.universidad.universidad_api.services;

import com.universidad.universidad_api.exceptions.ResourceNotFoundException;
import com.universidad.universidad_api.models.Estudiante;
import com.universidad.universidad_api.models.Profesor;
import com.universidad.universidad_api.repository.EstudianteRepository;
import com.universidad.universidad_api.repository.ProfesorRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProfesorService {

    private final ProfesorRepository profesorRepository;
    private final EstudianteRepository estudianteRepository;
    private final NotificacionService notificacionService;

    public ProfesorService(ProfesorRepository profesorRepository,
                           EstudianteRepository estudianteRepository,
                           NotificacionService notificacionService) {
        this.profesorRepository   = profesorRepository;
        this.estudianteRepository = estudianteRepository;
        this.notificacionService  = notificacionService;
    }

    public Profesor registrar(String nombre, String correo, String especialidad) {
        Profesor p = new Profesor(nombre, correo, especialidad);
        profesorRepository.guardar(p);
        notificacionService.enviarCorreo(
            correo,
            "Bienvenido al sistema",
            "Prof. " + nombre + ", registrado en especialidad " + especialidad
        );
        return p;
    }

    public List<Profesor> listarTodos() {
        return profesorRepository.buscarTodos();
    }

    public void evaluar(String correoProfesor, String codigoEstudiante, double nota) {
        Profesor p = profesorRepository.buscarPorCorreo(correoProfesor)
            .orElseThrow(() -> new ResourceNotFoundException("Profesor no encontrado: " + correoProfesor));
        Estudiante e = estudianteRepository.buscarPorCodigo(codigoEstudiante)
            .orElseThrow(() -> new ResourceNotFoundException("Estudiante no encontrado: " + codigoEstudiante));

        p.evaluar(e, nota);
        notificacionService.enviarCorreo(
            e.getCorreo(),
            "Nota registrada",
            "Tu nota en " + p.getEspecialidad() + " es: " + nota
        );
    }
}
