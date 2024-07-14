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
            System.out.println("5. Consultar informacion del cliente.");
            System.out.println("7. Registrar cliente.");
            System.out.println("10. Registrar Aeropuerto.");
            System.out.println("11. Consultar informacion del Aeropuerto.");
            System.out.println("13. Actualizar informacion del Clieente.");
            System.out.println("20. Actualizar informacion del aeropuerto.");
            System.out.println("21. Eliminar el Aeropuerto.");
            System.out.println("22. Eliminar informacion del cliente.");
            System.out.println("34. Registrar tipo de Documento.");
            System.out.println("35. Actualizar tipo de Documento.");
            System.out.println("36. Eliminar tipo de Documento.");
            System.out.println("37. COnsular tipo de Documento.");
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

                case 7:

                //INSERT INTO clientes (nombre, edad, idtipodocumento, numerodocumento,rol)
                //VALUES ('Juan Pérez', 30, 1, '12345678',1);
                System.out.println("Ingresa los siguientes datos: ");

                
                

                default:
                    System.out.println("Opción inválida");
                    break;
            }
        }
    }
    }
