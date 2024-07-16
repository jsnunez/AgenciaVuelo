package com.agencia.aeropuerto.infrastructure.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.agencia.aeropuerto.domain.entity.Aeropuerto;
import com.agencia.aeropuerto.domain.service.AeropuertoService;

public class AeropuertoRepository implements AeropuertoService {

  private Connection connection;

  public AeropuertoRepository(){
  try
  {
    Properties props = new Properties();
    props.load(getClass().getClassLoader().getResourceAsStream("configdb.properties"));
    String url = props.getProperty("url");
    String user = props.getProperty("user");
    String password = props.getProperty("password");

    System.out.println("URL: " + url); // Verificar la URL cargada
    System.out.println("User: " + user); // Verificar el usuario cargado
    // N
    connection = DriverManager.getConnection(url, user, password);
    System.out.println("Conexión exitosa!");
  }catch(
  Exception e)
  {
    e.printStackTrace();
  }
  }

  @Override
  public void createAeropuerto(Aeropuerto aeropuerto) {
    try {
      String query = "INSERT INTO aeropuertosvuelos (descripcion,detalles,valor) VALUES (?,?,?)";
      PreparedStatement ps = connection.prepareStatement(query,
          PreparedStatement.RETURN_GENERATED_KEYS);
      ps.setString(1, aeropuerto.getNombreae());
      ps.setString(2, aeropuerto.getId());
      ps.setString(3, aeropuerto.getIdciudadae());

      ps.executeUpdate();
      System.out.println("aeropuerto creada con éxito!");
    } catch (SQLException e) {
      e.printStackTrace();

    }
  }

  @Override
  public void updateAeropuerto(Aeropuerto aeropuerto){
  try {
    String sql = "UPDATE aeropuertosvuelos SET detalles = ?,descripcion=?,valor=? WHERE id = ?";

    PreparedStatement statement = connection.prepareStatement(sql);
    statement.setString(1, aeropuerto.getId());
    statement.setString(2, aeropuerto.getNombreae());
    statement.setString(3, aeropuerto.getIdciudadae());
    
    int rowsUpdate = statement.executeUpdate();
    System.out.println("Aeropuerto actualizado  " + rowsUpdate);

  } catch (SQLException e) {
    e.printStackTrace();
  }
  }

  @Override
  public Aeropuerto finAeropuerto(String id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'finAeropuerto'");
  }

  @Override
  public void deleteAeropuerto(String id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'deleteAeropuerto'");
  }}