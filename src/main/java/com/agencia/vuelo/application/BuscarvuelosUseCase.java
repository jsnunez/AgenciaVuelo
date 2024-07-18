package com.agencia.vuelo.application;



import java.util.List;

import com.agencia.vuelo.domain.entity.BuscarVuelo;
import com.agencia.vuelo.domain.service.vueloService;

public class BuscarvuelosUseCase {
    private final vueloService vueloService;

    public BuscarvuelosUseCase(vueloService vueloService) {
        this.vueloService = vueloService;
    }
    public List<String> execute(BuscarVuelo bvuelo) {
    
     List<String> vuelos =vueloService.BuscarVuelo(bvuelo);
     System.out.println(bvuelo.getCiudadDestino());
    return vuelos;
    }

}
