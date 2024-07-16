package com.agencia.tipoDocumento.infraestructure;

import java.util.Scanner;

import com.agencia.tipoDocumento.application.CreateTipoDocumentoUseCase;
import com.agencia.tipoDocumento.application.UpdateTipoDocumentoUseCase;
import com.agencia.tipoDocumento.domain.entity.TipoDocumento;

public class TipoDocumentoController {

    private final CreateTipoDocumentoUseCase createTipoDocumentoUseCase;
    private final UpdateTipoDocumentoUseCase updateTipoDocumentoUseCase;

    public TipoDocumentoController(CreateTipoDocumentoUseCase createTipoDocumentoUseCase, UpdateTipoDocumentoUseCase updateTipoDocumentoUseCase ) {
        this.createTipoDocumentoUseCase = createTipoDocumentoUseCase;
        this.updateTipoDocumentoUseCase = updateTipoDocumentoUseCase;
    }
    

    Scanner scanner = new Scanner(System.in);

    public void gestionTipoDocumento() {
        while (true) {
            System.out.println("1. crear tipo documento");
            System.out.println("2. Eliminar tipo documento");
            System.out.println("3. Modificar tipo documento");
            System.out.println("4. Buscar documento");
            System.out.println("5. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    createTipoDocumento();
                    break;
                case 2:
                    updateTipoDocumento();
                    break;

                default:
                    break;
            }

        }

    }

    public void createTipoDocumento() {
        System.out.print(" ingrese nombre de documento: ");
        String nombre = scanner.nextLine();

        TipoDocumento tipoDocumento = new TipoDocumento();
        tipoDocumento.setNombre(nombre);
        createTipoDocumentoUseCase.execute(tipoDocumento);

        System.out.println("creado siuuuuuuuu");
    }
    public void updateTipoDocumento(){
        System.out.println("Ingrese el id del documento a modificar");
        int idUpdtTipoDocumento = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese nuevo nombre del documento");
        String nombreupdtTipoDocumento = scanner.nextLine();

        TipoDocumento updttipoDocumento=new TipoDocumento();
        updttipoDocumento.setId(idUpdtTipoDocumento);
        updttipoDocumento.setNombre(nombreupdtTipoDocumento);

        updateTipoDocumentoUseCase.execute(updttipoDocumento);

    }
}
