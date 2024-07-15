package com.agencia.trayecto.infraestructure;

import java.util.Scanner;


import com.agencia.trayecto.application.FindTrayectoUseCase;
import com.agencia.trayecto.domain.entity.Trayecto;

public class TrayectoController {

    private final FindTrayectoUseCase findTrayectoUseCase;

    public TrayectoController(FindTrayectoUseCase findTrayectoUseCase){
        this.findTrayectoUseCase = findTrayectoUseCase;
    }


    Scanner scanner = new Scanner(System.in);

    public void gestionTrayecto(){

        while (true) {
            
            System.out.println("1. Encontrar trayecto: ");
            System.out.println("2. Salir: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    
                    findTrayecto();

                    break;
            
                default:
                    break;
            }

        }

    }

    public void findTrayecto(){

        System.out.println("Cuál es el id del trayecto que desea consultar: ");
        int idTrayecto = scanner.nextInt();
        scanner.nextLine();

        Trayecto foundTrayecto = findTrayectoUseCase.execute(idTrayecto);

        if(foundTrayecto != null){
            System.out.println("Trayecto id: " + foundTrayecto.getId());
            System.out.println("Trayecto fecha viaje: " + foundTrayecto.getFechaViaje());
            System.out.println("Precio viaje trayecto: " + foundTrayecto.getPrecioViaje());
            System.out.println("Aeropuerto Origen Trayecto: " + foundTrayecto.getIdOrigenAeropuerto());
            System.out.println("Aeropuerto Destino Trayecto: " + foundTrayecto.getIdDestinoAeropuerto());
        }else{
            System.out.println("Trayecto no encontrado :c");
        }

    }

}
