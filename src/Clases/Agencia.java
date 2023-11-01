
package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Agencia {
    
    
    int id=-1,numTicket, cupoAnimal;
    String serialPC, nombreAgencia,username,password,estado;
    double comision;
    
    ArrayList<Ticket> tickets = new ArrayList();
    String sql;
    PreparedStatement pst;
    ResultSet rs;

    public Agencia() {//Esto es un comentarios para hacer prueba
    }
    
    public Agencia(int id, int numTicket, int cupoAnimal, String serialPC, String nombreAgencia, String nameUsuario, String contraseña, String estado, double comision) {
        this.id = id;
        this.numTicket = numTicket;
        this.cupoAnimal = cupoAnimal;
        this.serialPC = serialPC;
        this.nombreAgencia = nombreAgencia;
        this.username = nameUsuario;
        this.password = contraseña;
        this.estado = estado;
        this.comision = comision;
    }
    
    public Agencia getAgencia(String nameAgencia) {
        Agencia my = new Agencia();

        sql = "call `sp.getAgencia` (?)";
        
        try (Connection con = new ConectarDBCloud("ag").getCon()) {
            con.setCatalog("ag");
           
            pst = con.prepareCall(sql);
            pst.setString(1,nameAgencia);
            
            rs = pst.executeQuery();
            while (rs.next()) {
                    my = new Agencia(rs.getInt("id"),rs.getInt("numTicket"),rs.getInt("cupoAnimal"),rs.getString("serialPc"),rs.getString("nombreAgencia"),
                            rs.getString("username"),rs.getString("pasword"),rs.getString("estado"),rs.getDouble("comision"));
                    System.out.println(my.toString());
            }
        } catch (Exception e) {
            Logger.getLogger(Ticket.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Error con el manejo de base de datos, contacte con el adm.\n" + e);
        } finally {
            cerrar();
        }

        return my;
    }
    
    
     public Agencia getAgenciaByID(int idAgenciax) {
        Agencia my = new Agencia();

        sql = "call `sp.getAgenciaByID` (?)";
        
        try (Connection con = new ConectarDBCloud("ag").getCon()) {
            con.setCatalog("ag");
           
            pst = con.prepareCall(sql);
            pst.setInt(1,idAgenciax);
            
            rs = pst.executeQuery();
            while (rs.next()) {
                    my = new Agencia(rs.getInt("id"),rs.getInt("numTicket"),rs.getInt("cupoAnimal"),rs.getString("serialPc"),rs.getString("nombreAgencia"),
                            rs.getString("username"),rs.getString("pasword"),rs.getString("estado"),rs.getDouble("comision"));
                    System.out.println(my.toString());
            }
        } catch (Exception e) {
            Logger.getLogger(Ticket.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Error con el manejo de base de datos, contacte con el adm.\n" + e);
        } finally {
            cerrar();
        }

        return my;
    }
     
    public ArrayList listarAgencias() {
        ArrayList<Agencia> lista = new ArrayList();

        sql = "call `sp.ListarAgencias` ()";
        
        try (Connection con = new ConectarDBCloud("ag").getCon()) {
            con.setCatalog("ag");
           
            pst = con.prepareCall(sql);
            
            rs = pst.executeQuery();
            while (rs.next()) {
                    lista.add( new Agencia(rs.getInt("id"),rs.getInt("numTicket"),rs.getInt("cupoAnimal"),rs.getString("serialPc"),rs.getString("nombreAgencia"),
                            rs.getString("username"),rs.getString("pasword"),rs.getString("estado"),rs.getDouble("comision")));
            }
        } catch (Exception e) {
            Logger.getLogger(Ticket.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Error con el manejo de base de datos, contacte con el adm.\n" + e);
        } finally {
            cerrar();
        }

        return lista;
    }
     public ArrayList listarAgenciasByGrupero(int idGrupero) {
        ArrayList<Agencia> lista = new ArrayList();

        sql = "call `sp.ListarAgenciasByGrupero` (?)";
        
        try (Connection con = new ConectarDBCloud("ag").getCon()) {
            con.setCatalog("ag");
           
            pst = con.prepareCall(sql);
            pst.setInt(1,idGrupero);
            
            
            rs = pst.executeQuery();
            while (rs.next()) {
                    lista.add( new Agencia(
                            rs.getInt("id"),
                            rs.getInt("numTicket"),
                            rs.getInt("cupoAnimal"),
                            rs.getString("serialPc"),
                            rs.getString("nombreAgencia"),
                            rs.getString("username"),
                            rs.getString("pasword"),
                            rs.getString("estado"),
                            rs.getDouble("comision")
                    ));
            }
        } catch (Exception e) {
            Logger.getLogger(Ticket.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Error con el manejo de base de datos, contacte con el adm.\n" + e);
        } finally {
            cerrar();
        }

        return lista;
    }
     public ArrayList listarAgenciasByBanquero(int idBanquero) {
        ArrayList<Agencia> lista = new ArrayList();

        sql = "call `sp.ListarAgenciasByBanquero` (?)";
        
        try (Connection con = new ConectarDBCloud("ag").getCon()) {
            con.setCatalog("ag");
           
            pst = con.prepareCall(sql);
            pst.setInt(1,idBanquero);
            
            
            rs = pst.executeQuery();
            while (rs.next()) {
                    lista.add( new Agencia(
                            rs.getInt("id"),
                            rs.getInt("numTicket"),
                            rs.getInt("cupoAnimal"),
                            rs.getString("serialPc"),
                            rs.getString("nombreAgencia"),
                            rs.getString("username"),
                            rs.getString("pasword"),
                            rs.getString("estado"),
                            rs.getDouble("comision")
                    ));
            }
        } catch (Exception e) {
            Logger.getLogger(Ticket.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Error con el manejo de base de datos, contacte con el adm.\n" + e);
        } finally {
            cerrar();
        }

        return lista;
    }
    public int insert(String nameAgenciax, String usernamex, String paswordx ,
            String seralPcx, int cupoAnimalx, int comisionx){
        int rsp =0;
        
        try (java.sql.Connection con = new ConectarDBCloud("ag").getCon()) {
            con.setCatalog("ag");
            sql = "call `sp.newAgencia` (?,?,?,?,?,?)";
            pst = con.prepareStatement(sql);
            pst.setString(1,nameAgenciax);
            pst.setString(2,usernamex);
            pst.setString(3,paswordx);
            pst.setString(4,seralPcx);
            pst.setInt(5,cupoAnimalx);
            pst.setInt(6,comisionx);
            
            
        } catch (Exception e) {
            Logger.getLogger(Ticket.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Error con el manejo de base de datos, contacte con el adm.\n" + e);
        } finally {
            cerrar();
        }
        return rsp;
    }
    
    public boolean cambiarEstado(String estado){
        
        try (java.sql.Connection con = new ConectarDBCloud("ag").getCon()) {
            con.setCatalog("ag");
            sql = "call `sp.CambiarEstadoAgencia` (?,?)";
            pst = con.prepareStatement(sql);
            pst.setString(1,estado);
            pst.setInt(2,this.id);
            return pst.executeUpdate()>0?true:false;
            
            
        } catch (Exception e) {
            Logger.getLogger(Ticket.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Error con el manejo de base de datos, contacte con el adm.\n" + e);
            return false;
        } finally {
            cerrar();
        }
    }
    public boolean liberarSerial(){
        
        try (java.sql.Connection con = new ConectarDBCloud("ag").getCon()) {
            con.setCatalog("ag");
            sql = "call `sp.LiberarSerial` (?)";
            pst = con.prepareStatement(sql);
            pst.setInt(1,this.id);
            return pst.executeUpdate()>0?true:false;
            
            
        } catch (Exception e) {
            Logger.getLogger(Ticket.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Error con el manejo de base de datos, contacte con el adm.\n" + e);
            return false;
        } finally {
            cerrar();
        }
    }
    
    public boolean update(){
        int rsp =0;
        
        try (java.sql.Connection con = new ConectarDBCloud("ag").getCon()) {
            con.setCatalog("ag");
            sql = "call `sp.UpdateAgencia` (?,?,?,?,?,?)";
            pst = con.prepareStatement(sql);
            pst.setString(1,this.nombreAgencia);
            pst.setString(2,this.username);
            pst.setString(3,this.password);
            pst.setDouble(4,this.comision);
            pst.setString(5,this.estado);
            pst.setInt(6,this.id);
            
            return pst.executeUpdate() > 0 ? true:false;
        } catch (Exception e) {
            Logger.getLogger(Ticket.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Error con el manejo de base de datos, contacte con el adm.\n" + e);
            return false;
        } finally {
            cerrar();
        }
    }
    
    
     private void cerrar() {
        try {
            if (pst != null) {
                pst.close();
            }
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Agencia.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

   

     public void incrementarTicket(){
         numTicket++;
     }

    @Override
    public String toString() {
        return "Agencia{" + "id=" + id + ", numTicket=" + numTicket + ", cupoAnimal=" + cupoAnimal + ", serialPC=" + serialPC + ", nombreAgencia=" + nombreAgencia + ", username=" + username + ", password=" + password + ", estado=" + estado + ", comision=" + comision + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.id;
        hash = 47 * hash + this.numTicket;
        hash = 47 * hash + this.cupoAnimal;
        hash = 47 * hash + Objects.hashCode(this.serialPC);
        hash = 47 * hash + Objects.hashCode(this.nombreAgencia);
        hash = 47 * hash + Objects.hashCode(this.username);
        hash = 47 * hash + Objects.hashCode(this.password);
        hash = 47 * hash + Objects.hashCode(this.estado);
        hash = 47 * hash + (int) (Double.doubleToLongBits(this.comision) ^ (Double.doubleToLongBits(this.comision) >>> 32));
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
        final Agencia other = (Agencia) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.numTicket != other.numTicket) {
            return false;
        }
        if (this.cupoAnimal != other.cupoAnimal) {
            return false;
        }
        if (Double.doubleToLongBits(this.comision) != Double.doubleToLongBits(other.comision)) {
            return false;
        }
        if (!Objects.equals(this.serialPC, other.serialPC)) {
            return false;
        }
        if (!Objects.equals(this.nombreAgencia, other.nombreAgencia)) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        return Objects.equals(this.estado, other.estado);
    }

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(ArrayList<Ticket> tickets) {
        this.tickets = tickets;
    }
     
     public void addTicket(Ticket t){
         tickets.add(t);
     }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumTicket() {
        return numTicket;
    }

    public void setNumTicket(int numTicket) {
        this.numTicket = numTicket;
    }

    public int getCupoAnimal() {
        return cupoAnimal;
    }

    public void setCupoAnimal(int cupoAnimal) {
        this.cupoAnimal = cupoAnimal;
    }

    public String getNombreAgencia() {
        return nombreAgencia;
    }

    public void setNombreAgencia(String nombreAgencia) {
        this.nombreAgencia = nombreAgencia;
    }

    public String getSerialPC() {
        return serialPC;
    }

    public void setSerialPC(String serialPC) {
        this.serialPC = serialPC;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getComision() {
        return comision;
    }

    public void setComision(double comision) {
        this.comision = comision;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    
    
    
    
    
    
}
