package com.agencia.vuelo.application;

import com.agencia.vuelo.domain.entity.vuelo;
import com.agencia.vuelo.domain.service.vueloService;

public class UpdatevueloUseCase {
    private final vueloService vueloService;

    public UpdatevueloUseCase(vueloService vueloService) {
        this.vueloService = vueloService;
    }
    public void execute(vuelo vuelo)  {
        vueloService.updatevuelo(vuelo);
    }
}
