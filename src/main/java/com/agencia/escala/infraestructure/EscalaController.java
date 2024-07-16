package com.agencia.escala.infraestructure;

import java.util.Scanner;

import com.agencia.escala.application.FindEscalaUseCase;
import com.agencia.escala.application.UpdateEscalaUseCase;
import com.agencia.escala.domain.entity.Escala;



public class EscalaController {
    private final FindEscalaUseCase findEscalaUseCase;
    private final UpdateEscalaUseCase updateEscalaUseCase;

    public EscalaController(FindEscalaUseCase findEscalaUseCase, UpdateEscalaUseCase updateEscalaUseCase) {
        this.findEscalaUseCase = findEscalaUseCase;
        this.updateEscalaUseCase = updateEscalaUseCase;
    }

    Scanner scanner = new Scanner(System.in);

    public void gestionEscala() {

        while (true) {
            System.out.println("1. Encontrar Escala: ");
            System.out.println("2. Actualizar Escala: ");
            System.out.println("3. Salir: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:

                    findEscalas();

                    break;

                case 2:

                    updateEscala();

                    break;

                case 3:
                    System.out.println("Saliendo...");
                    return;

                default:

                    break;

            }
        }

    }

    public void findEscalas() {

        System.out.println("Cuál es el id del trayecto del cual desea consultar las escalas: ");
        int idViaje = scanner.nextInt();
        scanner.nextLine();

        Escala findEscala = findEscalaUseCase.execute(idViaje);

        if (findEscala != null) {
            System.out.println("Escala id: " + findEscala.getId());
            System.out.println("Numero de conexiòn: " + findEscala.getNumeroConexion());
            System.out.println("Id trayecto: " + findEscala.getIdViaje());
            System.out.println("Id Avión: " + findEscala.getIdAvion());
            System.out.println("Id aeropuerto: " + findEscala.getIdAeropuerto());
        } else {
            System.out.println("Escala not found");
        }

    }

    public void updateEscala() {

        System.out.println("Ingrese el id de la escala a actualizar: ");
        int idEscalaUpdate = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese el nuevo id del avión ");
        int nuevoAvion = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese el nuevo id del aeropuerto");
        String nuevoAeropuerto = scanner.nextLine();

        Escala newEscala = new Escala();

        newEscala.setId(idEscalaUpdate);
        newEscala.setIdAvion(nuevoAvion);
        newEscala.setIdAeropuerto(nuevoAeropuerto);

        updateEscalaUseCase.execute(newEscala);

    }

}
