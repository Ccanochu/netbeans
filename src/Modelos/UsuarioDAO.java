/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import Clases.Usuario;
import Controlador.ConexionBD;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author PC
 */
public class UsuarioDAO {

    public boolean autenticarUsuario(String username, String contraseña) {
        boolean credencialesCorrectas = false;

        String sql = "SELECT * FROM usuarios WHERE username = ? AND password = ?";
        try (Connection connection = ConexionBD.obtenerConexion();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, contraseña);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                credencialesCorrectas = true;
            } else {
                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return credencialesCorrectas;
    }
    
    public void saveUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuarios (username, password, idaux) VALUES (?, ?, ?)";
        
        try (Connection connection = ConexionBD.obtenerConexion();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            
            preparedStatement.setString(1, usuario.getUsername());
            preparedStatement.setString(2, usuario.getPassword());
            preparedStatement.setInt(3, usuario.getIdaux());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Usuario guardado con éxito.");
            } else {
                System.out.println("No se pudo guardar el Usuario.");
            }   
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
