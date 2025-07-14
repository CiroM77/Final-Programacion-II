package com.flight;

import com.flight.model.Vuelo;
import com.flight.service.VueloService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VueloServiceTest {

    private VueloService vueloService;

    @BeforeEach
    void setUp() {
        vueloService = new VueloService();
    }

    @Test
    void registrarVueloTest() {
        Vuelo vuelo = new Vuelo("V001", "Buenos Aires", "Madrid", "2024-12-15", 100);
        assertTrue(vueloService.registrarVuelo(vuelo));
        assertEquals(1, vueloService.listarVuelos().size());
    }

    @Test
    void registrarVueloDuplicadoTest() {
        Vuelo vuelo = new Vuelo("V001", "Buenos Aires", "Madrid", "2024-12-15", 100);
        vueloService.registrarVuelo(vuelo);
        assertFalse(vueloService.registrarVuelo(vuelo));
    }

    @Test
    void buscarVueloExistenteTest() {
        Vuelo vuelo = new Vuelo("V002", "Lima", "Santiago", "2024-12-20", 50);
        vueloService.registrarVuelo(vuelo);
        assertNotNull(vueloService.buscarVuelo("V002"));
    }

    @Test
    void buscarVueloInexistenteTest() {
        assertNull(vueloService.buscarVuelo("V999"));
    }
}
