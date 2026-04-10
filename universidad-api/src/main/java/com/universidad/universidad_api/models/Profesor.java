package com.universidad.universidad_api.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "profesores")
public class Profesor extends Persona implements Autenticable, Notificable, Evaluador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String especialidad;

    protected Profesor() {
    }

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
