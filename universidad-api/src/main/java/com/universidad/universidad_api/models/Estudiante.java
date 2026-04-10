package com.universidad.universidad_api.models;

public class Estudiante extends Persona implements Autenticable, Notificable {

    private final String codigo;

    public Estudiante(String nombre, String correo, String codigo) {
        super(nombre, correo);
        this.codigo = codigo;
    }

    public String getCodigo() { return codigo; }

    @Override
    public boolean login(String usuario, String password) {
        return usuario.equals(getCorreo());
    }

    @Override
    public void enviarNotificacion(String mensaje) {
        System.out.println("[Notif-Estudiante] " + getNombre() + " -> " + mensaje);
    }
}
