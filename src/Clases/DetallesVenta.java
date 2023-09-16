/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author PC
 */
public class DetallesVenta {
    private int idDetalle;
    private int idVenta;
    private String descripcion;
    private int cantidad;
    private double precio;
    private double impuesto;

    public DetallesVenta() {
    }

    public DetallesVenta(int idDetalle, int idVenta, String descripcion, int cantidad, double precio, double impuesto) {
        this.idDetalle = idDetalle;
        this.idVenta = idVenta;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precio = precio;
        this.impuesto = impuesto;
    }

    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(double impuesto) {
        this.impuesto = impuesto;
    }

    
    
}
