package com.agencia.vuelo.domain.service;


import java.util.List;

import com.agencia.vuelo.domain.entity.Ciudad;
import com.agencia.vuelo.domain.entity.VuelosDto;
import com.agencia.vuelo.domain.entity.vuelo;

public interface vueloService {

    VuelosDto consultvuelo(int id);
    void BuscarVuelo(List<Ciudad> ciudades);
    void updatevuelo(vuelo vuelo);
    vuelo findvuelo(int id);
    void deletevuelo(int id);
    List<Ciudad> findAllCiudades();
}
