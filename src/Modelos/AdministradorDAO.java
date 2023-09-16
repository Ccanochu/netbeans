/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import Clases.Administrador;
import Controlador.ConexionBD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class AdministradorDAO {
    
    
    public void saveAdministrador(Administrador administrador) {
        String sql = "INSERT INTO administradores (nombre, email, telefono) VALUES (?, ?, ?)";
        
        try (Connection connection = ConexionBD.obtenerConexion();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            
            preparedStatement.setString(1, administrador.getNombre());
            preparedStatement.setString(2, administrador.getEmail());
            preparedStatement.setInt(3, administrador.getTelefono());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Administrador guardado con éxito.");
            } else {
                System.out.println("No se pudo guardar el admininistrador.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public int obtenerNuevoIdAdmin() {
        String sql = "SELECT MAX(id_administrador) FROM administradores"; // Asegúrate de tener una tabla de IDs
        try (Connection connection = ConexionBD.obtenerConexion();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                return resultSet.getInt(1) + 1; // Obtén el último ID y suma 1 para obtener el siguiente
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; // Manejo de error
    }
}
