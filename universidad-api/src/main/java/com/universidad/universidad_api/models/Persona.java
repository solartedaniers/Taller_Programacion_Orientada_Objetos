package com.universidad.universidad_api.models;

public abstract class Persona {

    private final String nombre;
    private final String correo;

    protected Persona(String nombre, String correo) {
        this.nombre = nombre;
        this.correo = correo;
    }

    public String getNombre() { return nombre; }
    public String getCorreo()  { return correo; }
}