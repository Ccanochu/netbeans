/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author PC
 */
public class EncargadoEntrega {
    private int ID_Encargado;
    private String nombre;

    public EncargadoEntrega() {
    }

    public EncargadoEntrega(int ID_Encargado, String nombre) {
        this.ID_Encargado = ID_Encargado;
        this.nombre = nombre;
    }
    
    

    public int getID_Encargado() {
        return ID_Encargado;
    }

    public void setID_Encargado(int ID_Encargado) {
        this.ID_Encargado = ID_Encargado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
