package com.flight;

import com.flight.model.Pasajero;
import com.flight.model.Vuelo;
import com.flight.service.ReservaService;
import com.flight.util.CsvGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

class ReservaServiceCSVTest {

    private ReservaService reservaService;
    private Pasajero pasajero;
    private Vuelo vuelo;

    @BeforeEach
    void setUp() {
        reservaService = new ReservaService();
        pasajero = new Pasajero("12345678", "Juan", "Perez", "Argentina");
        vuelo = new Vuelo("V001", "Buenos Aires", "Madrid", "2024-12-15", 2);
        reservaService.crearReserva("R001", pasajero, vuelo);
    }

    @Test
    void exportarReservasACSVTest() {
        String archivo = "test_reservas.csv";

        // Exportar reservas a CSV
        CsvGenerator.generarCsv(reservaService.listarReservas(), archivo);

        // Leer archivo CSV y validar contenido
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String header = reader.readLine();
            assertEquals("ID Reserva,Pasajero,DNI,Vuelo,Destino,Fecha de Vuelo", header);

            String primeraReserva = reader.readLine();
            assertNotNull(primeraReserva);
            assertTrue(primeraReserva.contains("R001"));
            assertTrue(primeraReserva.contains("Juan Perez"));
            assertTrue(primeraReserva.contains("12345678"));
            assertTrue(primeraReserva.contains("V001"));
            assertTrue(primeraReserva.contains("Madrid"));

        } catch (IOException e) {
            fail("Error al leer el archivo CSV: " + e.getMessage());
        }
    }
}
