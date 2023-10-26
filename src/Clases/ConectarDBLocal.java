package Clases;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.sql.DataSource;
import javax.swing.JOptionPane;
import org.apache.commons.dbcp2.BasicDataSource;



public class ConectarDBLocal {
     static Connection con = null;

     public static  String url = "jdbc:mysql://mainPC/";//"jdbc:mysql://capsperu.dyndns.org/";
    String user2 ="sp";//"sp";//etc
    String pass2 ="356200";//"devSoft23#";//="123456";
     
     
    
    static BasicDataSource ds = new BasicDataSource();
    static DataSource dataSource;

        public ConectarDBLocal() {
         
    }

    public  ConectarDBLocal(String dataBase) {
        try {
            ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
            ds.setUrl(url + dataBase);
            ds.setUsername(user2);
                ds.setPassword(pass2);
                ds.setUrl(url+dataBase);
            ds.setInitialSize(1);
            ds.setMaxTotal(2);
            ds.setTestWhileIdle(true);
            ds.setTimeBetweenEvictionRunsMillis(10000);
            ds.setValidationQuery("select 1");
        } catch (Exception ex) {
            Logger.getLogger(ConectarDBLocal.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al Conectar con la base de Datos\nPor favor verifique su conexión a internet o contacte al administrador." + ex);
        }
    }

    
    public static void main(String[] args) {
        
         
    }
    public BasicDataSource getDataSource() {
        return ds;
    }

    public static DataSource getDataSourcePROPERTIES() throws FileNotFoundException, IOException, Exception {
        return ds;

    }

    public Connection getCon() {
         try {
             con = getDataSource().getConnection();
             return con;
         } catch (SQLException ex) {
             Logger.getLogger(ConectarDBLocal.class.getName()).log(Level.SEVERE, null, ex);
             return null;
         }
    }

    public static Connection getCon2() throws SQLException, Exception {
        con = getDataSourcePROPERTIES().getConnection();
        return con;
    }

   
public String parsearFecha(String fecha) {
        String formato = "dd/MM/yyyy"; // Definimos el Formato a usar
        String separador = ""; // Separador Vacio
        String fechaFinal = ""; // Fecha Final Vacio
        if (fecha != null) {
            if (fecha.contains("/")) {// si la fecha recibida tiene </>
                separador = Pattern.quote("/"); // el separador a usar es </>
            } else if (fecha.contains("-")) {//pero si el separador de la fecha recibida es <->
                separador = Pattern.quote("-");//se separa la fecha con <->
            }
            String[] parts = fecha.split(separador);//Sabiendo el separador a usar, creamos un String[] con sus valores por separados (yyyy , MM , dd)

            if (parts[0].length() == 4) { // si el primer valor recibido tiene 4 digitos entonces es el valor del Año, por lo que...
                fechaFinal = parts[2] + "/" + parts[1] + "/" + parts[0];// cambiamos la posición de la fecha al preferido
                // System.out.println("Fecha Recibida: "+fnac+"\nFecha Parseada: "+fechaFinal); // se imprime recibido y cambiado
            } else if (parts[0].length() == 2) {
                fechaFinal = parts[0] + "/" + parts[1] + "/" + parts[2];// En este caso si el primer valor recibido tiene 2 digitos
                //System.out.println("Fecha Recibida: "+fnac+"\nFecha Parseada: "+fechaFinal); // no hace falta cambiar la fecha pero lo obligamos y nos aseguramos

            }
           
        }
        return fechaFinal;
    }
    

    public static String getFechaServidor() {
        String fnac = tomarFecha();
        /*
        String formato = "dd/MM/yyyy"; // Definimos el Formato a usar
        String separador = ""; // Separador Vacio
        String fechaFinal = ""; // Fecha Final Vacio
        if (fnac != null) {
            if (fnac.contains("/")) {// si la fecha recibida tiene </>
                separador = Pattern.quote("/"); // el separador a usar es </>
            } else if (fnac.contains("-")) {//pero si el separador de la fecha recibida es <->
                separador = Pattern.quote("-");//se separa la fecha con <->
            }
            String[] parts = fnac.split(separador);//Sabiendo el separador a usar, creamos un String[] con sus valores por separados (yyyy , MM , dd)
            if (parts[0].length() == 4) { // si el primer valor recibido tiene 4 digitos entonces es el valor del Año, por lo que...
                fechaFinal = parts[2] + "/" + parts[1] + "/" + parts[0];// cambiamos la posición de la fecha al preferido
                // System.out.println("Fecha Recibida: "+fnac+"\nFecha Parseada: "+fechaFinal); // se imprime recibido y cambiado
            } else if (parts[0].length() == 2) {
                fechaFinal = parts[0] + "/" + parts[1] + "/" + parts[2];// En este caso si el primer valor recibido tiene 2 digitos
                //System.out.println("Fecha Recibida: "+fnac+"\nFecha Parseada: "+fechaFinal); // no hace falta cambiar la fecha pero lo obligamos y nos aseguramos
            }
        }
        */
        
        
        return fnac;
    }

    public Date getFechaServidorCompleta() {
        String fnac = tomarFecha();

        String separador = ""; // Separador Vacio
        String fechaFinal = ""; // Fecha Final Vacio
        if (fnac != null) {
            if (fnac.contains("/")) {// si la fecha recibida tiene </>
                separador = Pattern.quote("/"); // el separador a usar es </>
            } else if (fnac.contains("-")) {//pero si el separador de la fecha recibida es <->
                separador = Pattern.quote("-");//se separa la fecha con <->
            }
            String[] parts = fnac.split(separador);//Sabiendo el separador a usar, creamos un String[] con sus valores por separados (yyyy , MM , dd)

            if (parts[0].length() == 4) { // si el primer valor recibido tiene 4 digitos entonces es el valor del Año, por lo que...
                fechaFinal = parts[2] + "/" + parts[1] + "/" + parts[0];// cambiamos la posición de la fecha al preferido
                // System.out.println("Fecha Recibida: "+fnac+"\nFecha Parseada: "+fechaFinal); // se imprime recibido y cambiado
            } else if (parts[0].length() == 2) {
                fechaFinal = parts[0] + "/" + parts[1] + "/" + parts[2];// En este caso si el primer valor recibido tiene 2 digitos
                //System.out.println("Fecha Recibida: "+fnac+"\nFecha Parseada: "+fechaFinal); // no hace falta cambiar la fecha pero lo obligamos y nos aseguramos
            }

        }

        String formato = "yyyy/MM/dd"; // Definimos el Formato a usar
        Date temp = new Date();
        try {
            temp = new SimpleDateFormat(formato).parse(fechaFinal);
        } catch (ParseException ex) {
            Logger.getLogger(ConectarDBLocal.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex);
        }
        
        
        return temp;
    }

    private static String tomarFecha() {
        String fecha = "";
        try (Connection conex = new ConectarDBLocal("ag").getCon()) {
            String sql = "select replace(CURDATE(),'/','-') as a";
            PreparedStatement s = conex.prepareStatement(sql);
            ResultSet rs = s.executeQuery();
            while (rs.next()) {
                fecha = rs.getString("a");
            }
            try {
                if (s != null) {
                    s.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ConectarDBLocal.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            Logger.getLogger(ConectarDBLocal.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e);
        }

        return fecha;
    }

    public int Desconectar() {
        int a = 0;
        try {
            con.close();
            a = 1;
        } catch (SQLException ex) {
            Logger.getLogger(ConectarDBLocal.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex, null, 0);
            a = 0;
        }
        return a;
    }
}
