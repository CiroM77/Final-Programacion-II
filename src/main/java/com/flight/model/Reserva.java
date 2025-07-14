package com.flight.model;

public class Reserva {
    private String codigoReserva;
    private Pasajero pasajero;
    private Vuelo vuelo;

    public Reserva(String codigoReserva, Pasajero pasajero, Vuelo vuelo) {
        this.codigoReserva = codigoReserva;
        this.pasajero = pasajero;
        this.vuelo = vuelo;
    }

    public String getCodigoReserva() {
        return codigoReserva;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    @Override
    public String toString() {
        return "RESERVA: " + codigoReserva + ", " + pasajero + ", " + vuelo;
    }
}
