/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import Clases.Venta;
import Controlador.ConexionBD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class VentasDAO {
    
    public void saveVenta(Venta venta) {
        String sql = "INSERT INTO ventas (id_cliente, numero_mesa, atendido_por, fecha, total) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection connection = ConexionBD.obtenerConexion();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            
            preparedStatement.setInt(1, venta.getIdCliente());
            preparedStatement.setInt(2, venta.getNumeroMesa());
            preparedStatement.setString(3, venta.getAtendidoPor());
            preparedStatement.setString(4, venta.getFecha());
            preparedStatement.setDouble(5, venta.getTotal());
            
            preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public int obtenerUltimoIdVenta() {
        String sql = "SELECT MAX(id_venta) as max_id FROM ventas";
        
        try (Connection connection = ConexionBD.obtenerConexion();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
                int ultimoId = resultSet.getInt("max_id");
                return ultimoId;
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return -1; // En caso de error o si no hay registros
    }
    
}
