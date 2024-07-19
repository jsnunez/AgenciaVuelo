package com.agencia.reserva.infraestructure.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.agencia.reserva.domain.entity.Reserva;
import com.agencia.reserva.domain.service.ReservaServiceOlf;

public class ReservaRepository implements ReservaServiceOlf {

    private Connection connection;

    public ReservaRepository() {

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
    public void createReservaAgente(Reserva reserva) {

        try {
            String query = "INSERT INTO reservaviaje (fecha,idvuelos,idclientes,estado) VALUES (?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(query,
                    PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, reserva.getFechaReserva());
            ps.setInt(2, reserva.getIdVuelo());
            ps.setInt(3, reserva.getIdCliente());
            ps.setString(4, "Confirmada");

            ps.executeUpdate();

            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);
                    reserva.setId(id);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteReservaAgente(Reserva reserva) {

    }

    @Override
    public Reserva findReservaAgente(int id) {
        String query = "SELECT r.id, r.fecha, v.precioviaje, v.idorigenaeropuerto, " +
                "v.iddestinoaeropuerto, c.nombre, c.numerodocumento, r.estado " +
                "FROM reservaviaje r " +
                "INNER JOIN viajes v ON v.id = r.idvuelos " +
                "INNER JOIN clientes c ON c.id = r.idclientes " +
                "WHERE r.id = ?";
        Reserva reserva = null;
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    reserva = new Reserva();
                    reserva.setId(rs.getInt("id"));
                    reserva.setFechaReserva(rs.getString("fecha"));
                    reserva.setIdVuelo(rs.getInt("idvuelos"));
                    reserva.setIdCliente(rs.getInt("idclientes"));
                    reserva.setEstado(rs.getString("estado"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reserva;

    }
}
