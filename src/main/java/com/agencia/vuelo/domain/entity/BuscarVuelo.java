package com.agencia.vuelo.domain.entity;



public class BuscarVuelo {
String ciudadOrigen;
String CiudadDestino;
String fechaIda;
String fechaRegreso;
String idAeropuertoOrigen;
String idAeropuertoDestino;
public String getFechaIda;
public BuscarVuelo() {
}
public BuscarVuelo(String fechaIda, String idAeropuertoOrigen, String idAeropuertoDestino) {
    this.fechaIda = fechaIda;
    this.idAeropuertoOrigen = idAeropuertoOrigen;
    this.idAeropuertoDestino = idAeropuertoDestino;
}
public BuscarVuelo(String ciudadOrigen, String ciudadDestino, String fechaIda, String fechaRegreso,
        String idAeropuertoOrigen, String idAeropuertoDestino) {
    this.ciudadOrigen = ciudadOrigen;
    CiudadDestino = ciudadDestino;
    this.fechaIda = fechaIda;
    this.fechaRegreso = fechaRegreso;
    this.idAeropuertoOrigen = idAeropuertoOrigen;
    this.idAeropuertoDestino = idAeropuertoDestino;
}
public String getCiudadOrigen() {
    return ciudadOrigen;
}
public void setCiudadOrigen(String ciudadOrigen) {
    this.ciudadOrigen = ciudadOrigen;
}
public String getCiudadDestino() {
    return CiudadDestino;
}
public void setCiudadDestino(String ciudadDestino) {
    CiudadDestino = ciudadDestino;
}
public String getFechaIda() {
    return fechaIda;
}
public void setFechaIda(String fechaIda) {
    this.fechaIda = fechaIda;
}
public String getFechaRegreso() {
    return fechaRegreso;
}
public void setFechaRegreso(String fechaRegreso) {
    this.fechaRegreso = fechaRegreso;
}
public String getIdAeropuertoOrigen() {
    return idAeropuertoOrigen;
}
public void setIdAeropuertoOrigen(String idAeropuertoOrigen) {
    this.idAeropuertoOrigen = idAeropuertoOrigen;
}
public String getIdAeropuertoDestino() {
    return idAeropuertoDestino;
}
public void setIdAeropuertoDestino(String idAeropuertoDestino) {
    this.idAeropuertoDestino = idAeropuertoDestino;
}

}
