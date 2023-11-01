
package Frames;

import Clases.ConectarDBCloud;
import Clases.Resultado;
import java.awt.Image;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author pc
 */
public class newResultado extends javax.swing.JFrame {

    /**
     * Creates new form newResultado
     */
    public newResultado() {
        initComponents();
        changeIcon();
        inciarDatos();
    }

    public void changeIcon() {
        Image icon = new ImageIcon(getClass().getResource("/imgs/chip.png")).getImage();
        setIconImage(icon);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCentral = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        comboPrograma = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        comboSorteo = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        comboResultado = new javax.swing.JComboBox<>();
        btnIngresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ingresar Resultados");

        panelCentral.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(0, 58, 68));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("INGRESE RESULTADO DE ANIMALITOS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 786, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setText("Fecha:");

        txtFecha.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd"))));
        txtFecha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFecha.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setText("Programa:");

        comboPrograma.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        comboPrograma.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "LottoActivo", "Granjita" }));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setText("Sorteo");

        comboSorteo.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        comboSorteo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "8:00 AM", "9:00 AM", "10:00 AM", "11:00 AM", "12:00 PM", "1:00 PM", "2:00 PM", "3:00 PM", "4:00 PM", "5:00 PM", "6:00 PM", "7:00 PM" }));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Resultado", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14), new java.awt.Color(102, 102, 102))); // NOI18N

        comboResultado.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        comboResultado.setMaximumRowCount(20);
        comboResultado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboResultado.setAutoscrolls(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(comboResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(252, 252, 252))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comboResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        btnIngresar.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        btnIngresar.setText("Ingresar Resultado");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelCentralLayout = new javax.swing.GroupLayout(panelCentral);
        panelCentral.setLayout(panelCentralLayout);
        panelCentralLayout.setHorizontalGroup(
            panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelCentralLayout.createSequentialGroup()
                .addGroup(panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCentralLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelCentralLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(comboPrograma, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(comboSorteo, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCentralLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnIngresar)
                .addGap(299, 299, 299))
        );
        panelCentralLayout.setVerticalGroup(
            panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCentralLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboPrograma, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboSorteo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 30, Short.MAX_VALUE))
        );

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

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
      
        String programa = comboPrograma.getSelectedItem().toString();
        String sorteo = programa+" "+comboSorteo.getSelectedItem().toString().replace(":00", "");
        String animal =comboResultado.getSelectedItem().toString();
        
       Resultado resultado = new Resultado(
               txtFecha.getText(),
               programa,
               sorteo,
               AnimalConvertNameToNumber(animal)+animal
       );
               int rsp = resultado.insert();
               if(rsp>0){
                   JOptionPane.showMessageDialog(rootPane, "Resultado Ingresado correctamente" );
               }
    }//GEN-LAST:event_btnIngresarActionPerformed

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
            java.util.logging.Logger.getLogger(newResultado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(newResultado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(newResultado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(newResultado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new newResultado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JComboBox<String> comboPrograma;
    private javax.swing.JComboBox<String> comboResultado;
    private javax.swing.JComboBox<String> comboSorteo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel panelCentral;
    private javax.swing.JFormattedTextField txtFecha;
    // End of variables declaration//GEN-END:variables

    private void inciarDatos() {
        String hoy = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        txtFecha.setText(hoy);
        llenarAnimales();
        
        
    }
    private void llenarAnimales(){
        comboResultado.removeAllItems();
        for (int i = -1; i < 37; i++) {
            comboResultado.addItem(AnimalConvertNumberToLetter(i));
        }
    }

   
    public String AnimalConvertNumberToLetter(int numero) {
        String animal = "";

        if (true) {
            switch (numero) {
                case 0:
                    animal = "Delfin";
                    break;
                case -1:
                    animal = "Ballena";
                    break;
                case 1:
                    animal = "Carnero";
                    break;
                case 2:
                    animal = "Toro";
                    break;
                case 3:
                    animal = "Ciempies";
                    break;
                case 4:
                    animal = "Alacrán";
                    break;
                case 5:
                    animal = "Leon";
                    break;
                case 6:
                    animal = "Rana";
                    break;
                case 7:
                    animal = "Perico";
                    break;
                case 8:
                    animal = "Ratón";
                    break;
                case 9:
                    animal = "Aguila";
                    break;
                case 10:
                    animal = "Tigre";
                    break;
                case 11:
                    animal = "Gato";
                    break;
                case 12:
                    animal = "Caballo";
                    break;
                case 13:
                    animal = "Mono";
                    break;
                case 14:
                    animal = "Paloma";
                    break;
                case 15:
                    animal = "Zorro";
                    break;
                case 16:
                    animal = "Oso";
                    break;
                case 17:
                    animal = "Pavo";
                    break;
                case 18:
                    animal = "Burro";
                    break;
                case 19:
                    animal = "Chivo";
                    break;
                case 20:
                    animal = "Cochino";
                    break;
                case 21:
                    animal = "Gallo";
                    break;
                case 22:
                    animal = "Camello";
                    break;
                case 23:
                    animal = "Cebra";
                    break;
                case 24:
                    animal = "Iguana";
                    break;
                case 25:
                    animal = "Gallina";
                    break;
                case 26:
                    animal = "Vaca";
                    break;
                case 27:
                    animal = "Perro";
                    break;
                case 28:
                    animal = "Zamuro";
                    break;
                case 29:
                    animal = "Elefante";
                    break;
                case 30:
                    animal = "Caimán";
                    break;
                case 31:
                    animal = "Lapa";
                    break;
                case 32:
                    animal = "Ardilla";
                    break;
                case 33:
                    animal = "Pescado";
                    break;
                case 34:
                    animal = "Venado";
                    break;
                case 35:
                    animal = "Jirafa";
                    break;
                case 36:
                    animal = "Culebra";
                    break;
            }
        }
        return animal;
    }
    
    public String AnimalConvertNameToNumber(String nombreAnimal) {
    String animal = "";

    switch (nombreAnimal) {
        case "Delfin":
            animal = "0";
            break;
        case "Ballena":
            animal = "-1";
            break;
        case "Carnero":
            animal = "1";
            break;
        case "Toro":
            animal = "2";
            break;
        case "Ciempies":
            animal = "3";
            break;
        case "Alacrán":
            animal = "4";
            break;
        case "Leon":
            animal = "5";
            break;
        case "Rana":
            animal = "6";
            break;
        case "Perico":
            animal = "7";
            break;
        case "Ratón":
            animal = "8";
            break;
        case "Aguila":
            animal = "9";
            break;
        case "Tigre":
            animal = "10";
            break;
        case "Gato":
            animal = "11";
            break;
        case "Caballo":
            animal = "12";
            break;
        case "Mono":
            animal = "13";
            break;
        case "Paloma":
            animal = "14";
            break;
        case "Zorro":
            animal = "15";
            break;
        case "Oso":
            animal = "16";
            break;
        case "Pavo":
            animal = "17";
            break;
        case "Burro":
            animal = "18";
            break;
        case "Chivo":
            animal = "19";
            break;
        case "Cochino":
            animal = "20";
            break;
        case "Gallo":
            animal = "21";
            break;
        case "Camello":
            animal = "22";
            break;
        case "Cebra":
            animal = "23";
            break;
        case "Iguana":
            animal = "24";
            break;
        case "Gallina":
            animal = "25";
            break;
        case "Vaca":
            animal = "26";
            break;
        case "Perro":
            animal = "27";
            break;
        case "Zamuro":
            animal = "28";
            break;
        case "Elefante":
            animal = "29";
            break;
        case "Caimán":
            animal = "30";
            break;
        case "Lapa":
            animal = "31";
            break;
        case "Ardilla":
            animal = "32";
            break;
        case "Pescado":
            animal = "33";
            break;
        case "Venado":
            animal = "34";
            break;
        case "Jirafa":
            animal = "35";
            break;
        case "Culebra":
            animal = "36";
            break;
    }

    return animal;
}
    
    
    
}
