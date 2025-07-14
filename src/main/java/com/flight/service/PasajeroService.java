package com.flight.service;

import com.flight.model.Pasajero;
import java.util.ArrayList;
import java.util.List;

public class PasajeroService {
    private List<Pasajero> pasajeros = new ArrayList<>();


    public boolean registrarPasajero(Pasajero pasajero) {
        // TODO
        /*
         * Completar este metodo: Registrar pasajeros, validar que no haya duplicados
         * retornar true si el registro es exitoso
         * retornar false si no se puede registrar
         */
    	for(Pasajero pas : pasajeros) {
    		if(pas.getDni().equals(pasajero.getDni())) {
    			return false;
    		}
    	}    	
    	pasajeros.add(pasajero);
    	return true;	
   
    }

    public List<Pasajero> listarPasajeros() {
        return pasajeros;
    }

    public Pasajero buscarPasajero(String dni) {
        // TODO
        /*
         * Completar este metodo: Buscar pasajeros por DNI y retornar el objeto pasajero
         */
    	for(Pasajero pas : pasajeros) {
    		if(pas.getDni().equals(dni)) {
    			return pas;
    		}
    	}
    	 return null;
    }

}
