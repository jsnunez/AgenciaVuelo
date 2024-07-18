package com.agencia.vuelo.application;

import com.agencia.vuelo.domain.entity.BuscarVuelo;
import com.agencia.vuelo.domain.entity.Pasajero;
import com.agencia.vuelo.domain.service.vueloService;

public class VerificarPasajero {
    private final vueloService vueloService;

    public VerificarPasajero(com.agencia.vuelo.domain.service.vueloService vueloService) {
        this.vueloService = vueloService;
    }

    public void execute(Pasajero pasajero) {
         vueloService.VerificarPasajero(pasajero);;
}
}
