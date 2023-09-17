/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import Clases.Mesero;
import Controlador.ConexionBD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

// En la clase MeseroDAO

public class MeseroDAO {

    // Otros métodos CRUD según sea necesario

    public void saveMesero(Mesero mesero) {
        String sql = "INSERT INTO meseros (nombre, email, telefono, numero_mesero, numero_mesa) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection connection = ConexionBD.obtenerConexion();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            
            preparedStatement.setString(1, mesero.getNombre());
            preparedStatement.setString(2, mesero.getEmail());
            preparedStatement.setInt(3, mesero.getTelefono());
            preparedStatement.setInt(4, mesero.getNumero_mesero());
            preparedStatement.setString(5, mesero.getNumero_mesa());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Mesero guardado con éxito.");
            } else {
                System.out.println("No se pudo guardar el mesero.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<Integer> obtenerNumerosDeMesero() {
        String sql = "SELECT numero_mesero FROM aux_num_mesero";

        List<Integer> numerosMesero = new ArrayList<>();

        try (Connection connection = ConexionBD.obtenerConexion();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int numeroMesero = resultSet.getInt("numero_mesero");
                numerosMesero.add(numeroMesero);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return numerosMesero;
    }
    
    public List<Integer> getMeserosByEstado(String estado) {
        String sql = "SELECT numero_mesero FROM aux_num_mesero WHERE estado = ?";

        List<Integer> numerosMesero = new ArrayList<>();

        try (Connection connection = ConexionBD.obtenerConexion();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, estado);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int numeroMesero = resultSet.getInt("numero_mesero");
                numerosMesero.add(numeroMesero);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return numerosMesero;
    }
    
    public List<Integer> getMesasByEstado(String estado) {
        String sql = "SELECT numero_mesa FROM aux_num_mesa WHERE estado = ?";
        List<Integer> listaMesas = new ArrayList<>();

        try (Connection connection = ConexionBD.obtenerConexion();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, estado);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int numeroMesero = resultSet.getInt("numero_mesa");
                listaMesas.add(numeroMesero);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaMesas;
    }

    
    public int obtenerNuevoIdMesero() {
        String sql = "SELECT MAX(id_mesero) FROM meseros"; // Asegúrate de tener una tabla de IDs
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
    
    
    public void addAumentarNumMeseros() {
        String sql = "INSERT INTO aux_num_mesero (numero_mesero, estado) VALUES (?, 'libre')";
        int nuevoNumeroMesero = obtenerUltimoNumeroMesero() + 1;

        try (Connection connection = ConexionBD.obtenerConexion();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, nuevoNumeroMesero);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Número de mesero agregado con éxito.");
            } else {
                System.out.println("No se pudo agregar el número de mesero.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addDisminuirNumMeseros() {
        String sql = "DELETE FROM aux_num_mesero WHERE numero_mesero = ?";
        int ultimoNumeroMesero = obtenerUltimoNumeroMesero();

        if (ultimoNumeroMesero <= 1) {
            System.out.println("No se pueden eliminar más números de mesero.");
            return;
        }

        try (Connection connection = ConexionBD.obtenerConexion();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, ultimoNumeroMesero);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Número de mesero eliminado con éxito.");
            } else {
                System.out.println("No se pudo eliminar el número de mesero.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int obtenerUltimoNumeroMesero() {
        String sql = "SELECT MAX(numero_mesero) FROM aux_num_mesero";

        try (Connection connection = ConexionBD.obtenerConexion();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; // Manejo de error
    }

    
    public void actualizarEstadoMesero(int numeroMesero) {
        String sqlActualizarEstado = "UPDATE aux_num_mesero SET estado = 'ocupado' WHERE numero_mesero = ?";

        try (Connection connection = ConexionBD.obtenerConexion();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlActualizarEstado)) {

            preparedStatement.setInt(1, numeroMesero);
            int filasAfectadas = preparedStatement.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Estado de número de mesero actualizado a 'ocupado'.");
            } else {
                System.out.println("No se pudo actualizar el estado del número de mesero.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<Integer> obtenerNumerosDeMesa() {
        String sql = "SELECT numero_mesa FROM aux_num_mesa";

        List<Integer> numerosMesa = new ArrayList<>();

        try (Connection connection = ConexionBD.obtenerConexion();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int numeroMesa = resultSet.getInt("numero_mesa");
                numerosMesa.add(numeroMesa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return numerosMesa;
    }
    
    public List<Integer> obtenerMesasByEstado(String estado) {
        String sql = "SELECT numero_mesa FROM aux_num_mesa WHERE estado = ?";
        List<Integer> numerosMesa = new ArrayList<>();

        try (Connection connection = ConexionBD.obtenerConexion();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, estado);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int numeroMesa = resultSet.getInt("numero_mesa");
                numerosMesa.add(numeroMesa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return numerosMesa;
    }

    
    
    public void addAumentarNumMesas() {
        String sql = "INSERT INTO aux_num_mesa (numero_mesa, estado) VALUES (?, 'libre')";
        int nuevoNumeroMesa = obtenerUltimoNumeroMesa() + 1;

        try (Connection connection = ConexionBD.obtenerConexion();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, nuevoNumeroMesa);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Número de mesa agregado con éxito.");
            } else {
                System.out.println("No se pudo agregar el número de mesa.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addDisminuirNumMesas() {
        String sql = "DELETE FROM aux_num_mesa WHERE numero_mesa = ?";
        int ultimoNumeroMesa = obtenerUltimoNumeroMesa();

        if (ultimoNumeroMesa <= 1) {
            System.out.println("No se pueden eliminar más números de mesa.");
            return;
        }

        try (Connection connection = ConexionBD.obtenerConexion();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, ultimoNumeroMesa);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Número de mesa eliminado con éxito.");
            } else {
                System.out.println("No se pudo eliminar el número de mesa.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int obtenerUltimoNumeroMesa() {
        String sql = "SELECT MAX(numero_mesa) FROM aux_num_mesa";

        try (Connection connection = ConexionBD.obtenerConexion();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; // Manejo de error
    }
    
    public void actualizarEstadoEnAuxNumMesa(String numerosDeMesa) {
        String[] numeros = numerosDeMesa.split(",");

        String sql = "UPDATE aux_num_mesa SET estado = 'ocupado' WHERE numero_mesa = ?";

        try (Connection connection = ConexionBD.obtenerConexion();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            for (String numero : numeros) {
                int numMesa = Integer.parseInt(numero);
                preparedStatement.setInt(1, numMesa);

                int filasAfectadas = preparedStatement.executeUpdate();

                if (filasAfectadas > 0) {
                    System.out.println("Estado de número de mesa actualizado a 'ocupado'.");
                } else {
                    System.out.println("No se pudo actualizar el estado del número de mesero.");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<Integer> obtenerNumerosMesaPorMesero(String nombreMesero) {
        List<Integer> numerosMesa = new ArrayList<>();

        String sql = "SELECT a.numero_mesa " +
                     "FROM aux_num_mesa a " +
                     "JOIN meseros m ON m.numero_mesa = a.numero_mesa " +
                     "WHERE m.nombre = ? AND a.estado = 'ocupado'";

        try (Connection connection = ConexionBD.obtenerConexion();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, nombreMesero);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String numerosMesaStr = resultSet.getString("numero_mesa");

                if (numerosMesaStr.contains(",")) {
                    String[] numerosMesaArray = numerosMesaStr.split(",");
                    for (String numero : numerosMesaArray) {
                        numerosMesa.add(Integer.parseInt(numero.trim()));
                    }
                } else {
                    numerosMesa.add(Integer.parseInt(numerosMesaStr.trim()));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return numerosMesa;
    }


}

