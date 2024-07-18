package com.agencia.vuelo.application;

import com.agencia.vuelo.domain.entity.BuscarVuelo;
import com.agencia.vuelo.domain.service.vueloService;

public class CrearReservaUseCase {
    private final vueloService vueloService;

    public CrearReservaUseCase(vueloService vueloService) {
        this.vueloService = vueloService;
    }
    
    public int execute(BuscarVuelo bvuelo) {
    return vueloService.crearReserva(bvuelo);
}
}
