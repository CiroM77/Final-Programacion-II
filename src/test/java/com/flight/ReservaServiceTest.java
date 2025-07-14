package com.flight;

import com.flight.model.Pasajero;
import com.flight.model.Reserva;
import com.flight.model.Vuelo;
import com.flight.service.ReservaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReservaServiceTest {

    private ReservaService reservaService;
    private Pasajero pasajero;
    private Vuelo vuelo;

    @BeforeEach
    void setUp() {
        reservaService = new ReservaService();
        pasajero = new Pasajero("12345678", "Juan", "Perez", "Argentina");
        vuelo = new Vuelo("V001", "Buenos Aires", "Madrid", "2024-12-15", 2);
    }

    @Test
    void crearReservaTest() {
        assertTrue(reservaService.crearReserva("R001", pasajero, vuelo));
        assertEquals(1, reservaService.listarReservas().size());
    }

    @Test
    void crearReservaSinCapacidadTest() {
        reservaService.crearReserva("R001", pasajero, vuelo);
        Pasajero otroPasajero = new Pasajero("87654321", "Ana", "Gomez", "Chile");
        reservaService.crearReserva("R002", otroPasajero, vuelo);

        // Vuelo lleno, tercera reserva debe fallar
        Pasajero tercerPasajero = new Pasajero("99887766", "Carlos", "Martinez", "Peru");
        assertFalse(reservaService.crearReserva("R003", tercerPasajero, vuelo));
    }

    @Test
    void cancelarReservaExistenteTest() {
        reservaService.crearReserva("R001", pasajero, vuelo);
        boolean resultado = reservaService.cancelarReserva("R001");
        assertTrue(resultado, "La reserva debería cancelarse correctamente");

        List<Reserva> reservas = reservaService.listarReservas();
        assertEquals(0, reservas.size(), "La lista de reservas debería estar vacía");
        assertEquals(2, vuelo.getCapacidad(),
                "La capacidad del vuelo debería haberse incrementado a 2");
    }

    @Test
    void cancelarReservaInexistenteTest() {
        boolean resultado = reservaService.cancelarReserva("R999");
        assertFalse(resultado, "No debería cancelar una reserva inexistente");
    }

    @Test
    void listarReservasTest() {
        reservaService.crearReserva("R001", pasajero, vuelo);
        List<Reserva> reservas = reservaService.listarReservas();
        assertEquals(1, reservas.size());
    }

    @Test
    void crearReservaDuplicadaTest() {
        assertTrue(reservaService.crearReserva("R001", pasajero, vuelo));
        assertFalse(reservaService.crearReserva("R001", pasajero, vuelo));
    }
}
