/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import Clases.Usuario;
import Controlador.ConexionBD;
import java.sql.*;
import javax.swing.JOptionPane;

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
    
    public void saveUsuarioAdmin(Usuario usuario) {
        String sql = "INSERT INTO usuarios (username, password, id_administrador, id_mesero) VALUES (?, ?, ?, -1)";
        
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
    
    public void saveUsuarioMesero(Usuario usuario) {
        String sql = "INSERT INTO usuarios (username, password, id_administrador, id_mesero) VALUES (?, ?, -1, ?)";
        
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
    
    public int obtenerIdUsuario(String username, String contraseña) {
        int idUsuario = -1;
        String sql = "SELECT id_usuario FROM usuarios WHERE username = ? AND password = ?";

        try (Connection connection = ConexionBD.obtenerConexion();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, contraseña);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                idUsuario = resultSet.getInt("id_usuario");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return idUsuario;
    }
    
    public int obtenerIdAdministrador(int idUsuario) {
        int idAdministrador = -1;
        String sql = "SELECT id_administrador FROM usuarios WHERE id_usuario = ?";

        try (Connection connection = ConexionBD.obtenerConexion();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, idUsuario);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                idAdministrador = resultSet.getInt("id_administrador");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return idAdministrador;
    }
    
    public int obtenerIdMesero(int idUsuario) {
        int idMesero = -1;
        String sql = "SELECT id_mesero FROM usuarios WHERE id_usuario = ?";

        try (Connection connection = ConexionBD.obtenerConexion();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, idUsuario);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                idMesero = resultSet.getInt("id_mesero");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return idMesero;
    }
    
    public String obtenerNombreUsuarioPorTipo(int idUsuario) {
        String nombreUsuario = null;

        int idAdministrador = obtenerIdAdministrador(idUsuario);
        int idMesero = obtenerIdMesero(idUsuario);

        if (idAdministrador != -1) {
            // El usuario es administrador
            String sql = "SELECT nombre FROM administradores WHERE id_administrador = ?";

            try (Connection connection = ConexionBD.obtenerConexion();
                 PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

                preparedStatement.setInt(1, idAdministrador);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    nombreUsuario = resultSet.getString("nombre");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (idMesero != -1) {
            // El usuario es mesero
            String sql = "SELECT nombre FROM meseros WHERE id_mesero = ?";

            try (Connection connection = ConexionBD.obtenerConexion();
                 PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

                preparedStatement.setInt(1, idMesero);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    nombreUsuario = resultSet.getString("nombre");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return nombreUsuario;
    }

}
