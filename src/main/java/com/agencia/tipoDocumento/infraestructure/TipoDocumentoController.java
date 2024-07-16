package com.agencia.tipoDocumento.infraestructure;

import java.util.Scanner;

import com.agencia.tipoDocumento.application.CreateTipoDocumentoUseCase;
import com.agencia.tipoDocumento.domain.entity.TipoDocumento;

public class TipoDocumentoController {

    private final CreateTipoDocumentoUseCase tipoDocumentoUseCase;

    public TipoDocumentoController(CreateTipoDocumentoUseCase tipoDocumentoUseCase) {
        this.tipoDocumentoUseCase = tipoDocumentoUseCase;
    }

    Scanner scanner=new Scanner(System.in);
    public void gestionTipoDocumento() {
        while (true) {
            System.out.println("1. crear tipo documento");
            System.out.println("2. Eliminar tipo documento");
            System.out.println("3. Modificar tipo documento");
            System.out.println("4. Buscar documento");
            System.out.println("5. Salir");

            int opcion=scanner.nextInt();
            scanner.nextLine();
            
            switch (opcion) {
                case 1:
                    createTipoDocumento();
                default:
                 break;
            }
            
        }

    }
    public void createTipoDocumento(){
        System.out.print(" ingrese nombre de documento: ");
        String nombre = scanner.nextLine();

        TipoDocumento tipoDocumento=new TipoDocumento();
        tipoDocumento.setNombre(nombre);
        tipoDocumentoUseCase.execute(tipoDocumento);

        System.out.println("creado siuuuuuuuu");
    }
}
