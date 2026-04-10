package com.universidad.universidad_api.services;

import com.universidad.universidad_api.exceptions.ResourceNotFoundException;
import com.universidad.universidad_api.models.Administrativo;
import com.universidad.universidad_api.repository.AdministrativoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AdministrativoService {

    private final AdministrativoRepository administrativoRepository;
    private final NotificacionService notificacionService;

    public AdministrativoService(AdministrativoRepository administrativoRepository,
                                 NotificacionService notificacionService) {
        this.administrativoRepository = administrativoRepository;
        this.notificacionService      = notificacionService;
    }

    public Administrativo registrar(String nombre, String correo, String area) {
        Administrativo a = new Administrativo(nombre, correo, area);
        administrativoRepository.guardar(a);
        notificacionService.enviarCorreo(
            correo,
            "Registro exitoso",
            "Bienvenido " + nombre + ", área asignada: " + area
        );
        return a;
    }

    public List<Administrativo> listarTodos() {
        return administrativoRepository.buscarTodos();
    }

    public void aprobarSolicitud(String codigoSolicitud, String correoAdmin) {
        Administrativo admin = administrativoRepository.buscarPorCorreo(correoAdmin)
            .orElseThrow(() -> new ResourceNotFoundException("Administrativo no encontrado: " + correoAdmin));

        admin.aprobarSolicitud(codigoSolicitud);
        notificacionService.enviarCorreo(
            correoAdmin,
            "Solicitud aprobada",
            "La solicitud " + codigoSolicitud + " fue procesada correctamente."
        );
    }
}
