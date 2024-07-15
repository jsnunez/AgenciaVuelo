package com.agencia.vuelo.infraestructure.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.swing.JOptionPane;

import com.agencia.vuelo.domain.entity.VuelosDto;
import com.agencia.vuelo.domain.entity.vuelo;
import com.agencia.vuelo.domain.service.vueloService;

public class vueloRepository implements vueloService {

  private Connection connection;

  public vueloRepository() {
    try {
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
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  @Override
  public vuelo findvuelo(int id) {
    return null;
   
    }

  @Override
  public void updatevuelo(vuelo vuelo) {
    try {
      String sql = "UPDATE vuelosvuelos SET detalles = ?,descripcion=?,valor=? WHERE id = ?";

      PreparedStatement statement = connection.prepareStatement(sql);
      // statement.setString(1, vuelo.getDetalles());
      // statement.setString(2, vuelo.getDescripcion());
      // statement.setBigDecimal(3, vuelo.getValor());
      statement.setInt(4, vuelo.getId());
      int rowsUpdate = statement.executeUpdate();
      System.out.println("Numero de filas actualizadas  " + rowsUpdate);

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public VuelosDto consultvuelo(int id) {
    
    VuelosDto vuelo = new VuelosDto();
    try {
      // String sql = "SELECT id, fechaviaje, precioviaje,idorigenaeropuerto,iddestinoaeropuerto FROM viajes WHERE id = ?";
      String sql = "SELECT  v.id,v.precioviaje,v.fechaviaje ,a.nombre AS aeropuertoorigen,c.nombre AS ciudadorigen ,ad.nombre AS aeropuertodestino, cd.nombre AS ciudaddestino from viajes v       Join aeropuertos a       on a.id = v.idorigenaeropuerto       JOIN ciudades c       on a.idciudad =c.id      Join aeropuertos ad       on ad.id = v.iddestinoaeropuerto        JOIN ciudades cd       on ad.idciudad =cd.id      WHERE  v.id=?;";
      PreparedStatement statement = connection.prepareStatement(sql);
      statement.setLong(1, id);
      try (ResultSet resultSet = statement.executeQuery()) {
        if (resultSet.next()) {
          vuelo.setId(resultSet.getInt("id"));
          vuelo.setFechaviaje(resultSet.getString("fechaviaje"));
          vuelo.setPrecioviaje((resultSet.getBigDecimal("precioviaje")));
          vuelo.setAeropuertoOrigen((resultSet.getString("aeropuertoorigen")));
          vuelo.setCiudadOrigen((resultSet.getString("ciudadorigen")));
          vuelo.setAeropuertoDestion((resultSet.getString("aeropuertodestino"))); 
          vuelo.setCiudadDestino((resultSet.getString("ciudaddestino")));
        }
JOptionPane.showMessageDialog(null, "vuelo encontrada: \n" +
                        "Fecha: " + vuelo.getFechaviaje() + "\n" +
                        "Precio: " + vuelo.getPrecioviaje() + "\n" +
                        "Aeropuerto Origen: " +vuelo.getAeropuertoOrigen() + "\n" +
                        "Ciudad: " + vuelo.getCiudadOrigen() + "\n"+
                        "Aeropuerto Destino: " +vuelo.getCiudadDestino() + "\n" +
                        "Ciudad: " + vuelo.getCiudadDestino());

      } catch (SQLException e) {
        e.printStackTrace();
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return vuelo;
  }

  @Override
  public void deletevuelo(int id) {
    try{
    String sql = "DELETE FROM vuelosvuelos WHERE id = ?";
        int rowsUpdate = 0;
    
             PreparedStatement statement = connection.prepareStatement(sql) ;
    
            statement.setInt(1, id);
            rowsUpdate = statement.executeUpdate();
    
            System.out.println("Número de filas eliminadas: " + rowsUpdate);
    
        } catch (SQLException e) {
            e.printStackTrace();
        }
        

}}
