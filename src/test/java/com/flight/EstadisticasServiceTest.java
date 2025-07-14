package com.flight;

import com.flight.model.Pasajero;
import com.flight.model.Vuelo;
import com.flight.service.EstadisticasService;
import com.flight.service.ReservaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EstadisticasServiceTest {

    private EstadisticasService estadisticasService;

    @BeforeEach
    void setUp() {
        ReservaService reservaService = new ReservaService();
        estadisticasService = new EstadisticasService(reservaService);

        Vuelo vuelo1 = new Vuelo("V001", "Buenos Aires", "Madrid", "2024-12-15", 2);
        Vuelo vuelo2 = new Vuelo("V002", "Lima", "Santiago", "2024-12-20", 3);

        Pasajero pasajero1 = new Pasajero("12345678", "Juan", "Perez", "Argentina");
        Pasajero pasajero2 = new Pasajero("87654321", "Ana", "Gomez", "Chile");
        Pasajero pasajero3 = new Pasajero("56781234", "Carlos", "Lopez", "Peru");

        reservaService.crearReserva("R001", pasajero1, vuelo1);
        reservaService.crearReserva("R002", pasajero2, vuelo1);
        reservaService.crearReserva("R003", pasajero3, vuelo2);
    }

    @Test
    void obtenerNumeroTotalReservasTest() {
        int totalReservas = estadisticasService.obtenerNumeroTotalReservas();
        assertEquals(3, totalReservas, "El número total de reservas debe ser 3");
    }

    @Test
    void obtenerVuelosConMasReservasTest() {
        List<Vuelo> vuelos = estadisticasService.obtenerVuelosConMasReservas();
        assertEquals(1, vuelos.size(), "Debe haber un solo vuelo con el máximo número de reservas");
        assertEquals("V001", vuelos.get(0).getCodigo(), "El vuelo con más reservas debe ser V001");
    }
}
