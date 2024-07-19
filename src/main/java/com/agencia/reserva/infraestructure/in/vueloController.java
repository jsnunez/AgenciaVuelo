package com.agencia.reserva.infraestructure.in;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.agencia.escala.application.FindEscalaUseCase;
import com.agencia.escala.domain.entity.Escala;
import com.agencia.reserva.application.BuscarCiudades;
import com.agencia.reserva.application.BuscarTiposDocumentos;
import com.agencia.reserva.application.BuscarvuelosUseCase;
import com.agencia.reserva.application.ConsultvueloUseCase;
import com.agencia.reserva.application.CrearReservaUseCase;
import com.agencia.reserva.application.UpdatevueloUseCase;
import com.agencia.reserva.application.VerificarPasajero;
import com.agencia.reserva.domain.entity.BuscarVuelo;
import com.agencia.reserva.domain.entity.Ciudad;
import com.agencia.reserva.domain.entity.Pasajero;
import com.agencia.reserva.domain.entity.vuelo;
import com.agencia.tipoDocumento.domain.entity.TipoDocumento;
import com.toedter.calendar.JCalendar;

public class VueloController {
  private ConsultvueloUseCase consultvueloUseCase;
  private BuscarCiudades buscarCiudades;
  private BuscarvuelosUseCase buscarvuelosUseCase;
  private CrearReservaUseCase crearReservaUseCase;
  private VerificarPasajero verificarPasajero;
  private BuscarTiposDocumentos buscarTiposDocumentos;
  private FindEscalaUseCase findEscalaUseCase;

