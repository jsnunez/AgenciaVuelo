

import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.agencia.tarifa.application.CreateTarifaUseCase;
import com.agencia.tarifa.application.DeleteTarifaUseCase;
import com.agencia.tarifa.application.FindTarifaUseCase;
import com.agencia.tarifa.application.UpdateTarifaUseCase;
import com.agencia.tarifa.domain.service.TarifaService;
import com.agencia.tarifa.infraestructure.in.TarifaController;
import com.agencia.tarifa.infraestructure.out.TarifaRepository;
import com.agencia.vuelo.application.BuscarCiudades;
import com.agencia.vuelo.application.BuscarTiposDocumentos;
import com.agencia.vuelo.application.BuscarvuelosUseCase;
import com.agencia.vuelo.application.ConsultvueloUseCase;
import com.agencia.vuelo.application.CrearReservaUseCase;
import com.agencia.vuelo.application.VerificarPasajero;
import com.agencia.vuelo.domain.service.vueloService;
import com.agencia.vuelo.infraestructure.in.vueloController;
import com.agencia.vuelo.infraestructure.out.vueloRepository;

public class mainsebastian {
    public static void main(String[] args) {
        // Scanner scanner = new Scanner(System.in);

        try {
            Object[] options = { "tarifas", "vuelos", "salir" };
            Object menu = JOptionPane.showInputDialog(null, "Seleccione Una Opcion",
                    "menuprincipal", JOptionPane.QUESTION_MESSAGE, null, options, "tarifas");

            int selectedIndex = -1; // default value for no selection or "Seleccione"
            for (int i = 0; i < options.length; i++) {
                if (options[i].equals(menu)) {
                    selectedIndex = i;
                    break;
                }
            }

            switch (selectedIndex) {
                case 0:

                    TarifaService tarifaService = new TarifaRepository();
                    CreateTarifaUseCase createtarifaUseCase = new CreateTarifaUseCase(tarifaService);
                    FindTarifaUseCase findtarifaUseCase = new FindTarifaUseCase(tarifaService);
                    UpdateTarifaUseCase updateCaseUsetarifa = new UpdateTarifaUseCase(tarifaService);
                    DeleteTarifaUseCase deletetarifaUseCase = new DeleteTarifaUseCase(tarifaService);

                    TarifaController consoleAdapter = new TarifaController(createtarifaUseCase, findtarifaUseCase,
                            deletetarifaUseCase, updateCaseUsetarifa);
                    Object[] optionstarifa = { "Crear tarifa", "Buscar tarifa", "Editar tarifa", "Eliminar tarifa",
                            " Salir" };
                    Object menutarifa = JOptionPane.showInputDialog(null, "Seleccione Una Opcion",
                            "MYSQL", JOptionPane.QUESTION_MESSAGE, null, optionstarifa, "Crear usuario");

                    int selectedIndexTarifa = -1; // default value for no selection or "Seleccione"
                    for (int i = 0; i < options.length; i++) {
                        if (optionstarifa[i].equals(menutarifa)) {
                            selectedIndexTarifa = i;
                            break;
                        }
                    }

                    switch (selectedIndexTarifa) {
                        case 0:
                            consoleAdapter.crear();
                            break;
                        case 1:
                            consoleAdapter.buscar();
                            break;
                        case 2:
                            consoleAdapter.actualizar();
                            break;
                        case 3:
                            consoleAdapter.eliminar();
                            break;
                        default:
                            break;
                    }
                    break;
                case 1:
                    vueloService vueloService = new vueloRepository();
                    ConsultvueloUseCase consultvueloUseCase =  new ConsultvueloUseCase(vueloService);
                    BuscarCiudades buscarCiudades = new BuscarCiudades(vueloService);
                    BuscarvuelosUseCase buscarvuelosUseCase = new BuscarvuelosUseCase(vueloService);
                    CrearReservaUseCase crearReservaUseCase = new CrearReservaUseCase(vueloService);
                    VerificarPasajero verificarPasajero = new VerificarPasajero(vueloService);
                    BuscarTiposDocumentos buscarTiposDocumentos = new BuscarTiposDocumentos(vueloService);
                    vueloController consoleAdapterVuelo = new vueloController(consultvueloUseCase,buscarCiudades,buscarvuelosUseCase,crearReservaUseCase,verificarPasajero,buscarTiposDocumentos);

                    Object[] optionsVuelos = { "Consultar vuelos", "Buscar vuelo", "Seleccionar vuelo",
                            "Añadir pasajero", "Seleccionar asiento", " Salir" };
                    Object menuVuelos = JOptionPane.showInputDialog(null, "Seleccione Una Opcion",
                            "MYSQL", JOptionPane.QUESTION_MESSAGE, null, optionsVuelos, "Consultar vuelos");

                    int selectedIndexVuelo = -1; // default value for no selection or "Seleccione"
                    for (int i = 0; i < options.length; i++) {
                        if (optionsVuelos[i].equals(menuVuelos)) {
                            selectedIndexVuelo = i;
                            break;
                        }
                    }

                    switch (selectedIndexVuelo) {
                        case 0:
                            consoleAdapterVuelo.consultar();
                            break;
                        case 1:
                        consoleAdapterVuelo.buscar();

                        
                            break;
                        case 2:
                            // consoleAdapter.actualizar();
                            break;
                        case 3:
                            // consoleAdapter.eliminar();
                            break;
                        default:
                            break;
                    }
            }
        } catch (SQLException e) {
            
            e.printStackTrace();
        }

    }
}
