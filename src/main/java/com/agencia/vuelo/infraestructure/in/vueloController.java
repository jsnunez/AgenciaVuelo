package com.agencia.vuelo.infraestructure.in;

import java.math.BigDecimal;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.agencia.vuelo.application.ConsultvueloUseCase;
import com.agencia.vuelo.application.DeletevueloUseCase;
import com.agencia.vuelo.application.FindvueloUseCase;
import com.agencia.vuelo.application.UpdatevueloUseCase;
import com.agencia.vuelo.domain.entity.VuelosDto;
import com.agencia.vuelo.domain.entity.vuelo;

public class vueloController {
    private ConsultvueloUseCase consultvueloUseCase;
    private FindvueloUseCase findvueloUseCase;
    private DeletevueloUseCase deletevueloUseCase;
    private UpdatevueloUseCase updatevueloUseCase;

    public vueloController(ConsultvueloUseCase consultvueloUseCase, FindvueloUseCase findvueloUseCase,
            DeletevueloUseCase deletevueloUseCase, UpdatevueloUseCase updatevueloUseCase) {
        this.consultvueloUseCase = consultvueloUseCase;
        this.findvueloUseCase = findvueloUseCase;
        this.deletevueloUseCase = deletevueloUseCase;
        this.updatevueloUseCase = updatevueloUseCase;
    }

    public vueloController(ConsultvueloUseCase consultvueloUseCase) {
        this.consultvueloUseCase = consultvueloUseCase;
    }

    public void consultar() throws SQLException {
        String idString = JOptionPane.showInputDialog("Ingrese ID vuelo");
        int id = Integer.parseInt(idString);
        VuelosDto vuelo = new VuelosDto();

        vuelo = consultvueloUseCase.execute(id);
        

    }

    public void buscar() throws SQLException {
        String idString = JOptionPane.showInputDialog("Ingrese ID vuelo");
        int id = Integer.parseInt(idString);
        vuelo vuelo = new vuelo();
        vuelo = findvueloUseCase.execute(id);
        System.out.println("Id: " + vuelo.getId());

    }

    public void actualizar() throws SQLException {
        String idString = JOptionPane.showInputDialog("Ingrese id modificar");
        int id = Integer.parseInt(idString);
        String descripcion = JOptionPane.showInputDialog("Ingrese descripcion");
        String detalle = JOptionPane.showInputDialog("Ingrese detalle");
        String valorString = JOptionPane.showInputDialog("Ingrese valor");
        vuelo vuelo = new vuelo();
        BigDecimal valor = new BigDecimal(valorString);
        vuelo.setId(id);
        updatevueloUseCase.execute(vuelo);
    }
    
    public void eliminar() throws SQLException {
        String idString = JOptionPane.showInputDialog("Ingrese id a eliminar");
        int id = Integer.parseInt(idString);
        deletevueloUseCase.execute(id);
    }
}
