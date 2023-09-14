/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;
import Clases.EncargadoEntrega;
import Controlador.ConexionBD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author PC
 */
public class EncargadoEntregaDAO {
    public void saveEncargadoEntrega(EncargadoEntrega encargadoEntrega) {
        String sql = "INSERT INTO encargados_entrega (Nombre) VALUES (?)";
        
        try (Connection connection = ConexionBD.obtenerConexion();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            
            preparedStatement.setString(1, encargadoEntrega.getNombre());
            
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Encargado guardada con éxito.");
            } else {
                System.out.println("No se pudo guardar la Encargado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<EncargadoEntrega> getEncargadoEntrega() {
        List<EncargadoEntrega> encargados = new ArrayList<>();
        String sql = "SELECT * FROM encargados_entrega";
        
        try (Connection connection = ConexionBD.obtenerConexion();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            
            while (resultSet.next()) {
                int idEncargado = resultSet.getInt("ID_Encargado");
                String nombre = resultSet.getString("Nombre");
                
                EncargadoEntrega encargado = new EncargadoEntrega(idEncargado, nombre);
                encargados.add(encargado);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return encargados;
    }
    

    public void deleteEncargadoEntrega(int idEncargadoEntrega) {
        String sql = "DELETE FROM encargados_entrega WHERE ID_Encargado = ?";
    
        try (Connection connection = ConexionBD.obtenerConexion();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, idEncargadoEntrega);
            int filasAfectadas = preparedStatement.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Encargado eliminada correctamente.");
            } else {
                System.out.println("No se pudo eliminar la Encargado.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateEncargadoEntrega(EncargadoEntrega encargadoEntrega, int idEncargadoEntrega) {
        // Código para actualizar una boleta en la base de datos
        String sql = "UPDATE encargados_entrega SET Nombre = ? WHERE ID_Encargado = ?";

        try (Connection connection = ConexionBD.obtenerConexion();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            
            preparedStatement.setString(1, encargadoEntrega.getNombre());
            preparedStatement.setInt(2, idEncargadoEntrega);

            int filasAfectadas = preparedStatement.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Encargado actualizada correctamente.");
            } else {
                System.out.println("No se pudo actualizar la Encargado.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
