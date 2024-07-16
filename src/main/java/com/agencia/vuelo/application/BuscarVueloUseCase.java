package com.agencia.vuelo.application;

import java.util.ArrayList;
import java.util.List;

import com.agencia.vuelo.domain.entity.Ciudad;
import com.agencia.vuelo.domain.service.vueloService;

public class BuscarVueloUseCase {
    private final vueloService vueloService;

    public BuscarVueloUseCase(vueloService vueloService) {
        this.vueloService = vueloService;
    }

        public  void execute(int id)  {
                List<Ciudad> ciudades = new ArrayList<>();
                ciudades= vueloService.findAllCiudades();
                vueloService.BuscarVuelo(ciudades);

        // vueloService.BuscarVuelo();
    }

}
