/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.security.Timestamp;

/**
 *
 * @author PC
 */
public class Venta {
    private int idVenta;
    private int idCliente;
    private int numeroMesa;
    private String atendidoPor;
    private String fecha; 
    private double total;


    public Venta() {
    }

    public Venta(int idVenta, int idCliente, int numeroMesa, String atendidoPor, String fecha, double total) {
        this.idVenta = idVenta;
        this.idCliente = idCliente;
        this.numeroMesa = numeroMesa;
        this.atendidoPor = atendidoPor;
        this.fecha = fecha;
        this.total = total;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getNumeroMesa() {
        return numeroMesa;
    }

    public void setNumeroMesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    public String getAtendidoPor() {
        return atendidoPor;
    }

    public void setAtendidoPor(String atendidoPor) {
        this.atendidoPor = atendidoPor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    
}
