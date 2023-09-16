/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.ArrayList;
import java.util.List;

public class GestionPedidos {
    private List<Orden> listaOrdenes = new ArrayList<>();

    public void agregarOrden(Orden orden) {
        listaOrdenes.add(orden);
    }

    public List<Orden> obtenerOrdenes() {
        return listaOrdenes;
    }
}