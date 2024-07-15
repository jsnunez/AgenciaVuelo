package com.agencia.vuelo.application;

import com.agencia.vuelo.domain.entity.vuelo;
import com.agencia.vuelo.domain.service.vueloService;

public class FindvueloUseCase {
    private final vueloService vueloService;

    public FindvueloUseCase(vueloService vueloService) {
        this.vueloService = vueloService;
    }

    public vuelo execute(int id)  {
        return vueloService.findvuelo(id);
        
    }
}
