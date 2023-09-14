/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.sql.Timestamp;

/**
 *
 * @author PC
 */
public class Boleta {
    private int ID_Boleta;
    private int ID_Venta;
    private int ID_Producto;
    private int cantidad;
    private double monto_Pagado;
    private double cambio;
    private Timestamp fecha_Hora;

    public Boleta() {
    }

    
    
    public Boleta(int ID_Boleta, int ID_Venta, int ID_Producto, int cantidad, double monto_Pagado, double cambio, Timestamp fecha_Hora) {
        this.ID_Boleta = ID_Boleta;
        this.ID_Venta = ID_Venta;
        this.ID_Producto = ID_Producto;
        this.cantidad = cantidad;
        this.monto_Pagado = monto_Pagado;
        this.cambio = cambio;
        this.fecha_Hora = fecha_Hora;
    }
    
    

    public int getID_Boleta() {
        return ID_Boleta;
    }

    public void setID_Boleta(int ID_Boleta) {
        this.ID_Boleta = ID_Boleta;
    }

    public int getID_Venta() {
        return ID_Venta;
    }

    public void setID_Venta(int ID_Venta) {
        this.ID_Venta = ID_Venta;
    }

    public int getID_Producto() {
        return ID_Producto;
    }

    public void setID_Producto(int ID_Producto) {
        this.ID_Producto = ID_Producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getMonto_Pagado() {
        return monto_Pagado;
    }

    public void setMonto_Pagado(double monto_Pagado) {
        this.monto_Pagado = monto_Pagado;
    }

    public double getCambio() {
        return cambio;
    }

    public void setCambio(double cambio) {
        this.cambio = cambio;
    }

    public Timestamp getFecha_Hora() {
        return fecha_Hora;
    }

    public void setFecha_Hora(Timestamp fecha_Hora) {
        this.fecha_Hora = fecha_Hora;
    }
    
    
}
