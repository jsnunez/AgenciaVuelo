package com.agencia.escala.infraestructure;

import java.util.Scanner;
import com.agencia.escala.application.FindEscalaUseCase;
import com.agencia.escala.domain.entity.Escala;

public class EscalaController {
    private final FindEscalaUseCase findEscalaUseCase;

    public EscalaController(FindEscalaUseCase findEscalaUseCase) {
        this.findEscalaUseCase = findEscalaUseCase;
    }

    Scanner scanner = new Scanner(System.in);

    public void gestionEscala(){

        while(true){
            System.out.println("1. Encontrar Escala: ");
            System.out.println("2. Salir: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:

                    findEscalas();
                    
                    break;

                case 2:

                    return;
            
                default:
                
                    break;

        }
    }

}

    public void findEscalas(){

        System.out.println("Cuál es el id del trayecto del cual desea consultar las escalas: ");
        int idViaje = scanner.nextInt();
        scanner.nextLine();

        Escala findEscala = findEscalaUseCase.execute(idViaje);

        if(findEscala != null){
            System.out.println("Escala id: " + findEscala.getId());
            System.out.println("Numero de conexiòn: " + findEscala.getNumeroConexion());
            System.out.println("Id trayecto: " + findEscala.getIdViaje());
            System.out.println("Id avion: " + findEscala.getIdAvion());
            System.out.println("Id aeropuerto: " + findEscala.getIdAeropuerto());
        }
        else{
            System.out.println("Escala not found");
        }

    }
}

