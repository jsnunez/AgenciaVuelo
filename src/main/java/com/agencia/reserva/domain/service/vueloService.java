package com.agencia.reserva.domain.service;


import java.util.List;

import com.agencia.reserva.domain.entity.BuscarVuelo;
import com.agencia.reserva.domain.entity.Ciudad;
import com.agencia.reserva.domain.entity.Pasajero;
import com.agencia.reserva.domain.entity.VuelosDto;
import com.agencia.reserva.domain.entity.vuelo;
import com.agencia.tipoDocumento.domain.entity.TipoDocumento;

public interface vueloService {

    VuelosDto consultvuelo(int id);
    List<String> BuscarVuelo(BuscarVuelo BuscarVuelo);
    void updatevuelo(vuelo vuelo);
    vuelo findvuelo(int id);
    void deletevuelo(int id);
    List<Ciudad> findAllCiudades();
    int crearReserva(BuscarVuelo bVuelo);
    void VerificarPasajero(Pasajero pasajero);
    List<TipoDocumento> buscarTipoDocumento();
}
