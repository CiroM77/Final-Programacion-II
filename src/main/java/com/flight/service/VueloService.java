package com.flight.service;

import com.flight.model.Vuelo;
import java.util.ArrayList;
import java.util.List;

public class VueloService {
    private List<Vuelo> vuelos = new ArrayList<>();

    public boolean registrarVuelo(Vuelo vuelo) {
        // TODO
        /*
         * Completar este metodo: Registrar vuelos con validación de datos(no existe un vuelo con el código duplicado).
         * retornar true si el registro es exitoso
         * retornar false si no se puede registrar
         */
        for(Vuelo v : vuelos) {
        	if(v.getCodigo().equals(vuelo.getCodigo())) {
        		return false;
        	}
        }
        vuelos.add(vuelo);
        return true;
    }

    public List<Vuelo> listarVuelos() {
        return vuelos;
    }

    public Vuelo buscarVuelo(String codigo) {
        for(Vuelo vuelo: vuelos){
            if (vuelo.getCodigo().equals(codigo))
                return vuelo;
        }
        return null;        
    }
}
