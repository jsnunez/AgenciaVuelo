package com.agencia.vuelo.application;

import java.util.List;

import com.agencia.vuelo.domain.entity.Ciudad;
import com.agencia.vuelo.domain.service.vueloService;

public class BuscarCiudades {
    private final vueloService vueloService;

    public BuscarCiudades(vueloService vueloService) {
        this.vueloService = vueloService;
    }

        public  List<Ciudad>  execute()  {
                return vueloService.findAllCiudades();
            

        // vueloService.BuscarVuelo();
    }

}
