package com.agencia.trayecto.domain.service;

import com.agencia.avion.domain.entity.Avion;
import com.agencia.trayecto.domain.entity.Trayecto;

public interface TrayectoService {

    Trayecto findTrayecto(int id);
    void updateTrayecto(Trayecto trayecto);
    void deleteTrayecto(Trayecto trayecto);
    Trayecto deleteTrayecto(int id);


}
