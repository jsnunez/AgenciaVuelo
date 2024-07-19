
import java.util.Scanner;

import com.agencia.reserva.application.CreateReservaAgenteUseCase;
import com.agencia.reserva.infraestructure.in.ReservaController;
import com.agencia.reserva.infraestructure.out.ReservaRepository;



public class MainOlf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ReservaRepository reservaRepository=new ReservaRepository();        
        CreateReservaAgenteUseCase createReservaAgenteUseCase=new CreateReservaAgenteUseCase(reservaRepository);        
        ReservaController reservaController= new ReservaController(createReservaAgenteUseCase);
        
        while (true) {
            System.out.println("1. Gestion Reserva");
            
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea después de nextInt
            
            switch (opcion) {
                case 1:

                    reservaController.gestionReserva();

                    break;

                    

                case 6:

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