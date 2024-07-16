package com.agencia.escala.domain.service;

import com.agencia.escala.domain.entity.Escala;

public interface EscalaService {

    Escala findEscala(int idViaje);
    void updateEscala(Escala escala);

}
