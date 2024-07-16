package com.agencia.escala.domain.entity;

public class Escala {
    private int id;
    private String numeroConexion;
    private int idViaje;
    private int idAvion;
    private String idAeropuerto;

    
    public Escala() {
    }


    public Escala(int id, String numeroConexion, int idViaje, int idAvion, String idAeropuerto) {
        this.id = id;
        this.numeroConexion = numeroConexion;
        this.idViaje = idViaje;
        this.idAvion = idAvion;
        this.idAeropuerto = idAeropuerto;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getNumeroConexion() {
        return numeroConexion;
    }


    public void setNumeroConexion(String numeroConexion) {
        this.numeroConexion = numeroConexion;
    }


    public int getIdViaje() {
        return idViaje;
    }


    public void setIdViaje(int idViaje) {
        this.idViaje = idViaje;
    }


    public int getIdAvion() {
        return idAvion;
    }


    public void setIdAvion(int idAvion) {
        this.idAvion = idAvion;
    }


    public String getIdAeropuerto() {
        return idAeropuerto;
    }


    public void setIdAeropuerto(String idAeropuerto) {
        this.idAeropuerto = idAeropuerto;
    } 

}
