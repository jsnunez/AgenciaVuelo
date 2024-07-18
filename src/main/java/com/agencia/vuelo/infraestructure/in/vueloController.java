package com.agencia.vuelo.infraestructure.in;

import java.awt.GridLayout;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.agencia.vuelo.application.ConsultvueloUseCase;
import com.agencia.vuelo.application.CrearReservaUseCase;
import com.agencia.tipoDocumento.domain.entity.TipoDocumento;
import com.agencia.vuelo.application.BuscarCiudades;
import com.agencia.vuelo.application.BuscarTiposDocumentos;
import com.agencia.vuelo.application.UpdatevueloUseCase;
import com.agencia.vuelo.application.VerificarPasajero;
import com.agencia.vuelo.application.BuscarvuelosUseCase;
import com.agencia.vuelo.domain.entity.BuscarVuelo;
import com.agencia.vuelo.domain.entity.Ciudad;
import com.agencia.vuelo.domain.entity.Pasajero;
import com.agencia.vuelo.domain.entity.vuelo;
import com.toedter.calendar.JCalendar;

public class vueloController {
    private ConsultvueloUseCase consultvueloUseCase;
    private BuscarCiudades buscarCiudades;
    private UpdatevueloUseCase updatevueloUseCase;
    private BuscarvuelosUseCase buscarvuelosUseCase;
    private CrearReservaUseCase crearReservaUseCase;
    private VerificarPasajero verificarPasajero;
    private BuscarTiposDocumentos buscarTiposDocumentos;

    public vueloController(ConsultvueloUseCase consultvueloUseCase, BuscarCiudades buscarCiudades,
            BuscarvuelosUseCase buscarvuelosUseCase,
            CrearReservaUseCase crearReservaUseCase, VerificarPasajero verificarPasajero,
            BuscarTiposDocumentos buscarTiposDocumentos) {
        this.consultvueloUseCase = consultvueloUseCase;
        this.buscarCiudades = buscarCiudades;
        this.updatevueloUseCase = updatevueloUseCase;
        this.buscarvuelosUseCase = buscarvuelosUseCase;
        this.crearReservaUseCase = crearReservaUseCase;
        this.verificarPasajero = verificarPasajero;
        this.buscarTiposDocumentos = buscarTiposDocumentos;
    }

    public void consultar() throws SQLException {
        String idString = JOptionPane.showInputDialog("Ingrese ID vuelo");
        int id = Integer.parseInt(idString);
        consultvueloUseCase.execute(id);

    }

    public void buscar() {
        List<Ciudad> ciudades = new ArrayList<>();
        ciudades = buscarCiudades.execute();
        BuscarVuelo bvuelo = new BuscarVuelo();
        bvuelo = seleccionaCiudades(ciudades);
        String fechaida = SeleccionarFecha();
        bvuelo.setFechaIda(fechaida);
        List<String> vuelos = buscarvuelosUseCase.execute(bvuelo);
        String Idvuelo = SeleccionarVuelo(vuelos);
        var yesOrNo = 0;
        bvuelo.setIdvuelo(Idvuelo);

        while (yesOrNo == 0) {
            crearReservaUseCase.execute(bvuelo);
            List<TipoDocumento> tipos = buscarTiposDocumentos.execute();
            Pasajero pasajero=verificarPasajero(tipos);
            System.out.println(pasajero.getIdTipoDocumento());
            System.out.println(pasajero.getDocumento());
            yesOrNo = JOptionPane.showConfirmDialog(null, "Desea agregar un nuevo pasajero?");
        }
        if (yesOrNo == 1) {
            JOptionPane.showMessageDialog(null, "Selecciona silla");
        }

    }

    public Pasajero verificarPasajero(List<TipoDocumento> tipos) {

        List<String> listTiposDocuemtnos = new ArrayList<>();
        for (TipoDocumento tipoDocumento : tipos) {
            listTiposDocuemtnos.add(tipoDocumento.getNombre());
        }

        JComboBox<String> comboBoxTipoDocumento = new JComboBox<>(listTiposDocuemtnos.toArray(new String[0]));
        JPanel panelBuscar = new JPanel(new GridLayout(0, 2));
        // JPanel panel = new JPanel(new GridLayout(0, 2));
        panelBuscar.add(new JLabel("Seleccione tipo Documento:"));
        panelBuscar.add(comboBoxTipoDocumento);
        JLabel documetoJLabel = new JLabel("Numero documento:");
        JTextField documentoField = new JTextField();
        panelBuscar.add(documetoJLabel);
        panelBuscar.add(documentoField);
        int result = JOptionPane.showConfirmDialog(null, panelBuscar, "Seleccionar tipo Documento",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);
        String tipoDocumento = null;
        if (result == JOptionPane.OK_OPTION) {
            tipoDocumento = (String) comboBoxTipoDocumento.getSelectedItem();
        }
        int idtipodocumento=0;
        for (TipoDocumento selecionado : tipos) {
            if(tipoDocumento.equals(selecionado.getNombre())){
                idtipodocumento=selecionado.getId();
            }
        }
        Pasajero pasajero = new Pasajero(idtipodocumento,documentoField.getText());
        return pasajero;
       
    }

