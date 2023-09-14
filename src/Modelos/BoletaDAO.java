/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;
import Clases.Boleta;
import java.util.List;
import Controlador.ConexionBD;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author PC
 */
public class BoletaDAO {

    
    public void saveBoleta(Boleta boleta) {
        String sql = "INSERT INTO tb_boletas (ID_Venta, ID_Producto, Cantidad, Monto_Pagado, Cambio, Fecha_Hora) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";
        
        try (Connection connection = ConexionBD.obtenerConexion();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            
            preparedStatement.setInt(1, boleta.getID_Venta());
            preparedStatement.setInt(2, boleta.getID_Producto());
            preparedStatement.setInt(3, boleta.getCantidad());
            preparedStatement.setDouble(4, boleta.getMonto_Pagado());
            preparedStatement.setDouble(5, boleta.getCambio());
            preparedStatement.setTimestamp(6, boleta.getFecha_Hora());
            
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Boleta guardada con éxito.");
            } else {
                System.out.println("No se pudo guardar la boleta.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Boleta> getBoletas() {
        List<Boleta> boletas = new ArrayList<>();
        String sql = "SELECT * FROM tb_boletas";
        
        try (Connection connection = ConexionBD.obtenerConexion();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            
            while (resultSet.next()) {
                int idBoleta = resultSet.getInt("ID_Boleta");
                int idVenta = resultSet.getInt("ID_Venta");
                int idProducto = resultSet.getInt("ID_Producto");
                int cantidad = resultSet.getInt("Cantidad");
                double montoPagado = resultSet.getDouble("Monto_Pagado");
                double cambio = resultSet.getDouble("Cambio");
                Timestamp fechaHora = resultSet.getTimestamp("Fecha_Hora");
                
                Boleta boleta = new Boleta(idBoleta, idVenta, idProducto, cantidad, montoPagado, cambio, fechaHora);
                boletas.add(boleta);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return boletas;
    }
    public interface OnGetBoletasCallback {
        void onGetBoletas(List<Boleta> boletas);
    }
    
    public void onGetBoletas(OnGetBoletasCallback callback) {
        String sql = "SELECT * FROM tb_boletas";

        try (Connection connection = ConexionBD.obtenerConexion();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Boleta> boletas = new ArrayList<>();
            while (resultSet.next()) {
                int idBoleta = resultSet.getInt("ID_Boleta");
                int idVenta = resultSet.getInt("ID_Venta");
                int idProducto = resultSet.getInt("ID_Producto");
                int cantidad = resultSet.getInt("Cantidad");
                double montoPagado = resultSet.getDouble("Monto_Pagado");
                double cambio = resultSet.getDouble("Cambio");
                Timestamp fechaHora = resultSet.getTimestamp("Fecha_Hora");
                
                Boleta boleta = new Boleta(idBoleta, idVenta, idProducto, cantidad, montoPagado, cambio, fechaHora);
                boletas.add(boleta);
            }

            // Llamar al callback con la lista de boletas
            callback.onGetBoletas(boletas);

        } catch (SQLException e) {
            e.printStackTrace();
            // Maneja el error según lo necesites
        }
    }



    public void deleteBoleta(int idBoleta) {
        String sql = "DELETE FROM tb_boletas WHERE ID_Boleta = ?";
    
        try (Connection connection = ConexionBD.obtenerConexion();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, idBoleta);
            int filasAfectadas = preparedStatement.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Boleta eliminada correctamente.");
            } else {
                System.out.println("No se pudo eliminar la boleta.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateBoleta(Boleta boleta) {
        // Código para actualizar una boleta en la base de datos
        String sql = "UPDATE tb_boletas SET ID_Venta = ?, ID_Producto = ?, Cantidad = ?, Monto_Pagado = ?, Cambio = ?, Fecha_Hora = ? WHERE ID_Boleta = ?";

        try (Connection connection = ConexionBD.obtenerConexion();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, boleta.getID_Venta());
            preparedStatement.setInt(2, boleta.getID_Producto());
            preparedStatement.setInt(3, boleta.getCantidad());
            preparedStatement.setDouble(4, boleta.getMonto_Pagado());
            preparedStatement.setDouble(5, boleta.getCambio());
            preparedStatement.setTimestamp(6, boleta.getFecha_Hora());
            preparedStatement.setInt(7, boleta.getID_Boleta());

            int filasAfectadas = preparedStatement.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Boleta actualizada correctamente.");
            } else {
                System.out.println("No se pudo actualizar la boleta.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
