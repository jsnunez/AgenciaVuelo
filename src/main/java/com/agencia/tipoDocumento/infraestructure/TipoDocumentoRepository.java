package com.agencia.tipoDocumento.infraestructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import com.agencia.tipoDocumento.domain.entity.TipoDocumento;
import com.agencia.tipoDocumento.domain.service.TipoDocumentoService;

public class TipoDocumentoRepository implements TipoDocumentoService {
    private Connection connection;

    public TipoDocumentoRepository() {

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
    public void createTipoDocumento(TipoDocumento tipoDocumento) {
        try {
            String query="INSERT INTO tiposdocumentos (nombre) VALUES (?)";
            PreparedStatement ps=connection.prepareStatement(query,
            PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setString(2,tipoDocumento.getNombre());

            ps.execute();
            System.out.println("Tipo documento creado con exito!!");

            try (ResultSet generatedSet=ps.getGeneratedKeys()){
                if (generatedSet.next()) {
                    int id = generatedSet.getInt(1);
                    tipoDocumento.setId(id);
                }
                
            }

          

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
        

    // @Override
    // public void updateTipoDocumento(TipoDocumento tipoDocumento) {}
      
    // }

    // @Override
    // public TipoDocumentoService tipoDocumento(int id) {
      
    // }

    // @Override
    // public void deleteTipoDocumento(TipoDocumentoService tipoDocumento) {
       
    // }


}
