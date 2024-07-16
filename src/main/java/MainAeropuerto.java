// import java.sql.SQLException;
// import javax.swing.JOptionPane;
// 
// import com.agencia.aeropuerto.aplication.CreateAeropuertoCase;
// import com.agencia.aeropuerto.aplication.DeleteAeropuertoCase;
// import com.agencia.aeropuerto.aplication.FindAeropuertoCase;
// import com.agencia.aeropuerto.aplication.UpdateAeropuertoCase;
// import com.agencia.aeropuerto.domain.service.AeropuertoService;
// import com.agencia.aeropuerto.infrastructure.in.AeropuertoController;
// import com.agencia.aeropuerto.infrastructure.out.AeropuertoRepository;
// 
// 
// public class MainAeropuerto {
//     public static void main(String[] args) {
//         try {
//             Object[] options = { "tarifas", "vuelos", "aeropuertos", "salir" };
//             Object menu = JOptionPane.showInputDialog(null, "Seleccione Una Opcion", "Menu Principal",
//                     JOptionPane.QUESTION_MESSAGE, null, options, "tarifas");
// 
//             int selectedIndex = -1; // default value for no selection or "Seleccione"
//             for (int i = 0; i < options.length; i++) {
//                 if (options[i].equals(menu)) {
//                     selectedIndex = i;
//                     break;
//                 }
//             }
// 
//             switch (selectedIndex) {
//                 case 0:
//                     // Código para manejo de tarifas (igual que en tu ejemplo anterior)
//                     break;
//                 case 1:
//                     // Código para manejo de vuelos (igual que en tu ejemplo anterior)
//                     break;
//                 case 2:
//                     AeropuertoService aeropuertoService = new AeropuertoRepository();
//                     CreateAeropuertoCase createAeropuertoCase = new CreateAeropuertoCase(aeropuertoService);
//                     FindAeropuertoCase findAeropuertoCase = new FindAeropuertoCase(aeropuertoService);
//                     UpdateAeropuertoCase updateAeropuertoCase = new UpdateAeropuertoCase(aeropuertoService);
//                     DeleteAeropuertoCase deleteAeropuertoCase = new DeleteAeropuertoCase(aeropuertoService);
// 
//                     AeropuertoController aeropuertoController = new AeropuertoController(createAeropuertoCase, 
//                         findAeropuertoCase, updateAeropuertoCase, deleteAeropuertoCase);
// 
//                     Object[] optionsAeropuerto = { "Crear aeropuerto", "Buscar aeropuerto", "Editar aeropuerto", 
//                         "Eliminar aeropuerto", "Salir" };
//                     Object menuAeropuerto = JOptionPane.showInputDialog(null, "Seleccione Una Opcion", 
//                         "Aeropuertos", JOptionPane.QUESTION_MESSAGE, null, optionsAeropuerto, "Crear aeropuerto");
// 
//                     int selectedIndexAeropuerto = -1; // default value for no selection or "Seleccione"
//                     for (int i = 0; i < optionsAeropuerto.length; i++) {
//                         if (optionsAeropuerto[i].equals(menuAeropuerto)) {
//                             selectedIndexAeropuerto = i;
//                             break;
//                         }
//                     }
// 
//                     switch (selectedIndexAeropuerto) {
//                         case 0:
//                             aeropuertoController.crear();
//                             break;
//                         case 1:
//                             aeropuertoController.buscar();
//                             break;
//                         case 2:
//                             aeropuertoController.actualizar();
//                             break;
//                         case 3:
//                             aeropuertoController.eliminar();
//                             break;
//                         default:
//                             break;
//                     }
//                     break;
//                 default:
//                     break;
//             }
//         } catch (SQLException e) {
//             e.printStackTrace();
//         }
//     }
// }
// 