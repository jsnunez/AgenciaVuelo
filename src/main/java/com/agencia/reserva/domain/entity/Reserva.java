package com.agencia.reserva.domain.entity;

public class Reserva {
    private String id;
    private String fechaReserva;
    private String idVuelo;
    private String idCliente;
    private String estado;
    public Reserva() {
    }
    public Reserva(String id, String fechaReserva, String idVuelo, String idCliente, String estado) {
        this.id = id;
        this.fechaReserva = fechaReserva;
        this.idVuelo = idVuelo;
        this.idCliente = idCliente;
        this.estado = estado;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getFechaReserva() {
        return fechaReserva;
    }
    public void setFechaReserva(String fechaReserva) {
        this.fechaReserva = fechaReserva;
    }
    public String getIdVuelo() {
        return idVuelo;
    }
    public void setIdVuelo(String idVuelo) {
        this.idVuelo = idVuelo;
    }
    public String getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }

    

}
