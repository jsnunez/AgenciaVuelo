package com.agencia.revision.domain.entity;


public class Revision {
    private String id;
    private String idAvion;
    private String fechaRevision;
    private String descripcion;
    private String idEmpleado;
    
    
    public Revision() {
    }

    public Revision(String id, String idAvion, String fechaRevision, String descripcion, String idEmpleado) {
        this.id = id;
        this.idAvion = idAvion;
        this.fechaRevision = fechaRevision;
        this.descripcion = descripcion;
        this.idEmpleado = idEmpleado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdAvion() {
        return idAvion;
    }

    public void setIdAvion(String idAvion) {
        this.idAvion = idAvion;
    }

    public String getFechaRevision() {
        return fechaRevision;
    }

    public void setFechaRevision(String fechaRevision) {
        this.fechaRevision = fechaRevision;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

}
