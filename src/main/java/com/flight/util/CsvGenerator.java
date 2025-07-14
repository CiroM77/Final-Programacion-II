package com.flight.util;

import com.flight.model.Reserva;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvGenerator {
    public static void generarCsv(List<Reserva> reservas, String archivo) {
        try (FileWriter writer = new FileWriter(archivo)) {
            // TODO
            /*
             * USAR ESTA CABECERA EN EL ARCHIVO CSV:  ID Reserva,Pasajero,DNI,Vuelo,Destino,Fecha de Vuelo
             */
        	writer.write("ID Reserva,Pasajero,DNI,Vuelo,Destino,Fecha de Vuelo/n");
        	
        	for(Reserva res : reservas) {
        		String fila = res.getCodigoReserva() + ","+
        						res.getPasajero().getNombre() + " " + res.getPasajero().getApellido() + "," + 
        						res.getPasajero().getDni() + "," +
        						res.getVuelo().getCodigo() + "," + 
        						res.getVuelo().getDestino() + "," +
        						res.getVuelo().getFecha() + "/n";
        		writer.write(fila);
        	}

            System.out.println("Archivo CSV generado exitosamente.");
        } catch (IOException e) {
            System.err.println("Error al generar el archivo CSV: " + e.getMessage());
        }
    }
}
