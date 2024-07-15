package com.agencia.vuelo.application;

import com.agencia.vuelo.domain.service.vueloService;

public class DeletevueloUseCase {
    private final vueloService vueloService;

    public DeletevueloUseCase(vueloService vueloService) {
        this.vueloService = vueloService;
    }

        public void execute(int id)  {
        vueloService.deletevuelo(id);
    }

}
