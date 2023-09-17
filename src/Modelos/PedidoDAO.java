/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import Clases.Bebida;
import Clases.DetallesBebida;
import Clases.DetallesPlato;
import Clases.Plato;
import Controlador.ConexionBD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Clases.Orden;

public class PedidoDAO {
    
    public void agregarPedido(Orden orden, double total, int cantidadPlato, int cantidadBebida) {
        DetallesPlato plato = orden.getPlato();
        DetallesBebida bebida = orden.getBebida();

        if (plato == null || bebida == null) {
            System.out.println("Debes seleccionar tanto un plato como una bebida para realizar un pedido.");
            return;
        }

        String sql = "INSERT INTO pedidos (id_plato, id_bebida, estado, total, cantidad_plato, cantidad_bebida) VALUES (?, ?, 'debe', ?, ?, ?)";

        try (Connection connection = ConexionBD.obtenerConexion();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            int idPlato = obtenerIdPlatoPorNombre(plato.getNombre());
            int idBebida = obtenerIdBebidaPorNombre(bebida.getNombre());

            preparedStatement.setInt(1, idPlato);
            preparedStatement.setInt(2, idBebida);
            preparedStatement.setDouble(3, total);
            preparedStatement.setInt(4, cantidadPlato);
            preparedStatement.setInt(5, cantidadBebida);

            preparedStatement.executeUpdate();

            System.out.println("Pedido registrado correctamente.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private int obtenerIdPlatoPorNombre(String nombre) {
        String sql = "SELECT id_plato FROM platos WHERE nombre = ?";
        int id = -1; // Valor predeterminado si no se encuentra el plato

        try (Connection connection = ConexionBD.obtenerConexion();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, nombre);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                id = resultSet.getInt("id_plato");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;
    }

    private int obtenerIdBebidaPorNombre(String nombre) {
        String sql = "SELECT id_bebida FROM bebidas WHERE nombre = ?";
        int id = -1; // Valor predeterminado si no se encuentra la bebida

        try (Connection connection = ConexionBD.obtenerConexion();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, nombre);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                id = resultSet.getInt("id_bebida");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;
    }
    
    public void actualizarEstadoPedido(int idPedido, String nuevoEstado) {
        String sql = "UPDATE pedidos SET estado = ? WHERE id_pedido = ?";

        try (Connection connection = ConexionBD.obtenerConexion();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, nuevoEstado);
            preparedStatement.setInt(2, idPedido);

            preparedStatement.executeUpdate();

            System.out.println("Estado del pedido actualizado correctamente.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void actualizarEstadoPedidos(String nuevoEstado){
        String sql = "UPDATE pedidos SET estado = ?";
        
        try (Connection connection = ConexionBD.obtenerConexion();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, nuevoEstado);
            System.out.println("Estado del pedido actualizado correctamente.");
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
