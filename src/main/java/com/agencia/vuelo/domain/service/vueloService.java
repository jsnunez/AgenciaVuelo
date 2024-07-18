package com.agencia.vuelo.domain.service;


import java.util.List;

import com.agencia.vuelo.domain.entity.Ciudad;
import com.agencia.vuelo.domain.entity.VuelosDto;
import com.agencia.vuelo.domain.entity.vuelo;
import com.agencia.tipoDocumento.domain.entity.TipoDocumento;
import com.agencia.vuelo.domain.entity.BuscarVuelo;

public interface vueloService {

    VuelosDto consultvuelo(int id);
    List<String> BuscarVuelo(BuscarVuelo BuscarVuelo);
    void updatevuelo(vuelo vuelo);
    vuelo findvuelo(int id);
    void deletevuelo(int id);
    List<Ciudad> findAllCiudades();
    int crearReserva(BuscarVuelo bVuelo);
    void VerificarPasajero();
    List<TipoDocumento> buscarTipoDocumento();
}
