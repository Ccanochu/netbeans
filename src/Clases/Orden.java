/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author PC
 */
public class Orden {
    private DetallesPlato plato;
    private DetallesBebida bebida;

    public Orden() {
    }
    
    

    public Orden(DetallesPlato plato, DetallesBebida bebida) {
        this.plato = plato;
        this.bebida = bebida;
    }

    public DetallesPlato getPlato() {
        return plato;
    }

    public DetallesBebida getBebida() {
        return bebida;
    }
}
