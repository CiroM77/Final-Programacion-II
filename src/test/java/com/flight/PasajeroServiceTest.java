package com.flight;

import com.flight.model.Pasajero;
import com.flight.service.PasajeroService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasajeroServiceTest {

    private PasajeroService pasajeroService;

    @BeforeEach
    void setUp() {
        pasajeroService = new PasajeroService();
    }

    @Test
    void registrarPasajeroTest() {
        Pasajero pasajero = new Pasajero("12345678", "Juan", "Perez", "Argentina");
        assertTrue(pasajeroService.registrarPasajero(pasajero));
        assertEquals(1, pasajeroService.listarPasajeros().size());
    }

    @Test
    void registrarPasajeroDuplicadoTest() {
        Pasajero pasajero = new Pasajero("12345678", "Juan", "Perez", "Argentina");
        pasajeroService.registrarPasajero(pasajero);
        assertFalse(pasajeroService.registrarPasajero(pasajero));
    }

    @Test
    void buscarPasajeroExistenteTest() {
        Pasajero pasajero = new Pasajero("87654321", "Ana", "Gomez", "Chile");
        pasajeroService.registrarPasajero(pasajero);
        assertNotNull(pasajeroService.buscarPasajero("87654321"));
    }

    @Test
    void buscarPasajeroInexistenteTest() {
        assertNull(pasajeroService.buscarPasajero("99999999"));
    }
}
