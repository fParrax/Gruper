package Panels;

import javax.swing.table.DefaultTableModel;
import Clases.Agencia;
import Clases.CupoAgencia;
import Clases.EncriptadorAES;
import Clases.tools;
import Frames.AgregarCupo;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JOptionPane;
import rojerusan.RSNotifyFade;

public class viewAgencias extends javax.swing.JPanel {

    DefaultTableModel modelo;
    Agencia seleccionado = new Agencia();
    ArrayList<Agencia> agencias = new ArrayList();
    
    boolean agregar=false;

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
        jLabel10 = new javax.swing.JLabel();
        txtCierreTicket = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtMontoMinimo = new javax.swing.JTextField();
        pnBotones = new javax.swing.JPanel();
        btnActivarAgencia = new javax.swing.JButton();
        btnLiberarSerial = new javax.swing.JButton();
        pnDetalle = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtCupoPermanente = new javax.swing.JTextField();
        btnUpdateCupoPermanente = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnActualizarTabla = new javax.swing.JButton();
        lbResultados = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnNewAgencia = new javax.swing.JButton();

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
        }

        pnDetalleAgencia.setBackground(new java.awt.Color(0, 102, 102));

        pnInformacion.setOpaque(false);

        lbNombreAgencia.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        lbNombreAgencia.setForeground(new java.awt.Color(255, 255, 255));
        lbNombreAgencia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbNombreAgencia.setText("Esperando seleccione agencia");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nombre de Usuario:");

        txtUsername.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txtUsername.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Contraseña:");

        txtContraseña.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txtContraseña.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Comisión ( % )");

        txtComision.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txtComision.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtComision.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtComisionKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Estado:");

        btnGuardarDatos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/disquete.png"))); // NOI18N
        btnGuardarDatos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnGuardarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarDatosActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Nombre de Agencia");

        txtNombreAgencia.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txtNombreAgencia.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        checkStatus.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        checkStatus.setForeground(new java.awt.Color(255, 255, 255));
        checkStatus.setText("Activo");
        checkStatus.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                checkStatusItemStateChanged(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Cierre de Tickets:");

        txtCierreTicket.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txtCierreTicket.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCierreTicket.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCierreTicketKeyTyped(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Monto Minimo:");

        txtMontoMinimo.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txtMontoMinimo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMontoMinimo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMontoMinimoKeyTyped(evt);
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
                        .addGroup(pnInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnInformacionLayout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(164, 164, 164)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(txtMontoMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pnInformacionLayout.createSequentialGroup()
                                    .addGap(11, 11, 11)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(8, 8, 8)
                                    .addComponent(checkStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(pnInformacionLayout.createSequentialGroup()
                                    .addGroup(pnInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(pnInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtNombreAgencia, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                                        .addComponent(txtUsername)
                                        .addComponent(txtCierreTicket))
                                    .addGap(18, 18, 18)
                                    .addGroup(pnInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(pnInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtComision, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                        .addComponent(txtContraseña)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardarDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnInformacionLayout.setVerticalGroup(
            pnInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnInformacionLayout.createSequentialGroup()
                .addComponent(lbNombreAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtComision)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNombreAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGuardarDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCierreTicket)
                        .addGroup(pnInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtMontoMinimo))))
                .addGap(21, 21, 21)
                .addGroup(pnInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(checkStatus))
                .addContainerGap())
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

        javax.swing.GroupLayout pnBotonesLayout = new javax.swing.GroupLayout(pnBotones);
        pnBotones.setLayout(pnBotonesLayout);
        pnBotonesLayout.setHorizontalGroup(
            pnBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnActivarAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLiberarSerial, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnBotonesLayout.setVerticalGroup(
            pnBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnBotonesLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(pnBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActivarAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLiberarSerial, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        pnDetalle.setOpaque(false);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Información sobre los cupos");

        jButton1.setText("AGREGAR CUPO");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 21)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Cupo General:");

        txtCupoPermanente.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtCupoPermanente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCupoPermanente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCupoPermanenteKeyTyped(evt);
            }
        });

        btnUpdateCupoPermanente.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        btnUpdateCupoPermanente.setText("Actualizar");
        btnUpdateCupoPermanente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateCupoPermanenteActionPerformed(evt);
            }
        });

        jButton2.setText("VER HISTORIAL CUPOS");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnDetalleLayout = new javax.swing.GroupLayout(pnDetalle);
        pnDetalle.setLayout(pnDetalleLayout);
        pnDetalleLayout.setHorizontalGroup(
            pnDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDetalleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnDetalleLayout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(pnDetalleLayout.createSequentialGroup()
                        .addGroup(pnDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtCupoPermanente)
                            .addGroup(pnDetalleLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnDetalleLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(btnUpdateCupoPermanente, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(218, 218, 218))))
        );
        pnDetalleLayout.setVerticalGroup(
            pnDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDetalleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCupoPermanente, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdateCupoPermanente, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
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
                .addComponent(pnInformacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnActualizarTabla.setText("Actualizar Resultados");
        btnActualizarTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarTablaActionPerformed(evt);
            }
        });

        lbResultados.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbResultados.setText("Esperando actualización de resultados");

        txtBuscar.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Buscar Agencia");

        btnNewAgencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/add-button.png"))); // NOI18N
        btnNewAgencia.setText("Agencia");
        btnNewAgencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewAgenciaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(lbResultados, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                            .addComponent(txtBuscar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnActualizarTabla, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnNewAgencia, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(18, 18, 18)
                .addComponent(pnDetalleAgencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnDetalleAgencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNewAgencia)
                    .addComponent(jLabel6))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActualizarTabla)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbResultados)
                .addGap(7, 7, 7)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
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
        try {
            if (validarCamposLlenos()) {
                if (agregar) {
                    if (new Agencia().insert(
                            txtNombreAgencia.getText(),
                            txtUsername.getText(),
                            new EncriptadorAES().encriptar(txtContraseña.getText()),
                            "",
                            30,
                            Integer.parseInt(txtComision.getText()))>0) {
                        new rojerusan.RSNotifyFade(
                                "Agencia Agregada",
                                "Se creo correctamente la agencia. El seríal será asignado una vez ingrese por primera vez",
                                4,
                                RSNotifyFade.PositionNotify.BottomRight,
                                RSNotifyFade.TypeNotify.SUCCESS
                        ).setVisible(true);
                        resetearBusqueda();
                    } else {
                        new rojerusan.RSNotifyFade(
                                "Ups!. Algo salió mal",
                                "se ha producido un error durante la insercción de la agencia, contacte con el administrador.",
                                4,
                                RSNotifyFade.PositionNotify.BottomRight,
                                RSNotifyFade.TypeNotify.ERROR
                        ).setVisible(true);
                    }

                } else {
                    seleccionado.setNombreAgencia(txtNombreAgencia.getText());
                    seleccionado.setUsername(txtUsername.getText());
                    seleccionado.setPassword(new EncriptadorAES().encriptar(txtContraseña.getText()));
                    seleccionado.setEstado(checkStatus.isSelected() ? "Activo" : "Inactivo");
                    seleccionado.setComision(Double.parseDouble(txtComision.getText()));
                    seleccionado.setJugadaMinima(Integer.parseInt(txtMontoMinimo.getText()));
                    seleccionado.setMinutosCierre(Integer.parseInt(txtCierreTicket.getText()));

                    if (seleccionado.update()) {
                        resetearBusqueda();
                        new rojerusan.RSNotifyFade(
                                "Datos actualizados",
                                "Los datos ingresados fueron actualizados correctamente.",
                                4,
                                RSNotifyFade.PositionNotify.BottomRight,
                                RSNotifyFade.TypeNotify.SUCCESS
                        ).setVisible(true);
                    }
                }
            }else{
                JOptionPane.showMessageDialog(pnBotones, "Debe llenar todos los campos, no puede quedar vacios.");
            }
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(viewAgencias.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(viewAgencias.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(viewAgencias.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(viewAgencias.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(viewAgencias.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(viewAgencias.class.getName()).log(Level.SEVERE, null, ex);
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
                btnActualizarTabla.doClick();
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

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void btnNewAgenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewAgenciaActionPerformed
      limpiarDatos();
      agregar=true;
      txtUsername.requestFocus();
      btnNewAgencia.setEnabled(false);
    }//GEN-LAST:event_btnNewAgenciaActionPerformed

    private void txtComisionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtComisionKeyTyped
       new tools().soloNumerosyCantidadDigitos(evt, txtComision, 1);
    }//GEN-LAST:event_txtComisionKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     new AgregarCupo(agencias).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtCupoPermanenteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCupoPermanenteKeyTyped
       new tools().soloNumerosyCantidadDigitos(evt, txtCupoPermanente, 2);
    }//GEN-LAST:event_txtCupoPermanenteKeyTyped

    private void btnUpdateCupoPermanenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateCupoPermanenteActionPerformed
      if(txtCupoPermanente.getText().isEmpty() && seleccionado.getId()>0){
          JOptionPane.showMessageDialog(pnBotones, "Antes de actualizar debe seleccionar una agencia e ingresar un monto");
      }else{
          double nuevoMonto = Double.parseDouble(txtCupoPermanente.getText());
          if(seleccionado.updateCupoPermanente(nuevoMonto)){
              
              JOptionPane.showMessageDialog(pnBotones, "Cupo Actualizado");
          }
      }
    }//GEN-LAST:event_btnUpdateCupoPermanenteActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtCierreTicketKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCierreTicketKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCierreTicketKeyTyped

    private void txtMontoMinimoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMontoMinimoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMontoMinimoKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActivarAgencia;
    private javax.swing.JButton btnActualizarTabla;
    private javax.swing.JButton btnGuardarDatos;
    private javax.swing.JButton btnLiberarSerial;
    private javax.swing.JButton btnNewAgencia;
    private javax.swing.JButton btnUpdateCupoPermanente;
    private javax.swing.JCheckBox checkStatus;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
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
    private javax.swing.JTextField txtCierreTicket;
    private javax.swing.JTextField txtComision;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtCupoPermanente;
    private javax.swing.JTextField txtMontoMinimo;
    private javax.swing.JTextField txtNombreAgencia;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables

    private void iniciar() {
        modelo = (DefaultTableModel) tabla.getModel();
        new Thread(()->{
            resetearBusqueda();
        }).start();
    }

    private void resetearBusqueda() {
        limpiarDatos();
        agencias = (ArrayList) new Agencia().listarAgencias().clone();
        llenarTabla();
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
        try {
            lbNombreAgencia.setText(seleccionado.getNombreAgencia());
            txtUsername.setText(seleccionado.getUsername());
            txtNombreAgencia.setText(seleccionado.getNombreAgencia());
            txtComision.setText(seleccionado.getComision() + "");
            checkStatus.setSelected(seleccionado.getEstado().equalsIgnoreCase("activo") ? true : false);
            txtContraseña.setText(new EncriptadorAES().desencriptar(seleccionado.getPassword()));
            btnActivarAgencia.setText(seleccionado.getEstado().equalsIgnoreCase("Activo") ? "Desactivar" : "Activar");
            txtCupoPermanente.setText(seleccionado.getCupoAnimal()+"");
            txtCierreTicket.setText(seleccionado.getMinutosCierre()+"");
            txtMontoMinimo.setText(seleccionado.getJugadaMinima()+"");
            
        
        
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(viewAgencias.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(viewAgencias.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(viewAgencias.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(viewAgencias.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(viewAgencias.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(viewAgencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void limpiarDatos(){
        lbNombreAgencia.setText("Seleccione Agencia");
        txtUsername.setText("");
        txtNombreAgencia.setText("");
        txtComision.setText( "");
        checkStatus.setSelected(false);
        txtContraseña.setText("");
        seleccionado = new Agencia();
        btnActivarAgencia.setText("Select Agencia");
        agregar=false;
        btnNewAgencia.setEnabled(true);
        txtCupoPermanente.setText("");
        txtCierreTicket.setText("");
        txtMontoMinimo.setText("");
        txtBuscar.requestFocus();
        
    }

    private boolean validarCamposLlenos() {
        return !txtUsername.getText().isEmpty() &&
                !txtContraseña.getText().isEmpty() &&
                !txtNombreAgencia.getText().isEmpty() &&
                !txtComision.getText().isEmpty();
    }

}
