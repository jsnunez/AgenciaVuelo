package com.agencia;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.agencia.tarifa.application.CreateTarifaUseCase;
import com.agencia.tarifa.application.DeleteTarifaUseCase;
import com.agencia.tarifa.application.FindTarifaUseCase;
import com.agencia.tarifa.application.UpdateTarifaUseCase;
import com.agencia.tarifa.domain.service.TarifaService;
import com.agencia.tarifa.infraestructure.in.TarifaController;
import com.agencia.tarifa.infraestructure.out.TarifaRepository;

public class mainsebastian {
    public static void main(String[] args) {
        // Scanner scanner = new Scanner(System.in);
        TarifaService tarifaService = new TarifaRepository();

        CreateTarifaUseCase createtarifaUseCase = new CreateTarifaUseCase(tarifaService);
        FindTarifaUseCase findtarifaUseCase = new FindTarifaUseCase(tarifaService);
        UpdateTarifaUseCase updateCaseUsetarifa = new UpdateTarifaUseCase(tarifaService);
        DeleteTarifaUseCase deletetarifaUseCase = new DeleteTarifaUseCase(tarifaService);

        TarifaController consoleAdapter = new TarifaController(createtarifaUseCase, findtarifaUseCase,
                deletetarifaUseCase, updateCaseUsetarifa);

        try {
            Object[] options = { "Crear tarifa", "Buscar tarifa", "Editar tarifa", "Eliminar tarifa", " Salir" };
            Object color = JOptionPane.showInputDialog(null, "Seleccione Una Opcion",
                    "MYSQL", JOptionPane.QUESTION_MESSAGE, null, options, "Crear usuario");

            int selectedIndex = -1; // default value for no selection or "Seleccione"
            for (int i = 0; i < options.length; i++) {
                if (options[i].equals(color)) {
                    selectedIndex = i;
                    break;
                }
            }
           
            switch (selectedIndex) {
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
        
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
