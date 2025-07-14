package com.flight.model;

import java.util.ArrayList;
import java.util.List;

public class Vuelo {
    private String codigo;
    private String origen;
    private String destino;
    private String fecha;
    private int capacidad;
    private int capacidadDisponible;
    private List<Pasajero> pasajeros;

    public Vuelo(String codigo, String origen, String destino, String fecha, int capacidad) {
        this.codigo = codigo;
        this.origen = origen;
        this.destino = destino;
        this.fecha = fecha;
        this.capacidad = capacidad;
        this.capacidadDisponible = capacidad;
        this.pasajeros = new ArrayList<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public String getFecha() {
        return fecha;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public List<Pasajero> getPasajeros() {
        return pasajeros;
    }

    public boolean agregarPasajero(Pasajero pasajero) {
        if (pasajeros.size() < capacidad && !pasajeros.contains(pasajero)) {
            pasajeros.add(pasajero);
            capacidadDisponible --;
            return true;
        }
        return false;
    }

    public void incrementarCapacidad(Pasajero pasajero) {
        pasajeros.remove(pasajero);
        this.capacidadDisponible ++;
    }

    @Override
    public String toString() {
        return "VUELO: " + codigo + ", " + origen + ", " + destino + ", " + fecha + ", " + capacidadDisponible;
    }

}
