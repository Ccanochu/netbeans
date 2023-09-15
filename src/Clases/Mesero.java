/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author PC
 */
public class Mesero {
    private int id_mesero;
    private String nombre;
    private String email;
    private int telefono;
    private int numero_mesero;
    private String numero_mesa;

    public Mesero() {
    }

    public Mesero(int id_mesero, String nombre, String email, int telefono, int numero_mesero, String numero_mesa) {
        this.id_mesero = id_mesero;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.numero_mesero = numero_mesero;
        this.numero_mesa = numero_mesa;
    }

    public int getId_mesero() {
        return id_mesero;
    }

    public void setId_mesero(int id_mesero) {
        this.id_mesero = id_mesero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getNumero_mesero() {
        return numero_mesero;
    }

    public void setNumero_mesero(int numero_mesero) {
        this.numero_mesero = numero_mesero;
    }

    public String getNumero_mesa() {
        return numero_mesa;
    }

    public void setNumero_mesa(String numero_mesa) {
        this.numero_mesa = numero_mesa;
    }

    
    

}
