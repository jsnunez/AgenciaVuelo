package com.agencia.avion.domain.entity;

import java.sql.Date;

public class Avion {
    private int id;
    private String matricula;
    private int capacidad;
    private Date fechaFabricacion;
    private int idEstado;
    private int idModelo;
    private int idAerolinea;
    public Avion() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public int getCapacidad() {
        return capacidad;
    }
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    public Date getFechaFabricacion() {
        return fechaFabricacion;
    }
    public void setFechaFabricacion(Date fechaFabricacion) {
        this.fechaFabricacion = fechaFabricacion;
    }
    public int getIdEstado() {
        return idEstado;
    }
    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }
    public int getIdModelo() {
        return idModelo;
    }
    public void setIdModelo(int idModelo) {
        this.idModelo = idModelo;
    }
    public int getIdAerolinea() {
        return idAerolinea;
    }
    public void setIdAerolinea(int idAerolinea) {
        this.idAerolinea = idAerolinea;
    }
}
