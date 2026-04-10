package com.universidad.universidad_api.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "administrativos")
public class Administrativo extends Persona implements Autenticable, Notificable, Aprobador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String area;

    protected Administrativo() {
    }

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
