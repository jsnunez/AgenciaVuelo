package com.agencia.revision.infraestructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.agencia.revision.domain.entity.Revision;
import com.agencia.revision.domain.service.RevisionService;

public class RevisionRepository implements RevisionService{
    private Connection connection;

    public RevisionRepository(){
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
    public void createRevision(Revision revision) {
        try{
            String query= "INSERT INTO revisiones (fecharevision, idavion) VALUES (?,?)";
            PreparedStatement ps=connection.prepareStatement(query,
            PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setString(1,revision.getFechaRevision());
            ps.setInt(2,revision.getIdAvion());

            ps.executeUpdate();
            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    revision.setId(generatedKeys.getInt(1));
                }
            }
        }catch(SQLException e){
            e.printStackTrace();

        }

        try{
            String query= "INSERT INTO revisiondetalles (descripcion, idempleado) VALUES (?,?)";
            PreparedStatement ps=connection.prepareStatement(query,
            PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setString(1,revision.getDescripcion());
            ps.setInt(2,revision.getIdEmpleado());

            ps.executeUpdate();
            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    revision.setId(generatedKeys.getInt(1));
                }
            }
        }catch(SQLException e){
            e.printStackTrace();

        }


    }

    @Override
    public void deleteRevision(int id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Revision findRevision(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void updateRevision(Revision revision) {
        // TODO Auto-generated method stub
        
    }

    

    


}
