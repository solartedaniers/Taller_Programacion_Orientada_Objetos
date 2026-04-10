package com.universidad.universidad_api.models;

public class Profesor extends Persona implements Autenticable, Notificable, Evaluador {

    private final String especialidad;

    public Profesor(String nombre, String correo, String especialidad) {
        super(nombre, correo);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() { return especialidad; }

    @Override
    public boolean login(String usuario, String password) {
        return usuario.equals(getCorreo());
    }

    @Override
    public void enviarNotificacion(String mensaje) {
        System.out.println("[Notif-Profesor] " + getNombre() + " -> " + mensaje);
    }

    @Override
    public void evaluar(Estudiante estudiante, double nota) {
        System.out.println("Evaluación registrada: " + estudiante.getNombre() + " = " + nota);
    }
}
