/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package singleton;

/**
 *
 * @author PC
 */
public class DatosCompartidos {
    private static String textoConcatenado = "";

    public static String getTextoConcatenado() {
        return textoConcatenado;
    }

    public static void setTextoConcatenado(String texto) {
        textoConcatenado = texto;
    }
}
