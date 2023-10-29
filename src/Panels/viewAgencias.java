package Panels;

import javax.swing.table.DefaultTableModel;
import Clases.Agencia;
import java.util.ArrayList;
import rojerusan.RSNotifyFade;

public class viewAgencias extends javax.swing.JPanel {

    DefaultTableModel modelo;
    Agencia seleccionado = new Agencia();
    ArrayList<Agencia> agencias = new ArrayList();

    public viewAgencias() {
        initComponents();
        modelo = (DefaultTableModel) tabla.getModel();
        iniciar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new rojerusan.RSTableMetro();
        pnDetalleAgencia = new javax.swing.JPanel();
        pnInformacion = new javax.swing.JPanel();
        lbNombreAgencia = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtContraseña = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        txtComision = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnGuardarDatos = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtNombreAgencia = new javax.swing.JTextField();
        checkStatus = new javax.swing.JCheckBox();
        pnBotones = new javax.swing.JPanel();
        btnActivarAgencia = new javax.swing.JButton();
        btnLiberarSerial = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        pnDetalle = new javax.swing.JPanel();
        btnActualizarTabla = new javax.swing.JButton();
        lbResultados = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "#", "Nombre", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.setAltoHead(30);
        tabla.setColorBackgoundHead(new java.awt.Color(0, 153, 153));
        tabla.setColorBordeFilas(new java.awt.Color(120, 120, 120));
        tabla.setColorBordeHead(new java.awt.Color(120, 120, 120));
        tabla.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tabla.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        tabla.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        tabla.setFuenteFilas(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tabla.setFuenteFilasSelect(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tabla.setFuenteHead(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tabla.setGridColor(new java.awt.Color(255, 255, 255));
        tabla.setRowHeight(25);
        tabla.setShowGrid(true);
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);
        if (tabla.getColumnModel().getColumnCount() > 0) {
            tabla.getColumnModel().getColumn(0).setMinWidth(70);
            tabla.getColumnModel().getColumn(0).setPreferredWidth(70);
            tabla.getColumnModel().getColumn(0).setMaxWidth(70);
            tabla.getColumnModel().getColumn(1).setResizable(false);
            tabla.getColumnModel().getColumn(2).setResizable(false);
        }

        pnDetalleAgencia.setBackground(new java.awt.Color(0, 102, 102));

        lbNombreAgencia.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbNombreAgencia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbNombreAgencia.setText("jLabel1");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Nombre de Usuario:");

        txtUsername.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtUsername.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Contraseña:");

        txtContraseña.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtContraseña.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Comisión ( % )");

        txtComision.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtComision.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Estado:");

        btnGuardarDatos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/disquete.png"))); // NOI18N
        btnGuardarDatos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarDatosActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Nombre de Agencia");

        txtNombreAgencia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNombreAgencia.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        checkStatus.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        checkStatus.setText("Activo");
        checkStatus.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                checkStatusItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout pnInformacionLayout = new javax.swing.GroupLayout(pnInformacion);
        pnInformacion.setLayout(pnInformacionLayout);
        pnInformacionLayout.setHorizontalGroup(
            pnInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnInformacionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbNombreAgencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnInformacionLayout.createSequentialGroup()
                        .addGroup(pnInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(checkStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtUsername)
                            .addComponent(txtNombreAgencia, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))
                        .addGroup(pnInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnInformacionLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(pnInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtComision, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                    .addComponent(txtContraseña))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnInformacionLayout.createSequentialGroup()
                                .addGap(281, 281, 281)
                                .addComponent(btnGuardarDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        pnInformacionLayout.setVerticalGroup(
            pnInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnInformacionLayout.createSequentialGroup()
                .addComponent(lbNombreAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnInformacionLayout.createSequentialGroup()
                        .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 4, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnInformacionLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtComision)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNombreAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnInformacionLayout.createSequentialGroup()
                        .addComponent(btnGuardarDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnInformacionLayout.createSequentialGroup()
                        .addGroup(pnInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(checkStatus))
                        .addGap(18, 18, 18))))
        );

        pnBotones.setOpaque(false);

        btnActivarAgencia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnActivarAgencia.setText("Activar");
        btnActivarAgencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActivarAgenciaActionPerformed(evt);
            }
        });

        btnLiberarSerial.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnLiberarSerial.setText("Liberar Serial");
        btnLiberarSerial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLiberarSerialActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton4.setText("Cambiar Cupo");

        javax.swing.GroupLayout pnBotonesLayout = new javax.swing.GroupLayout(pnBotones);
        pnBotones.setLayout(pnBotonesLayout);
        pnBotonesLayout.setHorizontalGroup(
            pnBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnActivarAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLiberarSerial, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnBotonesLayout.setVerticalGroup(
            pnBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnBotonesLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(pnBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActivarAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLiberarSerial, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout pnDetalleLayout = new javax.swing.GroupLayout(pnDetalle);
        pnDetalle.setLayout(pnDetalleLayout);
        pnDetalleLayout.setHorizontalGroup(
            pnDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnDetalleLayout.setVerticalGroup(
            pnDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnDetalleAgenciaLayout = new javax.swing.GroupLayout(pnDetalleAgencia);
        pnDetalleAgencia.setLayout(pnDetalleAgenciaLayout);
        pnDetalleAgenciaLayout.setHorizontalGroup(
            pnDetalleAgenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDetalleAgenciaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnDetalleAgenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnDetalle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnInformacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnDetalleAgenciaLayout.setVerticalGroup(
            pnDetalleAgenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDetalleAgenciaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnInformacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnDetalle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnActualizarTabla.setText("Actualizar");
        btnActualizarTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarTablaActionPerformed(evt);
            }
        });

        lbResultados.setText("@");

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnActualizarTabla)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbResultados, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)))
                .addComponent(pnDetalleAgencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnDetalleAgencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbResultados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnActualizarTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarTablaActionPerformed
        new Thread(() -> {
            resetearBusqueda();
            llenarTabla();
        }).start();
    }//GEN-LAST:event_btnActualizarTablaActionPerformed

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
        llenarTabla();
    }//GEN-LAST:event_txtBuscarKeyTyped

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        int row = tabla.getSelectedRow();
        if (row > -1) {
            int idAgencia = Integer.parseInt(tabla.getValueAt(row, 0).toString());
            seleccionado = agencias.stream()
                    .filter(t
                            -> Float.compare(
                            t.getId(),
                            idAgencia
                    ) == 0
                    ).findFirst()
                    .orElse(
                            new Agencia()
                    );
            colocarDatosAgencia();
        }
    }//GEN-LAST:event_tablaMouseClicked

    private void btnGuardarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarDatosActionPerformed
        seleccionado.setNombreAgencia(txtNombreAgencia.getText());
        seleccionado.setUsername(txtUsername.getText());
        seleccionado.setPassword(txtContraseña.getText());
        seleccionado.setEstado(checkStatus.isSelected() ? "Activo" : "Inactivo");
        seleccionado.setComision(Double.parseDouble(txtComision.getText()));

        if (seleccionado.update()) {
            new rojerusan.RSNotifyFade(
                    "Datos actualizados",
                    "Los datos ingresados fueron actualizados correctamente.",
                    4,
                    RSNotifyFade.PositionNotify.BottomRight,
                    RSNotifyFade.TypeNotify.SUCCESS
            ).setVisible(true);
        }

    }//GEN-LAST:event_btnGuardarDatosActionPerformed

    private void checkStatusItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_checkStatusItemStateChanged
        checkStatus.setText(checkStatus.isSelected() ? "Activo" : "Inactivo");
    }//GEN-LAST:event_checkStatusItemStateChanged

    private void btnActivarAgenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActivarAgenciaActionPerformed
        if (seleccionado.getId() > 0) {
            if (seleccionado.cambiarEstado(
                    seleccionado.getEstado().equalsIgnoreCase("activo")
                    ? "Inactivo"
                    : "Activo")) {
                new rojerusan.RSNotifyFade(
                        "Datos actualizados",
                        "Los datos ingresados fueron actualizados correctamente.",
                        4,
                        RSNotifyFade.PositionNotify.BottomRight,
                        RSNotifyFade.TypeNotify.SUCCESS
                ).setVisible(true);
            }
        } else {
            new rojerusan.RSNotifyFade(
                    "Seleccione Agencia",
                    "No hay agencia seleccionada.",
                    4,
                    RSNotifyFade.PositionNotify.BottomRight,
                    RSNotifyFade.TypeNotify.WARNING
            ).setVisible(true);
        }
    }//GEN-LAST:event_btnActivarAgenciaActionPerformed

    private void btnLiberarSerialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLiberarSerialActionPerformed

        if (seleccionado.getId() > 0) {
            if (seleccionado.liberarSerial()) {
                new rojerusan.RSNotifyFade(
                        "Serial Liberado",
                        "Ya puede abrir la taquilla en un nuevo computador .",
                        4,
                        RSNotifyFade.PositionNotify.BottomRight,
                        RSNotifyFade.TypeNotify.SUCCESS
                ).setVisible(true);
            }
        } else {
            new rojerusan.RSNotifyFade(
                    "Seleccione Agencia",
                    "No hay agencia seleccionada.",
                    4,
                    RSNotifyFade.PositionNotify.BottomRight,
                    RSNotifyFade.TypeNotify.WARNING
            ).setVisible(true);
        }


    }//GEN-LAST:event_btnLiberarSerialActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActivarAgencia;
    private javax.swing.JButton btnActualizarTabla;
    private javax.swing.JButton btnGuardarDatos;
    private javax.swing.JButton btnLiberarSerial;
    private javax.swing.JCheckBox checkStatus;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbNombreAgencia;
    private javax.swing.JLabel lbResultados;
    private javax.swing.JPanel pnBotones;
    private javax.swing.JPanel pnDetalle;
    private javax.swing.JPanel pnDetalleAgencia;
    private javax.swing.JPanel pnInformacion;
    private rojerusan.RSTableMetro tabla;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtComision;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtNombreAgencia;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables

    private void iniciar() {
        modelo = (DefaultTableModel) tabla.getModel();
        resetearBusqueda();
        llenarTabla();
    }

    private void resetearBusqueda() {
        agencias = (ArrayList) new Agencia().listarAgencias().clone();
    }

    private void llenarTabla() {
        String texto = txtBuscar.getText().toLowerCase().isEmpty()
                ? ""
                : txtBuscar.getText().toLowerCase();
        modelo.setRowCount(0);
        int cantidad = 0;
        for (Agencia agencia : agencias) {
            if (agencia.getNombreAgencia().toLowerCase().contains(texto)) {
                cantidad++;
                modelo.addRow(new Object[]{
                    agencia.getId(),
                    agencia.getNombreAgencia(),
                    agencia.getEstado()
                });
            }
        }
        lbResultados.setText(cantidad + " Resultados");
    }

    private void colocarDatosAgencia() {
        lbNombreAgencia.setText(seleccionado.getNombreAgencia());
        txtUsername.setText(seleccionado.getUsername());
        txtNombreAgencia.setText(seleccionado.getNombreAgencia());
        txtComision.setText(seleccionado.getComision() + "");
        checkStatus.setSelected(seleccionado.getEstado().equalsIgnoreCase("activo") ? true : false);

        btnActivarAgencia.setText(seleccionado.getEstado().equalsIgnoreCase("Activo") ? "Desactivar" : "Activar");
    }

}
