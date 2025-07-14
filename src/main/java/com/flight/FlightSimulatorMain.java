package com.flight;

import com.flight.model.Pasajero;
import com.flight.model.Reserva;
import com.flight.model.Vuelo;
import com.flight.service.EstadisticasService;
import com.flight.service.PasajeroService;
import com.flight.service.ReservaService;
import com.flight.service.VueloService;
import com.flight.util.CsvGenerator;
import java.util.List;

public class FlightSimulatorMain
{
    static final String ARCHIVO = "reservas.csv";

    public static void main(String[] args) {

        // Inicialización de servicios
        PasajeroService pasajeroService = new PasajeroService();
        VueloService vueloService = new VueloService();
        ReservaService reservaService = new ReservaService();
        EstadisticasService estadisticasService = new EstadisticasService(reservaService);

        // Crear algunos pasajeros
        Pasajero pasajero1 = new Pasajero("12345678", "Juan", "Perez", "Argentina");
        Pasajero pasajero2 = new Pasajero("87654321", "Ana", "Gomez", "Chile");
        Pasajero pasajero3 = new Pasajero("99887766", "Carlos", "Martinez", "Peru");
        Pasajero pasajero4 = new Pasajero("55332267", "Maria", "Lopez", "Uruguay");

        pasajeroService.registrarPasajero(pasajero1);
        pasajeroService.registrarPasajero(pasajero2);
        pasajeroService.registrarPasajero(pasajero3);
        pasajeroService.registrarPasajero(pasajero4);

        // Crear algunos vuelos
        Vuelo vuelo1 = new Vuelo("V001", "Buenos Aires", "Madrid", "2024-12-15", 2);
        Vuelo vuelo2 = new Vuelo("V002", "Lima", "Santiago", "2024-12-20", 3);

        vueloService.registrarVuelo(vuelo1);
        vueloService.registrarVuelo(vuelo2);

        // Crear reservas
        crearReservas(reservaService.crearReserva("R001", pasajero1, vuelo1));
        crearReservas(reservaService.crearReserva("R002", pasajero2, vuelo1));
        crearReservas(reservaService.crearReserva("R003", pasajero3, vuelo1));
        crearReservas(reservaService.crearReserva("R004", pasajero3, vuelo2));
        crearReservas(reservaService.crearReserva("R005", pasajero4, vuelo2));

        // Mostrar datos registrados
        System.out.println("\n--- Lista de Pasajeros ---");
        mostrarPasajeros(pasajeroService.listarPasajeros());

        System.out.println("\n--- Busqueda de Pasajeros ---");
        System.out.println(pasajeroService.buscarPasajero("12345678"));

        System.out.println("\n--- Lista de Vuelos ---");
        mostrarVuelos(vueloService.listarVuelos());

        System.out.println("\n--- Lista de Reservas ---");
        mostrarReservas(reservaService.listarReservas());

        // Cancelar una reserva existente
        System.out.println("\nCancelando la reserva R004...");
        reservaService.cancelarReserva("R004");

        System.out.println("\n--- Reservas después de la cancelación ---");
        mostrarReservas(reservaService.listarReservas());

        // Mostrar estadísticas
        System.out.println("\n--- Estadísticas del Sistema ---");
        System.out.println("Número total de reservas: " + estadisticasService.obtenerNumeroTotalReservas());

        System.out.println("Vuelos con mayor número de reservas:");
        estadisticasService.obtenerVuelosConMasReservas().forEach(System.out::println);

        // Exportar datos a CSV
        System.out.println("\n--- Generación de archivo CSV con reservas ---");
        exportarReservasACSV(reservaService.listarReservas());
    }

    private static void crearReservas(boolean estadoReserva) {
        System.out.println("Intento de crear una reserva en un vuelo: " +
                (estadoReserva ? "Éxito" : "Falló, sin plazas disponibles"));
    }

    private static void exportarReservasACSV(List<Reserva> reservas) {
        CsvGenerator.generarCsv(reservas, ARCHIVO);
    }

    private static void mostrarPasajeros(List<Pasajero> pasajeros) {
        pasajeros.forEach(System.out::println);
    }

    private static void mostrarVuelos(List<Vuelo> vuelos) {
        vuelos.forEach(System.out::println);
    }

    private static void mostrarReservas(List<Reserva> reservas) {
        reservas.forEach(System.out::println);
    }
}
