package com.agencia;
import java.util.Scanner;
import com.agencia.avion.domain.entity.Avion;
import com.agencia.avion.infraestructure.AvionRepository;

public class Main {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
        AvionRepository avionRepository = new AvionRepository();
        
        while (true) {
            System.out.println("1. Crear Avión");
            System.out.println("2. Salir");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea después de nextInt
            
            switch (opcion) {
                case 1:
                    // System.out.println("Ingrese ID del avión:");
                    // int id = scanner.nextInt();
                    // scanner.nextLine(); // Consumir el salto de línea después de nextInt

                    System.out.println("Ingrese matrícula del avión:");
                    String matricula = scanner.nextLine();

                    System.out.println("Ingrese capacidad:");
                    int capacidad = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea después de nextInt

                    System.out.print("Fecha de Fabricación (YYYY-MM-DD): ");
                    String fechaFabricacion = scanner.nextLine();

                    System.out.print("ID Estado: ");
                    int idEstado = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea después de nextInt

                    System.out.print("ID Modelo: ");
                    int idModelo = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea después de nextInt

                    System.out.print("ID Aerolínea: ");
                    int idAerolinea = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea después de nextInt

                    Avion avion = new Avion(matricula,capacidad, fechaFabricacion, idEstado, idModelo, idAerolinea);
                    avionRepository.createAvion(avion);
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
