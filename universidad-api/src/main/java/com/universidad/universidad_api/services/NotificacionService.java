package com.universidad.universidad_api.services;

import org.springframework.stereotype.Service;

@Service
public class NotificacionService {

    public void enviarCorreo(String destinatario, String asunto, String mensaje) {
        // Aqui iria JavaMailSender en produccion.
        System.out.println("==================================");
        System.out.println("  CORREO ENVIADO CON EXITO");
        System.out.println("  Para   : " + destinatario);
        System.out.println("  Asunto : " + asunto);
        System.out.println("  Mensaje: " + mensaje);
        System.out.println("==================================");
    }
}
