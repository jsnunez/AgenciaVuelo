package com.agencia.vuelo.application;

import java.sql.SQLException;

import com.agencia.vuelo.domain.entity.VuelosDto;
import com.agencia.vuelo.domain.service.vueloService;

public class ConsultvueloUseCase {
    private final vueloService vueloService;

    public ConsultvueloUseCase(vueloService vueloService) {
        this.vueloService = vueloService;
    }

    public VuelosDto execute(int id) throws SQLException {
     
        return vueloService.consultvuelo(id);
    }
}
