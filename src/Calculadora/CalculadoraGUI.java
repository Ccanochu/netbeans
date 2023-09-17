package Calculadora;

import Vista.MenuPrincipalFrame;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public final class CalculadoraGUI extends JFrame {
    
    private static List<CalculadoraGUI> ventanasAbiertas = new ArrayList<>();

    String expresion = "";
    
    
    public static void main(String[] args) {
        // Aquí puedes inicializar tu GUI u otros componentes si es necesario
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CalculadoraGUI().setVisible(true);
            }
        });
    }
    
    public CalculadoraGUI() {
        initComponents();
        setLocationRelativeTo(null);
        
    }
    
    private void btnNumeroActionPerformed(java.awt.event.ActionEvent evt) {
        JButton botonPresionado = (JButton) evt.getSource();
        String textoBoton = botonPresionado.getText();

        expresion += textoBoton;
        inputPantalla.setText(expresion);
    }
    
    private void btnOperadorActionPerformed(java.awt.event.ActionEvent evt) {
        JButton botonPresionado = (JButton) evt.getSource();
        String textoBoton = botonPresionado.getText();

        expresion += textoBoton;
        inputPantalla.setText(expresion);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnRaiz = new javax.swing.JButton();
        btnCuadrado = new javax.swing.JButton();
        btnCubico = new javax.swing.JButton();
        btnPorcentaje = new javax.swing.JButton();
        btnCE = new javax.swing.JButton();
        btnC = new javax.swing.JButton();
        btnBorrarDigito = new javax.swing.JButton();
        btnDivision = new javax.swing.JButton();
        btnPad7 = new javax.swing.JButton();
        btnPad8 = new javax.swing.JButton();
        btnPad9 = new javax.swing.JButton();
        btnMultiplicacion = new javax.swing.JButton();
        btnPad4 = new javax.swing.JButton();
        btnPad5 = new javax.swing.JButton();
        btnPad6 = new javax.swing.JButton();
        btnSuma = new javax.swing.JButton();
        btnPad1 = new javax.swing.JButton();
        btnPad2 = new javax.swing.JButton();
        btnPad3 = new javax.swing.JButton();
        btnResta = new javax.swing.JButton();
        btnMasIgual = new javax.swing.JButton();
        btnPad0 = new javax.swing.JButton();
        btnPunto = new javax.swing.JButton();
        btnIgual = new javax.swing.JButton();
        resultadoPantalla = new javax.swing.JLabel();
        inputPantalla = new javax.swing.JLabel();
        btnAtras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jPanel2.setBackground(new java.awt.Color(151, 158, 170));

        jPanel1.setBackground(new java.awt.Color(151, 158, 170));
        jPanel1.setLayout(new java.awt.GridLayout(6, 4, 3, 3));

        btnRaiz.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnRaiz.setText("√");
        btnRaiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRaizActionPerformed(evt);
            }
        });
        jPanel1.add(btnRaiz);

        btnCuadrado.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnCuadrado.setText("x²");
        btnCuadrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCuadradoActionPerformed(evt);
            }
        });
        jPanel1.add(btnCuadrado);

        btnCubico.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnCubico.setText("x³");
        btnCubico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCubicoActionPerformed(evt);
            }
        });
        jPanel1.add(btnCubico);

        btnPorcentaje.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnPorcentaje.setText("%");
        btnPorcentaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPorcentajeActionPerformed(evt);
            }
        });
        jPanel1.add(btnPorcentaje);

        btnCE.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnCE.setText("CE");
        btnCE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCEActionPerformed(evt);
            }
        });
        jPanel1.add(btnCE);

        btnC.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnC.setText("C");
        btnC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCActionPerformed(evt);
            }
        });
        jPanel1.add(btnC);

        btnBorrarDigito.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnBorrarDigito.setText("◄");
        jPanel1.add(btnBorrarDigito);

        btnDivision.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnDivision.setText("/");
        btnDivision.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDivisionActionPerformed(evt);
            }
        });
        jPanel1.add(btnDivision);

        btnPad7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnPad7.setText("7");
        btnPad7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPad7ActionPerformed(evt);
            }
        });
        jPanel1.add(btnPad7);

        btnPad8.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnPad8.setText("8");
        btnPad8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPad8ActionPerformed(evt);
            }
        });
        jPanel1.add(btnPad8);

        btnPad9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnPad9.setText("9");
        btnPad9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPad9ActionPerformed(evt);
            }
        });
        jPanel1.add(btnPad9);

        btnMultiplicacion.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnMultiplicacion.setText("*");
        btnMultiplicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMultiplicacionActionPerformed(evt);
            }
        });
        jPanel1.add(btnMultiplicacion);

        btnPad4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnPad4.setText("4");
        btnPad4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPad4ActionPerformed(evt);
            }
        });
        jPanel1.add(btnPad4);

        btnPad5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnPad5.setText("5");
        btnPad5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPad5ActionPerformed(evt);
            }
        });
        jPanel1.add(btnPad5);

        btnPad6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnPad6.setText("6");
        btnPad6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPad6ActionPerformed(evt);
            }
        });
        jPanel1.add(btnPad6);

        btnSuma.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnSuma.setText("+");
        btnSuma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSumaActionPerformed(evt);
            }
        });
        jPanel1.add(btnSuma);

        btnPad1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnPad1.setText("1");
        btnPad1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPad1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnPad1);

        btnPad2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnPad2.setText("2");
        btnPad2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPad2ActionPerformed(evt);
            }
        });
        jPanel1.add(btnPad2);

        btnPad3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnPad3.setText("3");
        btnPad3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPad3ActionPerformed(evt);
            }
        });
        jPanel1.add(btnPad3);

        btnResta.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnResta.setText("-");
        btnResta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestaActionPerformed(evt);
            }
        });
        jPanel1.add(btnResta);

        btnMasIgual.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnMasIgual.setText("±");
        jPanel1.add(btnMasIgual);

        btnPad0.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnPad0.setText("0");
        btnPad0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPad0ActionPerformed(evt);
            }
        });
        jPanel1.add(btnPad0);

        btnPunto.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnPunto.setText(".");
        btnPunto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPuntoActionPerformed(evt);
            }
        });
        jPanel1.add(btnPunto);

        btnIgual.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnIgual.setText("=");
        btnIgual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIgualActionPerformed(evt);
            }
        });
        jPanel1.add(btnIgual);

        resultadoPantalla.setFont(new java.awt.Font("Tahoma", 0, 44)); // NOI18N
        resultadoPantalla.setForeground(new java.awt.Color(255, 255, 255));
        resultadoPantalla.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        resultadoPantalla.setText("0");

        inputPantalla.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        inputPantalla.setForeground(new java.awt.Color(229, 229, 229));
        inputPantalla.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        inputPantalla.setText("0");

        btnAtras.setText("ATRAS");
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inputPantalla, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(resultadoPantalla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnAtras)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btnAtras)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputPantalla, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(resultadoPantalla, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        
    }//GEN-LAST:event_formKeyReleased

    private void btnPad1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPad1ActionPerformed
        btnNumeroActionPerformed(evt);
    }//GEN-LAST:event_btnPad1ActionPerformed

    private void btnPad2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPad2ActionPerformed
        btnNumeroActionPerformed(evt);
    }//GEN-LAST:event_btnPad2ActionPerformed

    private void btnPad3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPad3ActionPerformed
        btnNumeroActionPerformed(evt);
    }//GEN-LAST:event_btnPad3ActionPerformed

    private void btnPad4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPad4ActionPerformed
        btnNumeroActionPerformed(evt);
    }//GEN-LAST:event_btnPad4ActionPerformed

    private void btnPad5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPad5ActionPerformed
        btnNumeroActionPerformed(evt);
    }//GEN-LAST:event_btnPad5ActionPerformed

    private void btnPad6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPad6ActionPerformed
        btnNumeroActionPerformed(evt);
    }//GEN-LAST:event_btnPad6ActionPerformed

    private void btnPad7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPad7ActionPerformed
        btnNumeroActionPerformed(evt);
    }//GEN-LAST:event_btnPad7ActionPerformed

    private void btnPad8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPad8ActionPerformed
        btnNumeroActionPerformed(evt);
    }//GEN-LAST:event_btnPad8ActionPerformed

    private void btnPad9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPad9ActionPerformed
        btnNumeroActionPerformed(evt);
    }//GEN-LAST:event_btnPad9ActionPerformed

    private void btnPad0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPad0ActionPerformed
        btnNumeroActionPerformed(evt);
    }//GEN-LAST:event_btnPad0ActionPerformed

    private void btnRestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestaActionPerformed
        btnOperadorActionPerformed(evt);
    }//GEN-LAST:event_btnRestaActionPerformed

    private void btnSumaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSumaActionPerformed
        btnOperadorActionPerformed(evt);
    }//GEN-LAST:event_btnSumaActionPerformed

    private void btnMultiplicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMultiplicacionActionPerformed
        btnOperadorActionPerformed(evt);
    }//GEN-LAST:event_btnMultiplicacionActionPerformed

    private void btnDivisionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDivisionActionPerformed
        btnOperadorActionPerformed(evt);
    }//GEN-LAST:event_btnDivisionActionPerformed

    private void btnCEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCEActionPerformed
        expresion = "";
        inputPantalla.setText(expresion);
        resultadoPantalla.setText("");
    }//GEN-LAST:event_btnCEActionPerformed

    private void btnCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCActionPerformed
        if (!expresion.isEmpty()) {
            expresion = expresion.substring(0, expresion.length() - 1);
            inputPantalla.setText(expresion);
        }
    }//GEN-LAST:event_btnCActionPerformed

    private void btnIgualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIgualActionPerformed
        if (!expresion.isEmpty()) {
            String[] partes = expresion.split("\\+|-|\\*|/");

            if (partes.length == 2) {
                double numero1 = Double.parseDouble(partes[0]);
                double numero2 = Double.parseDouble(partes[1]);
                double resultado = 0;

                if (expresion.contains("+")) {
                    resultado = numero1 + numero2;
                } else if (expresion.contains("-")) {
                    resultado = numero1 - numero2;
                } else if (expresion.contains("*")) {
                    resultado = numero1 * numero2;
                } else if (expresion.contains("/")) {
                    if (numero2 != 0) {
                        resultado = numero1 / numero2;
                    } else {
                        resultadoPantalla.setText("Error: División por cero");
                        return;
                    }
                }

                resultadoPantalla.setText(String.valueOf(resultado));
                expresion = String.valueOf(resultado);
            }
        }
    }//GEN-LAST:event_btnIgualActionPerformed

    private void btnPuntoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPuntoActionPerformed
        if (!expresion.isEmpty() && !expresion.endsWith(".")) {
            expresion += ".";
            inputPantalla.setText(expresion);
        }
    }//GEN-LAST:event_btnPuntoActionPerformed

    private void btnRaizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRaizActionPerformed
        if (!expresion.isEmpty()) {
            double numero = Double.parseDouble(expresion);
            double resultado = Math.sqrt(numero);
            resultadoPantalla.setText(String.valueOf(resultado));
            expresion = String.valueOf(resultado);
        }
    }//GEN-LAST:event_btnRaizActionPerformed

    private void btnCuadradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCuadradoActionPerformed
        if (!expresion.isEmpty()) {
            double numero = Double.parseDouble(expresion);
            double resultado = Math.pow(numero, 2);
            resultadoPantalla.setText(String.valueOf(resultado));
            expresion = String.valueOf(resultado);
        }
    }//GEN-LAST:event_btnCuadradoActionPerformed

    private void btnCubicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCubicoActionPerformed
        if (!expresion.isEmpty()) {
            double numero = Double.parseDouble(expresion);
            double resultado = Math.pow(numero, 3);
            resultadoPantalla.setText(String.valueOf(resultado));
            expresion = String.valueOf(resultado);
        }
    }//GEN-LAST:event_btnCubicoActionPerformed

    private void btnPorcentajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPorcentajeActionPerformed
        if (!expresion.isEmpty()) {
        double numero = Double.parseDouble(expresion);
        double resultado = numero / 100;
        resultadoPantalla.setText(String.valueOf(resultado));
        expresion = String.valueOf(resultado);
    }
    }//GEN-LAST:event_btnPorcentajeActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        MenuPrincipalFrame menuPrincipalFrame = new MenuPrincipalFrame();
        this.dispose(); // Cierra el JFrame actual
        menuPrincipalFrame.setVisible(true);
    }//GEN-LAST:event_btnAtrasActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnBorrarDigito;
    private javax.swing.JButton btnC;
    private javax.swing.JButton btnCE;
    private javax.swing.JButton btnCuadrado;
    private javax.swing.JButton btnCubico;
    private javax.swing.JButton btnDivision;
    private javax.swing.JButton btnIgual;
    private javax.swing.JButton btnMasIgual;
    private javax.swing.JButton btnMultiplicacion;
    private javax.swing.JButton btnPad0;
    private javax.swing.JButton btnPad1;
    private javax.swing.JButton btnPad2;
    private javax.swing.JButton btnPad3;
    private javax.swing.JButton btnPad4;
    private javax.swing.JButton btnPad5;
    private javax.swing.JButton btnPad6;
    private javax.swing.JButton btnPad7;
    private javax.swing.JButton btnPad8;
    private javax.swing.JButton btnPad9;
    private javax.swing.JButton btnPorcentaje;
    private javax.swing.JButton btnPunto;
    private javax.swing.JButton btnRaiz;
    private javax.swing.JButton btnResta;
    private javax.swing.JButton btnSuma;
    private javax.swing.JLabel inputPantalla;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel resultadoPantalla;
    // End of variables declaration//GEN-END:variables

}
