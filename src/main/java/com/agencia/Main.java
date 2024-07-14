package com.agencia;
import java.util.Scanner;

import com.agencia.avion.application.CreateAvionUseCase;
import com.agencia.avion.application.DeleteAvionUseCase;
import com.agencia.avion.application.FindAvionUseCase;
import com.agencia.avion.application.UpdateAvionUseCase;
import com.agencia.avion.domain.entity.Avion;
import com.agencia.avion.infraestructure.AvionController;
import com.agencia.avion.infraestructure.AvionRepository;

public class Main {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
        AvionRepository avionRepository = new AvionRepository();
        FindAvionUseCase findAvionUseCase = new FindAvionUseCase(avionRepository);
        CreateAvionUseCase createAvionUseCase = new CreateAvionUseCase(avionRepository);
        DeleteAvionUseCase deleteAvionUseCase = new DeleteAvionUseCase(avionRepository);
        UpdateAvionUseCase updateAvionUseCase = new UpdateAvionUseCase(avionRepository);

        AvionController avionController = new AvionController(createAvionUseCase, updateAvionUseCase, deleteAvionUseCase, findAvionUseCase);
        
        while (true) {
            System.out.println("1. Gestion Avión");
            System.out.println("2. Salir");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea después de nextInt
            
            switch (opcion) {
                case 1:

                    avionController.gestionAvion();

                    break;

                    
                case 2:
                    System.out.println("Saliendo...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opción inválida");
                    break;
            }
        }
    }
    }
