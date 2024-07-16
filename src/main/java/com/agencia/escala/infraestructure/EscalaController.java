package com.agencia.escala.infraestructure;

import java.util.Scanner;

import com.agencia.escala.application.DeleteEscalaUseCase;
import com.agencia.escala.application.FindEscalaUseCase;
import com.agencia.escala.application.UpdateEscalaUseCase;
import com.agencia.escala.domain.entity.Escala;



public class EscalaController {
    private final FindEscalaUseCase findEscalaUseCase;
    private final UpdateEscalaUseCase updateEscalaUseCase;
    private final DeleteEscalaUseCase deleteEscalaUseCase;

    public EscalaController(FindEscalaUseCase findEscalaUseCase, UpdateEscalaUseCase updateEscalaUseCase, DeleteEscalaUseCase deleteEscalaUseCase) {
        this.findEscalaUseCase = findEscalaUseCase;
        this.updateEscalaUseCase = updateEscalaUseCase;
        this.deleteEscalaUseCase = deleteEscalaUseCase;
    }

    Scanner scanner = new Scanner(System.in);

    public void gestionEscala() {

        while (true) {
            System.out.println("1. Encontrar Escala: ");
            System.out.println("2. Actualizar Escala: ");
            System.out.println("3. Eliminar Escala: ");

            System.out.println("4. Salir: ");

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

                    deleteEscala();

                    break;

                case 4:
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

    public void deleteEscala(){
        System.out.println("Ingrese el id de la escala que desea eliminar: ");
        int deleteEscala = scanner.nextInt();
        scanner.nextLine();

        // User userD = new User();
        deleteEscalaUseCase.execute(deleteEscala);

        if(deleteEscalaUseCase != null){
            System.out.println("Escala eliminada");
        }else{
            System.out.println("No eliminada");
        }
    }

}
