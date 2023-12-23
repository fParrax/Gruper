/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frames;

import Clases.ConectarDBCloud;
import Panels.viewBienvenido;

/**
 *
 * @author franklinp
 */
public class Index extends javax.swing.JFrame {

    public static String fechaHoy="2023-10-31";
    VerAgencias verAgencias;
    viewBienvenido vwBienvenido;
    public Index() {
        initComponents();
        new Thread(this::iniciar).start();
    }
private void iniciar(){
    
    vwBienvenido = new viewBienvenido();
    scrollPane.setViewportView(vwBienvenido);
    fechaHoy = new ConectarDBCloud("ag").tomarFecha();
    
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCentral = new javax.swing.JPanel();
        scrollPane = new javax.swing.JScrollPane();
        panelSuperior = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        miVerAgencias = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        miIngresarResultado = new javax.swing.JMenuItem();
        miVerResultados = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mitemVerVentas = new javax.swing.JMenuItem();
        mitemVerTickets = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Principal Banca");

        panelCentral.setBackground(new java.awt.Color(255, 255, 255));

        panelSuperior.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelSuperiorLayout = new javax.swing.GroupLayout(panelSuperior);
        panelSuperior.setLayout(panelSuperiorLayout);
        panelSuperiorLayout.setHorizontalGroup(
            panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1173, Short.MAX_VALUE)
        );
        panelSuperiorLayout.setVerticalGroup(
            panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 76, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelCentralLayout = new javax.swing.GroupLayout(panelCentral);
        panelCentral.setLayout(panelCentralLayout);
        panelCentralLayout.setHorizontalGroup(
            panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelSuperior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(scrollPane)
        );
        panelCentralLayout.setVerticalGroup(
            panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCentralLayout.createSequentialGroup()
                .addComponent(panelSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE))
        );

        jMenu3.setText("Agencias");

        miVerAgencias.setText("Ver Agencias");
        miVerAgencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miVerAgenciasActionPerformed(evt);
            }
        });
        jMenu3.add(miVerAgencias);

        jMenuBar1.add(jMenu3);

        jMenu1.setText("Resultados");

        miIngresarResultado.setText("Corregir Resultado");
        miIngresarResultado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miIngresarResultadoActionPerformed(evt);
            }
        });
        jMenu1.add(miIngresarResultado);

        miVerResultados.setText("Ver Resultados");
        miVerResultados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miVerResultadosActionPerformed(evt);
            }
        });
        jMenu1.add(miVerResultados);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Ventas");

        mitemVerVentas.setText("Ver Ventas");
        mitemVerVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitemVerVentasActionPerformed(evt);
            }
        });
        jMenu2.add(mitemVerVentas);

        mitemVerTickets.setText("Ver Tickets");
        mitemVerTickets.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitemVerTicketsActionPerformed(evt);
            }
        });
        jMenu2.add(mitemVerTickets);

        jMenuBar1.add(jMenu2);

        jMenu4.setText("Reportes");
        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCentral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCentral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void miIngresarResultadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miIngresarResultadoActionPerformed
     new newResultado().setVisible(true);
    }//GEN-LAST:event_miIngresarResultadoActionPerformed

    private void mitemVerVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitemVerVentasActionPerformed
      new verVentas().setVisible(true);
    }//GEN-LAST:event_mitemVerVentasActionPerformed

    private void mitemVerTicketsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitemVerTicketsActionPerformed
       new VerTickets().setVisible(true);
    }//GEN-LAST:event_mitemVerTicketsActionPerformed

    private void miVerResultadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miVerResultadosActionPerformed
       new verResultados().setVisible(true);
    }//GEN-LAST:event_miVerResultadosActionPerformed

    private void miVerAgenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miVerAgenciasActionPerformed
      if(verAgencias == null){
           verAgencias = new VerAgencias();
       }
        
       verAgencias.setVisible(true);
    }//GEN-LAST:event_miVerAgenciasActionPerformed

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
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Index().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem miIngresarResultado;
    private javax.swing.JMenuItem miVerAgencias;
    private javax.swing.JMenuItem miVerResultados;
    private javax.swing.JMenuItem mitemVerTickets;
    private javax.swing.JMenuItem mitemVerVentas;
    private javax.swing.JPanel panelCentral;
    private javax.swing.JPanel panelSuperior;
    private javax.swing.JScrollPane scrollPane;
    // End of variables declaration//GEN-END:variables
}
