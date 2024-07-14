package com.agencia.avion.infraestructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.agencia.avion.domain.entity.Avion;
import com.agencia.avion.domain.service.AvionService;

public class AvionRepository implements AvionService{
    private Connection connection;

    // Genera conexion con el archivo resources/configdb.properties para hacer conexion con la bd
    public AvionRepository() {
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
    public void createAvion(Avion avion) {
        try{
            String query= "INSERT INTO aviones (matricula,capacidad,fechafabricacion,idestado, idmodelo,idaerolinea) VALUES(?,?,?,?,?,?)";
            // Prepara la sentencia sql y genera el id autoincremental 
            PreparedStatement ps=connection.prepareStatement(query,
            PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1,avion.getMatricula());
            ps.setInt(2,avion.getCapacidad());
            ps.setString(3,avion.getFechaFabricacion());
            
            ps.setInt(4,avion.getIdEstado());
            ps.setInt(5,avion.getIdModelo());
            ps.setInt(6,avion.getIdAerolinea());

            ps.executeUpdate();
            System.out.println("Avión creado con éxito!");

        }catch(SQLException e){
            e.printStackTrace();

        }
       


    }

    @Override
    public void updateAvion(Avion avion) {

    }

   
    @Override
    public void deleteAvion(Avion avion) {

    }
}