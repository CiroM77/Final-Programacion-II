package com.flight.model;

public class Pasajero {
    private String dni;
    private String nombre;
    private String apellido;
    private String nacionalidad;

    public Pasajero(String dni, String nombre, String apellido, String nacionalidad) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nacionalidad = nacionalidad;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    @Override
    public String toString() {
        return "PASAJERO: " + dni + ", " + nombre + ", " + apellido + ", " + nacionalidad;
    }
}
