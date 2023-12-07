
package Clases;

import java.net.InetAddress;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;





public class CupoAgencia {
    
    
    int idcupo,idAgencia;
    String tipoCupo,fechaInicio,fechaFin,estadoCupo,programas,sorteos,animales;
    double monto;
    
    String sql;
    PreparedStatement pst;
    ResultSet rs;

    public CupoAgencia() {
        
    }

    

    public CupoAgencia(int idcupo, int idAgencia, String tipoCupo,String programas, String sorteos,String animales,double monto, String fechaInicio, String fechaFin, String estadoCupo) {
        this.idcupo = idcupo;
        this.idAgencia = idAgencia;
        this.tipoCupo = tipoCupo;
        this.programas=programas;
        this.sorteos=sorteos;
        this.animales=animales;
        this.monto=monto;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estadoCupo = estadoCupo;
    }
    
    public static void main(String[] args) {
        new Thread(()->{
            while (true) {
           
             try{
            InetAddress address = InetAddress.getByName("capsperu.dyndns.org");
            boolean reachable = address.isReachable(1000);

            System.out.println("Is host reachable? " + reachable);
        } catch (Exception e){
            e.printStackTrace();
        }
                
                
                
            }
        }).start();
    }
    
    public boolean insertCupo(
            int idAgencia,
            String tipo,
            double monto,
            String desde,
            String hasta,
            String programasx,
            String sorteosx,
            String animalesx
    ){
        sql = "call `sp.insertCupo` (?,?,?,?,?,?,?,?)";
        try ( Connection con = new ConectarDBCloud("ag").getCon()) {
            pst = con.prepareStatement(sql);
            pst.setInt(1, idAgencia);
            pst.setString(2, tipo);
            pst.setDouble(3, monto);
            pst.setString(4, desde);
            pst.setString(5, hasta);
            pst.setString(6, programasx);
            pst.setString(7, sorteosx);
            pst.setString(8, animalesx);
           
            return pst.executeUpdate() > 0 ? true : false;
            
            
        } catch (Exception e) {
            Logger.getLogger(CupoAgencia.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e);
            return false;
        } finally {
            try {
                pst.close();
            } catch (SQLException ex) {
                Logger.getLogger(CupoAnimal.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }
    
    public ArrayList getCupos(int idAgencia){
        ArrayList<CupoAgencia> busqueda = new ArrayList();
        
        sql = "call `sp.getCupoAgencia` (?)";
        try ( Connection con = new ConectarDBCloud("ag").getCon()) {
            con.setCatalog("ag");
            pst = con.prepareStatement(sql);
            pst.setInt(1, idAgencia);
           
            rs = pst.executeQuery();
            while(rs.next()){
                busqueda.add(new CupoAgencia(
                        rs.getInt("idCupo"),
                        rs.getInt("idAgencia"),
                        rs.getString("tipoCupo"),
                        rs.getString("programas"),
                        rs.getString("sorteos"),
                        rs.getString("animales"),
                        rs.getDouble("monto"),
                        rs.getString("fechaInicio"),
                        rs.getString("fechaFin"),
                        rs.getString("estadoCUpo")
                      
                ));
            }
            
            
        } catch (Exception e) {
            Logger.getLogger(CupoAgencia.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                pst.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(CupoAnimal.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, ex);
            }
        }
        return busqueda;
    }
    
    
     public boolean deleteCupoTemporal(
            int idAgencia
    ){
        sql = "call `sp.EliminarCupoTemporal` (?)";
        try ( Connection con = new ConectarDBCloud("ag").getCon()) {
            con.setCatalog("ag");
            pst = con.prepareStatement(sql);
            pst.setInt(1, idAgencia);
           
            return pst.executeUpdate() > 0 ? true : false;
            
        } catch (Exception e) {
            Logger.getLogger(CupoAgencia.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e);
            return false;
        } finally {
            try {
                pst.close();
            } catch (SQLException ex) {
                Logger.getLogger(CupoAnimal.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }

    @Override
    public String toString() {
        return "CupoAgencia{" + "idcupo=" + idcupo + ", idAgencia=" + idAgencia + ", tipoCupo=" + tipoCupo + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", estadoCupo=" + estadoCupo + ", programas=" + programas + ", sorteos=" + sorteos + ", animales=" + animales + ", monto=" + monto + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.idcupo;
        hash = 97 * hash + this.idAgencia;
        hash = 97 * hash + Objects.hashCode(this.tipoCupo);
        hash = 97 * hash + Objects.hashCode(this.fechaInicio);
        hash = 97 * hash + Objects.hashCode(this.fechaFin);
        hash = 97 * hash + Objects.hashCode(this.estadoCupo);
        hash = 97 * hash + Objects.hashCode(this.programas);
        hash = 97 * hash + Objects.hashCode(this.sorteos);
        hash = 97 * hash + Objects.hashCode(this.animales);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.monto) ^ (Double.doubleToLongBits(this.monto) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CupoAgencia other = (CupoAgencia) obj;
        if (this.idcupo != other.idcupo) {
            return false;
        }
        if (this.idAgencia != other.idAgencia) {
            return false;
        }
        if (Double.doubleToLongBits(this.monto) != Double.doubleToLongBits(other.monto)) {
            return false;
        }
        if (!Objects.equals(this.tipoCupo, other.tipoCupo)) {
            return false;
        }
        if (!Objects.equals(this.fechaInicio, other.fechaInicio)) {
            return false;
        }
        if (!Objects.equals(this.fechaFin, other.fechaFin)) {
            return false;
        }
        if (!Objects.equals(this.estadoCupo, other.estadoCupo)) {
            return false;
        }
        if (!Objects.equals(this.programas, other.programas)) {
            return false;
        }
        if (!Objects.equals(this.sorteos, other.sorteos)) {
            return false;
        }
        return Objects.equals(this.animales, other.animales);
    }

     
     
     
     
     
     
     
     
     
    public String getProgramas() {
        return programas;
    }

    public void setProgramas(String programas) {
        this.programas = programas;
    }

    public String getSorteos() {
        return sorteos;
    }

    public void setSorteos(String sorteos) {
        this.sorteos = sorteos;
    }

    public String getAnimales() {
        return animales;
    }

    public void setAnimales(String animales) {
        this.animales = animales;
    }

    
    public int getIdcupo() {
        return idcupo;
    }

    public void setIdcupo(int idcupo) {
        this.idcupo = idcupo;
    }

    public int getIdAgencia() {
        return idAgencia;
    }

    public void setIdAgencia(int idAgencia) {
        this.idAgencia = idAgencia;
    }

    public String getTipoCupo() {
        return tipoCupo;
    }

    public void setTipoCupo(String tipoCupo) {
        this.tipoCupo = tipoCupo;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getEstadoCupo() {
        return estadoCupo;
    }

    public void setEstadoCupo(String estadoCupo) {
        this.estadoCupo = estadoCupo;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
    
     
     
     
}
