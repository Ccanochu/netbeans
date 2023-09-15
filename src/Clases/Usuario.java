/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author PC
 */
public class Usuario {
    private String username;
    private String password;
    private int idaux;

    public Usuario() {
    }

    public Usuario(String username, String password, int idaux) {
        this.username = username;
        this.password = password;
        this.idaux = idaux;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdaux() {
        return idaux;
    }

    public void setIdaux(int idaux) {
        this.idaux = idaux;
    }

    
    
    

}
