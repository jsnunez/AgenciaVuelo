package com.agencia.vuelo.application;

import java.util.List;

import com.agencia.tipoDocumento.domain.entity.TipoDocumento;
import com.agencia.vuelo.domain.service.vueloService;

public class BuscarTiposDocumentos {
    private final vueloService vueloService;

    public BuscarTiposDocumentos(com.agencia.vuelo.domain.service.vueloService vueloService) {
        this.vueloService = vueloService;
    }

    public List<TipoDocumento> execute() {
        return vueloService.buscarTipoDocumento();
    }
}
