/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import Clases.DetallesVenta;
import Controlador.ConexionBD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class DetallesVentaDAO {
    public void saveDetallesVenta(DetallesVenta detallesVenta) {
        String sql = "INSERT INTO detalles_venta (id_venta, descripcion, cantidad, precio, impuesto) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection connection = ConexionBD.obtenerConexion();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            
            preparedStatement.setInt(1, detallesVenta.getIdVenta());
            preparedStatement.setString(2, detallesVenta.getDescripcion());
            preparedStatement.setInt(3, detallesVenta.getCantidad());
            preparedStatement.setDouble(4, detallesVenta.getPrecio());
            preparedStatement.setDouble(5, detallesVenta.getImpuesto());
            
            preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
}
