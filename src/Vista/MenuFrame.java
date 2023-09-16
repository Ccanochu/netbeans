/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Clases.Bebida;
import Clases.DetallesBebida;
import Clases.DetallesPlato;
import Clases.GestionPedidos;
import Clases.Orden;

import Clases.Plato;
import Modelos.MenuDAO;
import Modelos.PedidoDAO;
import java.util.List;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class MenuFrame extends javax.swing.JFrame {

    private MenuDAO menuDAO;
    private PedidoDAO pedidoDAO;
    private GestionPedidos gestionPedidos;
    
    public MenuFrame() {
        initComponents();
        menuDAO = new MenuDAO();
        pedidoDAO = new PedidoDAO();
        gestionPedidos = new GestionPedidos();
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnPlatos = new javax.swing.JButton();
        btnBebidas = new javax.swing.JButton();
        cbxPlato = new javax.swing.JComboBox<>();
        cbxBebida = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnConfirmarPedido = new javax.swing.JButton();
        txtCantidadPlato = new javax.swing.JTextField();
        txtCantidadBebida = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnActivarCbxBebidas = new javax.swing.JButton();
        btnActivarCbxPlatos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("MENU");

        btnPlatos.setText("MANTENIMIENTO PLATOS");
        btnPlatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlatosActionPerformed(evt);
            }
        });

        btnBebidas.setText("MANTENIMIENTO BEBIDAS");
        btnBebidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBebidasActionPerformed(evt);
            }
        });

        jLabel4.setText("bebida");

        jLabel5.setText("plato");

        btnConfirmarPedido.setText("CONFIRMAR ORDEN");
        btnConfirmarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarPedidoActionPerformed(evt);
            }
        });

        jLabel2.setText("cantidad");

        jLabel3.setText("cantidad");

        btnActivarCbxBebidas.setText("ACTIVAR");
        btnActivarCbxBebidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActivarCbxBebidasActionPerformed(evt);
            }
        });

        btnActivarCbxPlatos.setText("ACTIVAR");
        btnActivarCbxPlatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActivarCbxPlatosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnPlatos, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbxPlato, 0, 108, Short.MAX_VALUE)
                                    .addComponent(txtCantidadPlato)))
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                        .addComponent(btnActivarCbxPlatos)
                        .addGap(33, 33, 33)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxBebida, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCantidadBebida, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnBebidas, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE))
                .addGap(39, 39, 39)
                .addComponent(btnActivarCbxBebidas)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnConfirmarPedido)
                        .addGap(253, 253, 253))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(327, 327, 327))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(61, 61, 61)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPlatos)
                    .addComponent(btnBebidas))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxPlato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxBebida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(btnActivarCbxBebidas)
                    .addComponent(btnActivarCbxPlatos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCantidadPlato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtCantidadBebida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(65, 65, 65)
                .addComponent(btnConfirmarPedido)
                .addGap(43, 43, 43))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPlatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlatosActionPerformed
        ManPlatosFrame manPlatosFrame = new ManPlatosFrame();
        this.dispose(); // Cierra el JFrame actual
        manPlatosFrame.setVisible(true);
    }//GEN-LAST:event_btnPlatosActionPerformed

    private void btnBebidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBebidasActionPerformed
        ManBebidasFrame manBebidasFrame = new ManBebidasFrame();
        this.dispose(); // Cierra el JFrame actual
        manBebidasFrame.setVisible(true);
    }//GEN-LAST:event_btnBebidasActionPerformed

    private void btnConfirmarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarPedidoActionPerformed
        String nombrePlatoSeleccionado = (String) cbxPlato.getSelectedItem();
        String nombreBebidaSeleccionada = (String) cbxBebida.getSelectedItem();

        DetallesPlato detallesPlato = menuDAO.obtenerDetallesPlatoPorNombre(nombrePlatoSeleccionado);
        DetallesBebida detallesBebida = menuDAO.obtenerDetallesBebidaPorNombre(nombreBebidaSeleccionada);

        // Obtener la cantidad de plato ingresada por el usuario
        int cantidadPlato = 0;
        String textoCantidadPlato = txtCantidadPlato.getText();
        if (!textoCantidadPlato.isEmpty()) {
            cantidadPlato = Integer.parseInt(textoCantidadPlato);
        }

        // Obtener la cantidad de bebida ingresada por el usuario
        int cantidadBebida = 0; // Valor predeterminado si el campo está vacío
        String textoCantidadBebida = txtCantidadBebida.getText();
        if (!textoCantidadBebida.isEmpty()) {
            cantidadBebida = Integer.parseInt(textoCantidadBebida);
        }

        Orden nuevaOrden = new Orden(detallesPlato, detallesBebida);

        double total = detallesPlato.getPrecio()*cantidadPlato + detallesBebida.getPrecio()*cantidadBebida;

        // Agregar el pedido utilizando la instancia de pedidoDAO
        pedidoDAO.agregarPedido(nuevaOrden, total, cantidadPlato, cantidadBebida);

        // Actualizar la cantidad en la base de datos
        if (detallesPlato != null) {
            menuDAO.actualizarCantidadPlato(detallesPlato.getNombre(), cantidadPlato);
        }

        if (detallesBebida != null) {
            menuDAO.actualizarCantidadBebida(detallesBebida.getNombre(), cantidadBebida);
        }
    }//GEN-LAST:event_btnConfirmarPedidoActionPerformed

    private void btnActivarCbxPlatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActivarCbxPlatosActionPerformed
        cargarComboPlatos();
    }//GEN-LAST:event_btnActivarCbxPlatosActionPerformed

    private void btnActivarCbxBebidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActivarCbxBebidasActionPerformed
        cargarComboBebidas();
    }//GEN-LAST:event_btnActivarCbxBebidasActionPerformed

    public void cargarComboPlatos(){
        // Vaciar el JComboBox de platos
        cbxPlato.removeAllItems();

        // Llenar el combo con los platos
        List<String> nombresPlatos = menuDAO.obtenerNombresPlatos();
        for (String nombrePlato : nombresPlatos) {
            cbxPlato.addItem(nombrePlato);
        }
    }
    
    public void cargarComboBebidas(){
        // Vaciar el JComboBox de platos
        cbxBebida.removeAllItems();

        // Llenar el combo con las bebidas
        List<String> nombresBebidas = menuDAO.obtenerNombresBebidas();
        for (String nombreBebida : nombresBebidas) {
            cbxBebida.addItem(nombreBebida);
        }
    }
    
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
            java.util.logging.Logger.getLogger(MenuFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActivarCbxBebidas;
    private javax.swing.JButton btnActivarCbxPlatos;
    private javax.swing.JButton btnBebidas;
    private javax.swing.JButton btnConfirmarPedido;
    private javax.swing.JButton btnPlatos;
    private javax.swing.JComboBox<String> cbxBebida;
    private javax.swing.JComboBox<String> cbxPlato;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtCantidadBebida;
    private javax.swing.JTextField txtCantidadPlato;
    // End of variables declaration//GEN-END:variables
}
