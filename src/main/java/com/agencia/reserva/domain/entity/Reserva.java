package com.agencia.reserva.domain.entity;

public class Reserva {
    private int id;
    private String fechaReserva;
    private int idVuelo;
    private int idCliente;
    private String estado;
    public Reserva() {
    }
    public Reserva(int id, String fechaReserva, int idVuelo, int idCliente, String estado) {
        this.id = id;
        this.fechaReserva = fechaReserva;
        this.idVuelo = idVuelo;
        this.idCliente = idCliente;
        this.estado = estado;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFechaReserva() {
        return fechaReserva;
    }
    public void setFechaReserva(String fechaReserva) {
        this.fechaReserva = fechaReserva;
    }
    public int getIdVuelo() {
        return idVuelo;
    }
    public void setIdVuelo(int idVuelo) {
        this.idVuelo = idVuelo;
    }
    public int getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }

    

}
