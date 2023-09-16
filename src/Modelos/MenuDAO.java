/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import Clases.Bebida;
import Clases.DetallePedido;
import Clases.DetallesBebida;
import Clases.DetallesPlato;
import Clases.Plato;
import Controlador.ConexionBD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MenuDAO {

    public List<String> obtenerNombresPlatos() {
        List<String> listaNombres = new ArrayList<>();
        String sql = "SELECT nombre FROM platos";
        
        try (Connection connection = ConexionBD.obtenerConexion();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String nombre = resultSet.getString("nombre");
                listaNombres.add(nombre);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return listaNombres;
    }
    
    // Obtener lista de platos desde la base de datos
    public List<Plato> obtenerListaPlatos() {
        List<Plato> listaPlatos = new ArrayList<>();
        String sql = "SELECT * FROM platos";
        
        try (Connection connection = ConexionBD.obtenerConexion();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int idPlato = resultSet.getInt("id_plato");
                String nombre = resultSet.getString("nombre");
                int cantidad = resultSet.getInt("cantidad");
                double precio = resultSet.getDouble("precio");

                Plato plato = new Plato(idPlato, nombre, cantidad, precio);
                listaPlatos.add(plato);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return listaPlatos;
    }

    // Agregar un nuevo plato a la base de datos
    public void agregarPlato(Plato plato) {
        String sql = "INSERT INTO platos (nombre, cantidad, precio) VALUES (?, ?, ?)";
        
        try (Connection connection = ConexionBD.obtenerConexion();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, plato.getNombre());
            preparedStatement.setInt(2, plato.getCantidad());
            preparedStatement.setDouble(3, plato.getPrecio());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Plato agregado con éxito.");
            } else {
                System.out.println("No se pudo agregar el plato.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Eliminar un plato de la base de datos
    public void eliminarPlato(int idPlato) {
        String sql = "DELETE FROM platos WHERE id_plato = ?";
        
        try (Connection connection = ConexionBD.obtenerConexion();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, idPlato);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Plato eliminado con éxito.");
            } else {
                System.out.println("No se pudo eliminar el plato.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updatePlato(Plato plato, int idPlato) {
        String sql = "UPDATE platos SET nombre = ?, cantidad = ?, precio = ? WHERE id_plato = ?";

        try (Connection connection = ConexionBD.obtenerConexion();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            
            preparedStatement.setString(1, plato.getNombre());
            preparedStatement.setInt(2, plato.getCantidad());
            preparedStatement.setDouble(3, plato.getPrecio());
            preparedStatement.setInt(4, idPlato);

            int filasAfectadas = preparedStatement.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Plato actualizado correctamente.");
            } else {
                System.out.println("No se pudo actualizar el plato.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Actualizar la cantidad de un plato en la base de datos
    public void actualizarCantidadPlato(String nombrePlato, int cantidad) {
        String sql = "UPDATE platos SET cantidad = cantidad - ? WHERE nombre = ?";
        
        try (Connection connection = ConexionBD.obtenerConexion();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, cantidad);
            preparedStatement.setString(2, nombrePlato);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Cantidad de plato actualizada con éxito.");
            } else {
                System.out.println("No se pudo actualizar la cantidad de plato.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Obtener lista de bebidas desde la base de datos
    public List<Bebida> obtenerListaBebidas() {
        List<Bebida> listaBebidas = new ArrayList<>();
        String sql = "SELECT * FROM bebidas";
        
        try (Connection connection = ConexionBD.obtenerConexion();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int idBebida = resultSet.getInt("id_bebida");
                String nombre = resultSet.getString("nombre");
                int cantidad = resultSet.getInt("cantidad");
                double precio = resultSet.getDouble("precio");

                Bebida bebida = new Bebida(idBebida, nombre, cantidad, precio);
                listaBebidas.add(bebida);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return listaBebidas;
    }
    // Obtener lista de bebidas desde la base de datos
    public List<String> obtenerNombresBebidas() {
        List<String> listaNombres = new ArrayList<>();
        String sql = "SELECT nombre FROM bebidas";
        
        try (Connection connection = ConexionBD.obtenerConexion();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String nombre = resultSet.getString("nombre");
                listaNombres.add(nombre);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return listaNombres;
    }

    // Agregar una nueva bebida a la base de datos
    public void agregarBebida(Bebida bebida) {
        String sql = "INSERT INTO bebidas (nombre, cantidad, precio) VALUES (?, ?, ?)";
        
        try (Connection connection = ConexionBD.obtenerConexion();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, bebida.getNombre());
            preparedStatement.setInt(2, bebida.getCantidad());
            preparedStatement.setDouble(3, bebida.getPrecio());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Bebida agregada con éxito.");
            } else {
                System.out.println("No se pudo agregar la bebida.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Eliminar una bebida de la base de datos
    public void eliminarBebida(int idBebida) {
        String sql = "DELETE FROM bebidas WHERE id_bebida = ?";
        
        try (Connection connection = ConexionBD.obtenerConexion();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, idBebida);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Bebida eliminada con éxito.");
            } else {
                System.out.println("No se pudo eliminar la bebida.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updateBebida(Bebida bebida, int idBebida) {
        String sql = "UPDATE bebidas SET nombre = ?, cantidad = ?, precio = ? WHERE id_bebida = ?";

        try (Connection connection = ConexionBD.obtenerConexion();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            
            preparedStatement.setString(1, bebida.getNombre());
            preparedStatement.setInt(2, bebida.getCantidad());
            preparedStatement.setDouble(3, bebida.getPrecio());
            preparedStatement.setInt(4, idBebida);

            int filasAfectadas = preparedStatement.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Bebida actualizada correctamente.");
            } else {
                System.out.println("No se pudo actualizar la bebida.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Actualizar la cantidad de una bebida en la base de datos
    public void actualizarCantidadBebida(String nombreBebida, int cantidad) {
        String sql = "UPDATE bebidas SET cantidad = cantidad - ? WHERE nombre = ?";
        
        try (Connection connection = ConexionBD.obtenerConexion();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, cantidad);
            preparedStatement.setString(2, nombreBebida);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Cantidad de bebida actualizada con éxito.");
            } else {
                System.out.println("No se pudo actualizar la cantidad de bebida.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public DetallesPlato obtenerDetallesPlatoPorNombre(String nombre) {
        String sql = "SELECT * FROM platos WHERE nombre = ?";
        DetallesPlato detallesPlato = new DetallesPlato();

        try (Connection connection = ConexionBD.obtenerConexion();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, nombre);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                detallesPlato.setNombre(resultSet.getString("nombre"));
                detallesPlato.setPrecio(resultSet.getDouble("precio"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return detallesPlato;
    }

    public DetallesBebida obtenerDetallesBebidaPorNombre(String nombre) {
        String sql = "SELECT * FROM bebidas WHERE nombre = ?";
        DetallesBebida detallesBebida = new DetallesBebida();

        try (Connection connection = ConexionBD.obtenerConexion();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, nombre);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                detallesBebida.setNombre(resultSet.getString("nombre"));
                detallesBebida.setPrecio(resultSet.getDouble("precio"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return detallesBebida;
    }
    
    public List<DetallePedido> obtenerDetallesPedidosPendientes() {
        List<DetallePedido> detallesPedidos = new ArrayList<>();

        // Consulta para obtener detalles de platos pendientes
        String sqlPlatos = "SELECT " +
            "pl.nombre as 'descripcion', " +
            "(pl.precio - (pl.precio * 0.18)) as 'precio', " +
            "(pl.precio * 0.18) as 'impuesto', " +
            "pe.cantidad_plato as 'cantidad' " +
            "FROM platos pl " +
            "JOIN pedidos pe " +
            "ON pl.id_plato = pe.id_plato";

        // Consulta para obtener detalles de bebidas pendientes
        String sqlBebidas = "SELECT " +
            "b.nombre as 'descripcion', " +
            "(b.precio - (b.precio * 0.18)) as 'precio', " +
            "(b.precio * 0.18) as 'impuesto', " +
            "pe.cantidad_bebida as 'cantidad' " +
            "FROM bebidas b " +
            "JOIN pedidos pe " +
            "ON b.id_bebida = pe.id_bebida";

        try (Connection connection = ConexionBD.obtenerConexion();
             Statement statement = connection.createStatement()) {

            // Ejecutar la consulta de platos
            ResultSet resultSetPlatos = statement.executeQuery(sqlPlatos);
            while (resultSetPlatos.next()) {
                String descripcion = resultSetPlatos.getString("descripcion");
                double precio = resultSetPlatos.getDouble("precio");
                double impuesto = resultSetPlatos.getDouble("impuesto");
                int cantidad = resultSetPlatos.getInt("cantidad");

                DetallePedido detallePedido = new DetallePedido(descripcion, precio, impuesto, cantidad);
                detallesPedidos.add(detallePedido);
            }

            // Ejecutar la consulta de bebidas
            ResultSet resultSetBebidas = statement.executeQuery(sqlBebidas);
            while (resultSetBebidas.next()) {
                String descripcion = resultSetBebidas.getString("descripcion");
                double precio = resultSetBebidas.getDouble("precio");
                double impuesto = resultSetBebidas.getDouble("impuesto");
                int cantidad = resultSetBebidas.getInt("cantidad");

                DetallePedido detallePedido = new DetallePedido(descripcion, precio, impuesto, cantidad);
                detallesPedidos.add(detallePedido);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return detallesPedidos;
    }
}
