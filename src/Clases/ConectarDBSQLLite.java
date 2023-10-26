package Clases;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import javax.swing.JOptionPane;
import org.apache.commons.dbcp2.BasicDataSource;



public class ConectarDBSQLLite {
    
     static Connection con = null;

     //public static  String url = System.getProperty("user.dir") + "\\config.db";
     private static  String url = "jdbc:sqlite:config.db";
    
    static BasicDataSource ds = null;
    static DataSource dataSource;


    public  ConectarDBSQLLite() {
        try {
            if(ds==null){
            ds = new BasicDataSource();
            ds.setDriverClassName("org.sqlite.JDBC");
            ds.setUrl(url);
            ds.setInitialSize(1);
            ds.setMaxTotal(2);
            ds.setTestWhileIdle(true);
            ds.setTimeBetweenEvictionRunsMillis(10000);
            ds.setValidationQuery("select 1");
            }
            
        } catch (Exception ex) {
            Logger.getLogger(ConectarDBSQLLite.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al Conectar con la base de Datos\nPor favor verifique su conexión a internet o contacte al administrador." + ex);
        }
    }
    
   
    private BasicDataSource getDataSource() {
        return ds;
    }
   

    public Connection getCon() {
         try {
             return getDataSource().getConnection();
         } catch (SQLException ex) {
             Logger.getLogger(ConectarDBSQLLite.class.getName()).log(Level.SEVERE, null, ex);
             return null;
         }
    }

    public int Desconectar() {
        try {
            con.close();
            return  1;
        } catch (SQLException ex) {
            Logger.getLogger(ConectarDBSQLLite.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex, null, 0);
           return  0;
        }
    }
}
