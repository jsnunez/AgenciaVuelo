package com.agencia.revision.infraestructure;

import java.util.Scanner;

import com.agencia.revision.application.CreateRevisionUseCase;
import com.agencia.revision.domain.entity.Revision;

public class RevisionController{
    private final CreateRevisionUseCase createRevisionUseCase;

    public RevisionController(CreateRevisionUseCase createRevisionUseCase){
        this.createRevisionUseCase = createRevisionUseCase;
    }

    Scanner scanner = new Scanner(System.in);

    public void gestionRevision(){


        while(true){
            System.out.println("1. Crear Revision: ");
            System.out.println("2. Borrar Revision: ");
            System.out.println("3. Encontrar Revision: ");
            System.out.println("4. Actualizar Revision: ");
            System.out.println("5. Salir: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:

                    createRevision();
                    break;
            }
        }
    }

    public void createRevision(){

        System.out.println("Ingrese la fecha de la revisión (YYYY-MM-DD):");
        String fechaRevision = scanner.nextLine();
        
        System.out.println("Ingrese el ID del avion:");
        int idAvion = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea después de nextInt
        
        System.out.print("Ingrese la descripción de la revisión ");
        String descripcion = scanner.nextLine();
        
        System.out.print("Ingrese el id del empleado: ");
        int idEmpleado = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea después de nextInt

        Revision revision = new Revision();

        revision.setFechaRevision(fechaRevision);
        revision.setIdAvion(idAvion);
        revision.setDescripcion(descripcion);
        revision.setIdEmpleado(idEmpleado);

        createRevisionUseCase.execute(revision);
        System.out.println("Revision creada exitosamente. ");

    }



}





