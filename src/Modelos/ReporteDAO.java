/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RefineryUtilities;
import Controlador.ConexionBD;
import java.sql.*;


public class ReporteDAO {
    public CategoryDataset obtenerDatasetVentasPorMesero() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        String sql = "SELECT m.nombre as mesero, COUNT(*) as total_ventas \n" +
"                     FROM ventas v \n" +
"                     JOIN meseros m ON v.atendido_por = m.nombre \n" +
"                     GROUP BY m.nombre";

        try (Connection connection = ConexionBD.obtenerConexion();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String nombreMesero = resultSet.getString("mesero");
                int totalVentas = resultSet.getInt("total_ventas");

                dataset.addValue(totalVentas, "Ventas", nombreMesero);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dataset;
    }

    public CategoryDataset obtenerDatasetVentasPorMes() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        String sql = "SELECT EXTRACT(MONTH FROM STR_TO_DATE(fecha, '%d/%m/%Y')) AS mes, \n" +
                     "SUM(total) AS total_ventas \n" +
                     "FROM ventas \n" +
                     "GROUP BY EXTRACT(MONTH FROM STR_TO_DATE(fecha, '%d/%m/%Y'))";

        try (Connection connection = ConexionBD.obtenerConexion();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int mes = resultSet.getInt("mes");
                int totalVentas = resultSet.getInt("total_ventas");
                dataset.addValue(totalVentas, "Ventas", obtenerNombreMes(mes));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dataset;
    }

    private String obtenerNombreMes(int mes) {
        switch (mes) {
            case 1:
                return "Enero";
            case 2:
                return "Febrero";
            case 3:
                return "Marzo";
            case 4:
                return "Abril";
            case 5:
                return "Mayo";
            case 6:
                return "Junio";
            case 7:
                return "Julio";
            case 8:
                return "Agosto";
            case 9:
                return "Septiembre";
            case 10:
                return "Octubre";
            case 11:
                return "Noviembre";
            case 12:
                return "Diciembre";
            default:
                return "";
        }
    }
    
}
