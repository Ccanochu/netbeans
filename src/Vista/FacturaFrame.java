/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;
import Clases.Cliente;
import Clases.DetallePedido;
import Clases.Venta;
import Clases.DetallesVenta;

import Modelos.ClienteDAO;
import Modelos.MeseroDAO;
import Modelos.UsuarioDAO;
import Modelos.MenuDAO;
import Modelos.VentasDAO;
import Modelos.DetallesVentaDAO;
import Modelos.PedidoDAO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import singleton.Sesion;

public class FacturaFrame extends javax.swing.JFrame {

    private ClienteDAO clienteDAO;
    private MeseroDAO meseroDAO;
    private UsuarioDAO usuarioDAO;
    private MenuDAO menuDAO;
    private VentasDAO ventasDAO;
    private PedidoDAO pedidoDAO;
    private DetallesVentaDAO detalleVentaDAO;
    
    Sesion sesion;
    
    public FacturaFrame() {
        initComponents();
        setLocationRelativeTo(null);
        clienteDAO = new ClienteDAO();
        meseroDAO = new MeseroDAO();
        usuarioDAO = new UsuarioDAO();
        menuDAO = new MenuDAO();
        ventasDAO = new VentasDAO();
        detalleVentaDAO = new DetallesVentaDAO();
        pedidoDAO = new PedidoDAO();
        
        cargarFecha();
        
        
        // Obtener el nombre del usuario desde la sesión
        sesion = Sesion.getInstance();
        getUser();
        cargarMesas(txtAtendidoPor.getText());
        cargarDatosTabla();
    }
    
    public void guardarCliente(){
        String nombre = txtNombreCliente.getText();
        int dni = Integer.parseInt(txtDniCliente.getText());
        int telefono = Integer.parseInt(txtTelefonoCliente.getText());
        
        Cliente clienteObj = new Cliente();
        clienteObj.setNombre(nombre);
        clienteObj.setDni(dni);
        clienteObj.setTelefono(telefono);
        
        clienteDAO.saveCliente(clienteObj);
        
        cargarFecha();
    }
    
    public void cargarMesas(String nombreMesero){
        // Vaciar el JComboBox
        cbxMesas.removeAllItems();

        // Llenar el combo con los números de mesa por estado "libre" para el mesero
        List<Integer> listaMesas = meseroDAO.obtenerNumerosMesaPorMesero(nombreMesero);
        for (Integer numero : listaMesas) {
            cbxMesas.addItem(numero.toString());
        }
    }

    
    public void cargarFecha(){
        // Obtener la fecha actual
        LocalDate fechaActual = LocalDate.now();

        // Convertir la fecha al formato deseado (por ejemplo, "dd/MM/yyyy")
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaFormateada = fechaActual.format(formatter);

        // Establecer el texto en el JTextField
        txtFechaActual.setText(fechaFormateada);
    }
    
    public void getUser(){
        String nombreUsuario = sesion.getNombreUsuario();
        String contraUsuario = sesion.getContrasena();
        
        int idUsuario = usuarioDAO.obtenerIdUsuario(nombreUsuario, contraUsuario);
        String nombreUsuarioReal = usuarioDAO.obtenerNombreUsuarioPorTipo(idUsuario);
        
        txtAtendidoPor.setText(nombreUsuarioReal);
    }

    
    private void cargarDatosTabla() {
        DefaultTableModel modelo = (DefaultTableModel) tbDetalles.getModel();
        modelo.setRowCount(0); // Limpiar la tabla

        List<DetallePedido> detallesPedidos = menuDAO.obtenerDetallesPedidosPendientes();
        double total = 0.0; // Variable para almacenar el total

        for (DetallePedido detalle : detallesPedidos) {
            Object[] fila = {
                detalle.getDescripcion(),
                detalle.getPrecio(),
                detalle.getImpuesto(),
                detalle.getCantidad()
            };
            modelo.addRow(fila);
            
            total += detalle.getPrecio() + detalle.getImpuesto(); // Sumar precio e impuesto al total
        }
        // Establecer el total en el campo de texto
        txtMontoTotal.setText(String.valueOf(total));
    }
    