    public BuscarVuelo seleccionaCiudades(List<Ciudad> ciudades) {
        List<String> nombres = new ArrayList<>();
        for (Ciudad ciudad : ciudades) {
            nombres.add(ciudad.getCiudad());
        }

        JComboBox<String> comboBoxCiudadesorigen = new JComboBox<>(nombres.toArray(new String[0]));
        JComboBox<String> comboBoxCiudadesdestino = new JComboBox<>(nombres.toArray(new String[0]));

        JPanel panel = new JPanel(new GridLayout(0, 2));
        panel.add(new JLabel("Seleccione una ciudad origen:"));
        panel.add(comboBoxCiudadesorigen);
        panel.add(new JLabel("Seleccione una ciudad destino:"));
        panel.add(comboBoxCiudadesdestino);
        BuscarVuelo bvuelo = new BuscarVuelo();
        int result = JOptionPane.showConfirmDialog(null, panel, "Seleccionar Ciudad origen y destino",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            String selectedCiudadorigen = (String) comboBoxCiudadesorigen.getSelectedItem();
            String selectedCiudaddestino = (String) comboBoxCiudadesdestino.getSelectedItem();
            System.out.println("Ciudad origen seleccionada: " + selectedCiudadorigen);
            System.out.println("Ciudad destino seleccionada: " + selectedCiudaddestino);
            bvuelo.setCiudadOrigen(selectedCiudadorigen);
            bvuelo.setCiudadDestino(selectedCiudaddestino);
        }
        return bvuelo;

    }

    public String SeleccionarFecha() {
        JCalendar calendar = new JCalendar();
        JPanel panelc = new JPanel(new GridLayout(0, 2));
        panelc.add(new JLabel("Seleccione una fecha:"));
        panelc.add(calendar);

        int resultc = JOptionPane.showConfirmDialog(null, panelc, "Seleccionar Fecha", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);
        String fechaida = "";
        if (resultc == JOptionPane.OK_OPTION) {
            Date selectedDate = calendar.getDate();
            Calendar cal = Calendar.getInstance();
            cal.setTime(selectedDate);
            int dia = cal.get(Calendar.DAY_OF_MONTH);
            int mes = cal.get(Calendar.MONTH) + 1; // Los meses comienzan en 0 en Calendar, por lo que se añade 1
            int año = cal.get(Calendar.YEAR);
            fechaida = año + "-" + mes + "-" + dia;
            System.out.println(fechaida);
        }
        return fechaida;

    }

    public String SeleccionarVuelo(List<String> vuelos) {
        JComboBox<String> comboBoxVuelos = new JComboBox<>(vuelos.toArray(new String[0]));

        JPanel panel = new JPanel(new GridLayout(0, 2));
        panel.add(new JLabel("Seleccione Vuelo:"));
        panel.add(comboBoxVuelos);

        int resultVuelo = JOptionPane.showConfirmDialog(null, panel, "Seleccionar vuelo", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);
        String selectVuelo = "";
        if (resultVuelo == JOptionPane.OK_OPTION) {
            selectVuelo = (String) comboBoxVuelos.getSelectedItem();
            System.out.println(selectVuelo);
        }
        return selectVuelo;
    }

    public void actualizar() throws SQLException {
        String idString = JOptionPane.showInputDialog("Ingrese id modificar");
        int id = Integer.parseInt(idString);
        String descripcion = JOptionPane.showInputDialog("Ingrese descripcion");
        String detalle = JOptionPane.showInputDialog("Ingrese detalle");
        String valorString = JOptionPane.showInputDialog("Ingrese valor");
        vuelo vuelo = new vuelo();
        BigDecimal valor = new BigDecimal(valorString);
        vuelo.setId(id);
        updatevueloUseCase.execute(vuelo);
    }

    public void eliminar() throws SQLException {

    }
}
