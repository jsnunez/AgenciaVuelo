package com.agencia.reserva.infraestructure.in;

import java.util.Scanner;

import com.agencia.reserva.application.CreateReservaAgenteUseCase;
import com.agencia.reserva.domain.entity.Reserva;

public class ReservaController {
    private final CreateReservaAgenteUseCase createReservaAgenteUseCase;

    public ReservaController(CreateReservaAgenteUseCase createReservaAgenteUseCase) {
        this.createReservaAgenteUseCase = createReservaAgenteUseCase;
    }

     Scanner scanner = new Scanner(System.in);

    public void gestionReserva() {
        while (true) {
            System.out.println("1. crear Reserva");
            System.out.println("2. Modificar tipo documento");
            System.out.println("3. Eliminar tipo documento");
            System.out.println("4. Buscar documento");
            System.out.println("5. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    createReserva();
                    break;
                // case 2:
                //     updateTipoDocumento();
                //     break;
                // case 3: 
                // deleteTipoDocumento();
                // break;

                // case 4:
                // findIdtipoDocumento();
                // break;

                default:
                    break;
            }

        }
    }
    
    private void createReserva() {
        System.out.println("ingrese fecha  AAAA-MM-DD");
        String fechaInput=scanner.nextLine();

        System.out.println("Ingrese id vuelo");
        int idVueloReservaAgente=scanner.nextInt();
        scanner.nextLine();

        System.out.println("ingrese ud cliente");
        int idClienteReservaAgente=scanner.nextInt();
        scanner.nextLine();

        Reserva reserva=new Reserva();
        reserva.setFechaReserva(fechaInput);
        reserva.setIdVuelo(idVueloReservaAgente);
        reserva.setIdCliente(idClienteReservaAgente);
        createReservaAgenteUseCase.execute(reserva);
        

    }

}
