package com.flight.service;

import com.flight.model.Reserva;
import com.flight.model.Vuelo;

import java.util.*;
import java.util.stream.Collectors;

public class EstadisticasService {

    private final ReservaService reservaService;

    public EstadisticasService(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    // Número total de reservas
    public int obtenerNumeroTotalReservas() {
        // TODO
        /*
         * Completar este metodo: Calcular y retornar el número total de reservas.
         */
        return reservaService.listarReservas().size();
    }

    // Vuelos con mayor número de reservas
    public List<Vuelo> obtenerVuelosConMasReservas() {
        // TODO
        /*
         * Completar este metodo: buscar el vuelo con mayor número de reservas (en el caso de existir varios vuelos con la misma cantidad de reservas retornar ambos).
         * retornar una lista de Vuelo   
         */
    	Map<Vuelo, Long> recuento = reservaService.listarReservas().stream().collect(Collectors.groupingBy(Reserva::getVuelo, Collectors.counting()));

    	    if (recuento.isEmpty()) {
    	        return new ArrayList<>();
    	    }
    	    
    	    long max = Collections.max(recuento.values());
    	    return recuento.entrySet().stream().filter(e -> e.getValue() == max).map(Map.Entry::getKey).collect(Collectors.toList());
    	}
    
}
