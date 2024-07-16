package com.agencia.vuelo.domain.entity;

public class Pasajero {
String nombre;
int edad;
String tipoDocumento;
int idTipoDocumento;
String documento;
public Pasajero(String nombre, int edad, String tipoDocumento, String documento) {
    this.nombre = nombre;
    this.edad = edad;
    this.tipoDocumento = tipoDocumento;
    this.documento = documento;
}
public String getTipoDocumento() {
    return tipoDocumento;
}
public void setTipoDocumento(String tipoDocumento) {
    this.tipoDocumento = tipoDocumento;
}
public Pasajero() {
}
public Pasajero(String nombre, int edad, int idTipoDocumento, String documento) {
    this.nombre = nombre;
    this.edad = edad;
    this.idTipoDocumento = idTipoDocumento;
    this.documento = documento;
}
public String getNombre() {
    return nombre;
}
public void setNombre(String nombre) {
    this.nombre = nombre;
}
public int getEdad() {
    return edad;
}
public void setEdad(int edad) {
    this.edad = edad;
}
public int getIdTipoDocumento() {
    return idTipoDocumento;
}
public void setIdTipoDocumento(int idTipoDocumento) {
    this.idTipoDocumento = idTipoDocumento;
}
public String getDocumento() {
    return documento;
}
public void setDocumento(String documento) {
    this.documento = documento;
}


}