    public void guardarVenta(){
        // Obtener el ID del cliente
        int idCliente = clienteDAO.obtenerUltimoIdCliente(); 

        // Obtener el número de mesa
        int numeroMesa = Integer.parseInt(cbxMesas.getSelectedItem().toString()); 

        // Obtener el nombre del usuario que atendió
        String atendidoPor = txtAtendidoPor.getText(); 

        // Obtener la fecha actual
        String fecha = txtFechaActual.getText(); 

        // Obtener el total
        double total = Double.parseDouble(txtMontoTotal.getText()); 

        // Crear un objeto Venta
        Venta ventaObj = new Venta();
        ventaObj.setIdCliente(idCliente);
        ventaObj.setNumeroMesa(numeroMesa);
        ventaObj.setAtendidoPor(atendidoPor);
        ventaObj.setFecha(fecha);
        ventaObj.setTotal(total);

        // Guardar la venta y obtener su ID
        ventasDAO.saveVenta(ventaObj); 
        
    }
    
    public void guardarDetalleVenta(){
        int idVenta = ventasDAO.obtenerUltimoIdVenta();
        
        // Obtener los detalles de la venta
        DefaultTableModel model = (DefaultTableModel) tbDetalles.getModel();
        int filas = model.getRowCount();

        for (int i = 0; i < filas; i++) {
            String descripcion = (String) model.getValueAt(i, 0);
            double precio = (double) model.getValueAt(i, 1);
            double impuesto = (double) model.getValueAt(i, 2);
            int cantidad = (int) model.getValueAt(i, 3);

            // Crear un objeto DetallesVenta
            DetallesVenta detallesVenta = new DetallesVenta();
            detallesVenta.setIdVenta(idVenta);
            detallesVenta.setDescripcion(descripcion);
            detallesVenta.setPrecio(precio);
            detallesVenta.setImpuesto(impuesto);
            detallesVenta.setCantidad(cantidad);

            // Guardar los detalles de la venta
            detalleVentaDAO.saveDetallesVenta(detallesVenta);
        }
    }
    
    public void updateEstadoPedidos(){
        pedidoDAO.actualizarEstadoPedidos("pagado");
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbxMesas = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtAtendidoPor = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtFechaActual = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDetalles = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        btnConfirmar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtMontoTotal = new javax.swing.JTextField();
        btnAtras = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txtNombreCliente = new javax.swing.JTextField();
        txtDniCliente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTelefonoCliente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("FACTURA");

        jLabel5.setText("n° mesa");

        jLabel6.setText("atendido por");

        txtAtendidoPor.setEnabled(false);

        jLabel7.setText("fecha");

        txtFechaActual.setEnabled(false);

        tbDetalles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "DESCRIPCION", "CANTIDAD", "PRECIO", "IMPUESTO"
            }
        ));
        jScrollPane1.setViewportView(tbDetalles);

        jLabel8.setText("IGV");

        jTextField1.setText("18%");
        jTextField1.setEnabled(false);

        btnConfirmar.setText("CONFIRMAR");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        jLabel9.setText("monto total");

        txtMontoTotal.setEnabled(false);

        btnAtras.setText("ATRAS");
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("DATOS DE CLIENTE"));

        jLabel4.setText("teléfono");

        jLabel2.setText("nombre del cliente");

        jLabel3.setText("dni");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(46, 46, 46)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNombreCliente)
                    .addComponent(txtDniCliente)
                    .addComponent(txtTelefonoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtDniCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtTelefonoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(286, 286, 286))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMontoTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                            .addComponent(jTextField1)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 136, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnAtras)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbxMesas, 0, 145, Short.MAX_VALUE)
                            .addComponent(txtAtendidoPor)
                            .addComponent(txtFechaActual))))
                .addContainerGap(105, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cbxMesas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtAtendidoPor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(txtFechaActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtMontoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addComponent(btnAtras)
                .addGap(13, 13, 13))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        
        guardarCliente();
        guardarVenta();
        guardarDetalleVenta();
        updateEstadoPedidos();
        cargarDatosTabla();
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        MenuPrincipalFrame menuPrincipalFrame = new MenuPrincipalFrame();
        this.dispose(); // Cierra el JFrame actual
        menuPrincipalFrame.setVisible(true);
    }//GEN-LAST:event_btnAtrasActionPerformed

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FacturaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FacturaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FacturaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FacturaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FacturaFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JComboBox<String> cbxMesas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tbDetalles;
    private javax.swing.JTextField txtAtendidoPor;
    private javax.swing.JTextField txtDniCliente;
    private javax.swing.JTextField txtFechaActual;
    private javax.swing.JTextField txtMontoTotal;
    private javax.swing.JTextField txtNombreCliente;
    private javax.swing.JTextField txtTelefonoCliente;
    // End of variables declaration//GEN-END:variables
}
