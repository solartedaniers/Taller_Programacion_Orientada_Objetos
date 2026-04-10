package com.universidad.universidad_api.models;

public class Administrativo extends Persona implements Autenticable, Notificable, Aprobador {

    private final String area;

    public Administrativo(String nombre, String correo, String area) {
        super(nombre, correo);
        this.area = area;
    }

    public String getArea() { return area; }

    @Override
    public boolean login(String usuario, String password) {
        return usuario.equals(getCorreo());
    }

    @Override
    public void enviarNotificacion(String mensaje) {
        System.out.println("[Notif-Admin] " + getNombre() + " -> " + mensaje);
    }

    @Override
    public void aprobarSolicitud(String codigoSolicitud) {
        System.out.println("Solicitud " + codigoSolicitud + " aprobada por " + getNombre());
    }
}