  public VueloController(ConsultvueloUseCase consultvueloUseCase, BuscarCiudades buscarCiudades,
      BuscarvuelosUseCase buscarvuelosUseCase, CrearReservaUseCase crearReservaUseCase,
      VerificarPasajero verificarPasajero, BuscarTiposDocumentos buscarTiposDocumentos,
      FindEscalaUseCase findEscalaUseCase) {
    this.consultvueloUseCase = consultvueloUseCase;
    this.buscarCiudades = buscarCiudades;
    this.buscarvuelosUseCase = buscarvuelosUseCase;
    this.crearReservaUseCase = crearReservaUseCase;
    this.verificarPasajero = verificarPasajero;
    this.buscarTiposDocumentos = buscarTiposDocumentos;
    this.findEscalaUseCase = findEscalaUseCase;
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

    List<Escala> escalas = findEscalaUseCase.execute(Integer.valueOf(Idvuelo));

    if (!escalas.isEmpty()) {
      System.out.println(escalas);
      // escalas.forEach(escala -> System.out.println(escala.getId()));

      for (Escala escala : escalas) {
        System.out.println("Escala id: " + escala.getId());
        System.out.println("Número de conexión: " + escala.getNumeroConexion());
        System.out.println("Id trayecto: " + escala.getIdViaje());
        System.out.println("Id Avión: " + escala.getIdAvion());
        System.out.println("Id aeropuerto: " + escala.getIdAeropuerto());
        System.out.println("------------"); // Separador para mayor claridad
      }
    }
    int cantidadpsajeros= 0;
    while (yesOrNo == 0) {
      crearReservaUseCase.execute(bvuelo);
      List<TipoDocumento> tipos = buscarTiposDocumentos.execute();
      Pasajero pasajero = verificarPasajero(tipos);
      System.out.println(pasajero.getIdTipoDocumento());
      System.out.println(pasajero.getDocumento());
      verificarPasajero.execute(pasajero);
      cantidadpsajeros++;
      yesOrNo = JOptionPane.showConfirmDialog(null, "Desea agregar un nuevo pasajero?");
    }
    if (yesOrNo == 1) {
      JOptionPane.showMessageDialog(null, "Selecciona silla");
    }
    System.out.println("cantidad"+escalas.size());
    String sillaseleccionada;
    for (int i = 0; i < cantidadpsajeros; i++) {
      for (int j = 0; j < escalas.size(); j++) {
        
        sillaseleccionada=seleccionarSilla(escalas.get(j));

      }
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
    int idtipodocumento = 0;
    for (TipoDocumento selecionado : tipos) {
      if (tipoDocumento.equals(selecionado.getNombre())) {
        idtipodocumento = selecionado.getId();
      }
    }
    Pasajero pasajero = new Pasajero(idtipodocumento, documentoField.getText());
    pasajero.setTipoDocumento(tipoDocumento);
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
  }

  public void eliminar() throws SQLException {

  }

  public String seleccionarSilla(Escala escala) {
    JPanel optionsPanel = new JPanel(new GridLayout(6, 15));
    optionsPanel.setOpaque(false);
    optionsPanel.setBackground(Color.black);
    JRadioButton[][] options = new JRadioButton[6][20];

    ButtonGroup group = new ButtonGroup();
    // char c = 'A';
    for (int row = 0; row < 6; row++) {
      for (int col = 0; col < 20; col++) {

        // options[row][col] = new JRadioButton(Character.toString(row+ 5) + (col + 1));
                options[row][col] = new JRadioButton(Integer.toString(row * 10 + col + 1));

        // options[row][col].setOpaque(false);
        options[row][col].setBackground(Color.gray); 

        options[row][col].setForeground(Color.green);

        group.add(options[row][col]);
        optionsPanel.add(options[row][col]);

        if (row == 0 && col == 9) {

          options[row][col].setEnabled(false);
          options[row][col].setOpaque(true);

          // options[row][col].setBackground(Color.red);

        }
      }
      // c++;
    }

    // Crear el panel principal que contendrá el panel de opciones
    JPanel mainPanel = new JPanel(new BorderLayout(10, 10)); // Margen de 10 píxeles
  

    mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Márgenes alrededor del panel principal
    mainPanel.setOpaque(false); // Hacer el panel principal transparente
    mainPanel.add(optionsPanel, BorderLayout.CENTER);

    // Crear el cuadro de diálogo con un panel de fondo con imagen
    BackgroundPanel backgroundPanel = new BackgroundPanel(mainPanel, "src\\main\\resources\\avion.png"); // Cambia esta
                                                                                                         // ruta a la
                                                                                                         // ruta de tu
                                                                                                         // imagen
    JOptionPane.showMessageDialog(null, backgroundPanel, "Aeropuerto Salida:  "+escala.getIdAeropuerto(), JOptionPane.PLAIN_MESSAGE);
    String sillaseleccionada = "";
    // Procesar la selección del usuario
    for (int row = 0; row < 6; row++) {
      for (int col = 0; col < 10; col++) {
        if (options[row][col].isSelected()) {
          sillaseleccionada = options[row][col].getText();
          System.out.println("Seleccionaste: " + options[row][col].getText());
        }
      }
    }
    return sillaseleccionada;
  }

  class BackgroundPanel extends JPanel {
    private Image backgroundImage;
    private JComponent component;

    public BackgroundPanel(JComponent component, String filePath) {
      this.component = component;
      try {
        backgroundImage = ImageIO.read(new File(filePath));
      } catch (IOException e) {
        e.printStackTrace();
      }
      setLayout(new GridBagLayout());
      add(component);
    }

    @Override
    protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      if (backgroundImage != null) {
        int imgWidth = backgroundImage.getWidth(this);
        int imgHeight = backgroundImage.getHeight(this);
        int x = (getWidth() - imgWidth) / 2;
        int y = (getHeight() - imgHeight) / 2;
        g.drawImage(backgroundImage, x, y, imgWidth, imgHeight, this);
      }
    }

    @Override
    public Dimension getPreferredSize() {
      if (backgroundImage != null) {
        return new Dimension(1200, 700);
      } else {
        return super.getPreferredSize();
      }
    }
  }

}
