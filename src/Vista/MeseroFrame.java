/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;
import Modelos.UsuarioDAO;
import Modelos.MeseroDAO;

import Clases.Usuario;
import Clases.Mesero;
import java.util.List;
import singleton.DatosCompartidos;

public class MeseroFrame extends javax.swing.JFrame {
    
    private UsuarioDAO usuarioDAO;
    private MeseroDAO meseroDAO;

    public MeseroFrame() {
        initComponents();
        usuarioDAO = new UsuarioDAO(); // Instancia el DAO
        meseroDAO = new MeseroDAO();
        
        cargarCombo();

    }
    
    public void cargarCombo(){
        // Vaciar el JComboBox
        cbxNumMeseros.removeAllItems();
    
        // Llenar el combo con los números de mesero por estado
        List<Integer> listaMesas = meseroDAO.obtenerMesasByEstado("libre");
        for (Integer numero : listaMesas) {
            cbxNumMeseros.addItem(numero.toString());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtMail = new javax.swing.JTextField();
        txtClave = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtUsuario = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnManNumMesas = new javax.swing.JButton();
        cbxNumMeseros = new javax.swing.JComboBox<>();
        btnManNumMeseros = new javax.swing.JButton();
        btnSeleccionarMesas = new javax.swing.JButton();
        txtNoEditMesasSeleccionadas = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("REGISTRO DE MESEROS");

        jLabel2.setText("NOMBRES");

        jLabel3.setText("EMAIL");

        jLabel4.setText("TELEFONO");

        jLabel5.setText("NÚMERO DE MESERO");

        jLabel6.setText("MESAS ASIGNADAS");

        jLabel7.setText("USUARIO");

        jLabel8.setText("CONTRASEÑA");

        txtNombre.setText("aaa");

        txtMail.setText("aaaaa");

        txtClave.setText("123");

        txtTelefono.setText("123123");

        txtUsuario.setText("abc");

        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnManNumMesas.setText("MANTENIMIENTO MESAS");
        btnManNumMesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManNumMesasActionPerformed(evt);
            }
        });

        btnManNumMeseros.setText("MANTENIMIENTO MESEROS");
        btnManNumMeseros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManNumMeserosActionPerformed(evt);
            }
        });

        btnSeleccionarMesas.setText("SELECCIONAR");
        btnSeleccionarMesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarMesasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(186, 186, 186)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(21, 21, 21)
                                    .addComponent(jLabel4)
                                    .addGap(60, 60, 60))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel5))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(jLabel3))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addComponent(jLabel2)))
                                .addGap(62, 62, 62)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)
                                .addComponent(jLabel7)
                                .addGap(31, 31, 31)
                                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtMail, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(jLabel8)
                                .addGap(24, 24, 24)
                                .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(cbxNumMeseros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnManNumMeseros, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(txtNoEditMesasSeleccionadas)
                                .addGap(18, 18, 18)
                                .addComponent(btnSeleccionarMesas)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnManNumMesas, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel7)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(txtMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(cbxNumMeseros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnManNumMeseros, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(btnManNumMesas, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSeleccionarMesas)
                    .addComponent(txtNoEditMesasSeleccionadas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
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

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        guardarDatos();
        actualizarEstadoMesasSeleccionadasPorMesero();
        cargarCombo();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnManNumMeserosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManNumMeserosActionPerformed
        ManMeserosFrame manNumMeserosFrame = new ManMeserosFrame();
        this.dispose(); // Cierra el JFrame actual
        manNumMeserosFrame.setVisible(true);
    }//GEN-LAST:event_btnManNumMeserosActionPerformed

    private void btnManNumMesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManNumMesasActionPerformed
        ManMesasFrame manNumMesasFrame = new ManMesasFrame();
        this.dispose(); // Cierra el JFrame actual
        manNumMesasFrame.setVisible(true);
    }//GEN-LAST:event_btnManNumMesasActionPerformed

    private void btnSeleccionarMesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarMesasActionPerformed
        SeleccionMesasFrame seleccionMesasFrame = new SeleccionMesasFrame(this);
        this.dispose(); // Cierra el JFrame actual
        seleccionMesasFrame.setVisible(true);
    }//GEN-LAST:event_btnSeleccionarMesasActionPerformed

    public void actualizarTextoMesasSeleccionadas(String texto) {
        txtNoEditMesasSeleccionadas.setText(texto);
    }
    
    public void guardarDatos(){
        String nombre = txtNombre.getText();
        String mail = txtMail.getText();
        String clave = txtClave.getText();
        int telefono = Integer.parseInt(txtTelefono.getText());
        String usuario = txtUsuario.getText();
        int numMeseros = Integer.parseInt(cbxNumMeseros.getSelectedItem().toString());
        String mesasSeleccionadas = txtNoEditMesasSeleccionadas.getText();
        int idaux = meseroDAO.obtenerNuevoIdMesero(); // Debes implementar este método

        // Crear un objeto Mesero con los datos
        Mesero mesero = new Mesero();
        mesero.setNombre(nombre);
        mesero.setEmail(mail);
        mesero.setTelefono(telefono);
        mesero.setNumero_mesero(numMeseros);
        mesero.setNumero_mesa(mesasSeleccionadas);
        mesero.setId_mesero(idaux);

        // Crear un objeto Usuario con los datos
        Usuario usuarioObj = new Usuario();
        usuarioObj.setUsername(usuario);
        usuarioObj.setPassword(clave);
        usuarioObj.setIdaux(idaux);

        // Guardar el mesero y el usuario usando los DAOs
        meseroDAO.saveMesero(mesero);
        usuarioDAO.saveUsuarioMesero(usuarioObj);

        meseroDAO.actualizarEstadoMesero(numMeseros);
    }
    
    public void actualizarEstadoMesasSeleccionadasPorMesero(){
        String mesasSeleccionadas = txtNoEditMesasSeleccionadas.getText();
        String[] mesasArray = mesasSeleccionadas.split(",");

        for (String mesa : mesasArray) {
            int numeroMesa = Integer.parseInt(mesa);
            meseroDAO.actualizarEstadoEnAuxNumMesa(String.valueOf(numeroMesa));
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
            java.util.logging.Logger.getLogger(MeseroFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MeseroFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MeseroFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MeseroFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MeseroFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnManNumMesas;
    private javax.swing.JButton btnManNumMeseros;
    private javax.swing.JButton btnSeleccionarMesas;
    private javax.swing.JComboBox<String> cbxNumMeseros;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtClave;
    private javax.swing.JTextField txtMail;
    private javax.swing.JTextField txtNoEditMesasSeleccionadas;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
