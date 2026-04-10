package com.universidad.universidad_api.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "estudiantes")
public class Estudiante extends Persona implements Autenticable, Notificable {

    @Id
    @Column(nullable = false, updatable = false)
    private String codigo;

    protected Estudiante() {
    }

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
