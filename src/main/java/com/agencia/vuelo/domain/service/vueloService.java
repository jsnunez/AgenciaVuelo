package com.agencia.vuelo.domain.service;


import com.agencia.vuelo.domain.entity.VuelosDto;
import com.agencia.vuelo.domain.entity.vuelo;

public interface vueloService {

    VuelosDto consultvuelo(int id);
    void updatevuelo(vuelo vuelo);
    vuelo findvuelo(int id);
    void deletevuelo(int id);
}
