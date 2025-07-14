package com.flight.service;

import com.flight.model.Pasajero;
import com.flight.model.Reserva;
import com.flight.model.Vuelo;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ReservaService {
    private List<Reserva> reservas = new ArrayList<>();

    public boolean crearReserva(String codigo, Pasajero pasajero, Vuelo vuelo) {
        // TODO
        /*
         * Completar este metodo: Crear una reserva para un pasajero en un vuelo, validar que el vuelo tenga capacidad disponible.
         * retornar true si el registro es exitoso
         * retornar false si no se puede registrar
         */
        for(Reserva res : reservas) {
        	if(res.getCodigoReserva().equals(codigo)) {
        		return false;
        	}
        }
       if(vuelo.agregarPasajero(pasajero)) {
    	   Reserva res = new Reserva(codigo, pasajero, vuelo);
    	   reservas.add(res);
    	   return true;
       } else
       {
    	   return false;
       }
        
        
    }

    public boolean cancelarReserva(String idReserva) {
        // TODO
        /*
         * Completar este metodo: Permitir cancelar reservas usando el código de reserva, liberar espacio en el vuelo correspondiente.
         * usar el metodo incrementarCapacidad(Pasajero) de la clase Vuelo para liberar el espacio
         * mostrar mensaje de exito y retornar true si la cancelacion es exitosa
         * mostrar mensaje de error y retornar false si no se puede cancelar
         */
        for(Reserva res : reservas) {
        	if(res.getCodigoReserva().equals(idReserva)) {
        		res.getVuelo().incrementarCapacidad(res.getPasajero());
        		reservas.remove(res);
        		return true;
        	}
        }
        return false;
    }

    public List<Reserva> listarReservas() {
        return reservas;
    }
}
