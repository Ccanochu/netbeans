/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import Clases.Cliente;
import Controlador.ConexionBD;
import java.sql.*;
/**
 *
 * @author PC
 */
public class ClienteDAO {
    
    public void saveCliente(Cliente cliente) {
        String sql = "INSERT INTO clientes (nombre, dni, telefono) VALUES (?, ?, ?)";
        
        try (Connection connection = ConexionBD.obtenerConexion();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            
            preparedStatement.setString(1, cliente.getNombre());
            preparedStatement.setInt(2, cliente.getDni());
            preparedStatement.setInt(3, cliente.getTelefono());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Cliente guardado con éxito.");
            } else {
                System.out.println("No se pudo guardar el cliente.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public int obtenerUltimoIdCliente() {
        int ultimoId = -1;
        String sql = "SELECT MAX(id_cliente) FROM clientes";

        try (Connection connection = ConexionBD.obtenerConexion();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                ultimoId = resultSet.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ultimoId;
    }
}
