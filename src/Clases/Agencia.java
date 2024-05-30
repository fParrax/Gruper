package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Agencia {

    int id = -1, minutosCierre, numTicket, cupoAnimal, jugadaMinima;
    String serialPC, nombreAgencia, username, password, estado;
    double comision;
    ArrayList<Ticket> tickets = new ArrayList();
    ArrayList<CupoAgencia> cupos = new ArrayList();
    
    String sql;
    PreparedStatement pst;
    ResultSet rs;

    public Agencia() {//Esto es un comentarios para hacer prueba
    }

    public Agencia(int id, int numTicket, int minutosCierre, int jugadaMinima, int cupoAnimal, String serialPC, String nombreAgencia, String nameUsuario, String contraseña, String estado, double comision) {
        this.id = id;
        this.numTicket = numTicket;
        this.minutosCierre = minutosCierre;
        this.jugadaMinima = jugadaMinima;
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
            pst.setString(1, nameAgencia);

            rs = pst.executeQuery();
            while (rs.next()) {
                my = new Agencia(
                        rs.getInt("id"),
                        rs.getInt("numTicket"),
                        rs.getInt("minutos_cierre"),
                        rs.getInt("jugadaMinima"),
                        rs.getInt("cupoAnimal"),
                        rs.getString("serialPc"),
                        rs.getString("nombreAgencia"),
                        rs.getString("username"),
                        rs.getString("pasword"),
                        rs.getString("estado"),
                        rs.getDouble("comision")
                );
            }
        } catch (Exception e) {
            Logger.getLogger(Ticket.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Error con el manejo de base de datos, contacte con el adm.\n" + e);
        } finally {
            cerrar();
        }

        return my;
    }

    public boolean haveCuposIngresados(String dia) {
        int rsp = 0;
        try (java.sql.Connection con = new ConectarDBCloud("ag").getCon()) {
            sql = "call `sp.getCuposFromDay` (?)";
            pst = con.prepareStatement(sql);
            pst.setString(1, dia);
            rs = pst.executeQuery();
            while (rs.next()) {
                rsp = rs.getInt("cantidad");
            }

        } catch (Exception e) {
            Logger.getLogger(Agencia.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Error con el manejo de base de datos, contacte con el adm.\n" + e);
        } finally {
            cerrar();
        }
        return rsp == 0 ? false : true;
    }
    
    public boolean update(){
        int rsp =0;
        
        try (java.sql.Connection con = new ConectarDBCloud("ag").getCon()) {
            con.setCatalog("ag");
            sql = "call `sp.UpdateAgencia` (?,?,?,?,?,?,?,?)";
            pst = con.prepareStatement(sql);
            pst.setString(1,this.nombreAgencia);
            pst.setString(2,this.username);
            pst.setString(3,this.password);
            pst.setDouble(4,this.comision);
            pst.setString(5,this.estado);
            pst.setInt(6,this.id);
            pst.setInt(7,this.minutosCierre);
            pst.setInt(8,this.jugadaMinima);
            
            return pst.executeUpdate() > 0 ? true:false;
        } catch (Exception e) {
            Logger.getLogger(Ticket.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Error con el manejo de base de datos, contacte con el adm.\n" + e);
            return false;
        } finally {
            cerrar();
        }
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
    
    public boolean updateCupoPermanente(double cupo){
        try (java.sql.Connection con = new ConectarDBCloud("ag").getCon()) {
            sql = "call `sp.UpdateCupoPermanente` (?,?)";
            pst = con.prepareStatement(sql);
            pst.setDouble(1,cupo);
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
    
    public boolean crearCupos() {
        int rsp = 0;
        try (java.sql.Connection con = new ConectarDBCloud("ag").getCon()) {
            sql = "call `sp.CrearCupos` ()";
            pst = con.prepareStatement(sql);
            rsp = pst.executeUpdate();

        } catch (Exception e) {
            Logger.getLogger(Agencia.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Error con el manejo de base de datos, contacte con el adm.\n" + e);
        } finally {
            cerrar();
        }
        return rsp < 1 ? false : true;
    }

    public int insert(String nameAgenciax, String usernamex, String paswordx,
            String seralPcx, int cupoAnimalx, int comisionx) {
        int rsp = 0;

        try (java.sql.Connection con = new ConectarDBCloud("ag").getCon()) {

            sql = "call `sp.newAgencia` (?,?,?,?,?,?)";
            pst = con.prepareStatement(sql);
            pst.setString(1, nameAgenciax);
            pst.setString(2, usernamex);
            pst.setString(3, paswordx);
            pst.setString(4, seralPcx);
            pst.setInt(5, cupoAnimalx);
            pst.setInt(6, comisionx);

        } catch (Exception e) {
            Logger.getLogger(Ticket.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Error con el manejo de base de datos, contacte con el adm.\n" + e);
        } finally {
            cerrar();
        }
        return rsp;
    }

    public int incrementarNumTicketLocal() {
        return numTicket++;
    }

    public boolean upSerial(String serialx, int idAgenciax) {
        try (java.sql.Connection con = new ConectarDBCloud("ag").getCon()) {
            sql = "call `sp.UpSerial` (?,?)";
            pst = con.prepareStatement(sql);
            pst.setString(1, serialx);
            pst.setInt(2, idAgenciax);
            pst.executeUpdate();
            return true;
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

    public int getJugadaMinima() {
        return jugadaMinima;
    }

    public ArrayList listarAgenciasByBanquero(int idBanquero) {
        ArrayList<Agencia> lista = new ArrayList();

        sql = "call `sp.ListarAgenciasByBanquero` (?)";

        try (Connection con = new ConectarDBCloud("ag").getCon()) {
            con.setCatalog("ag");

            pst = con.prepareCall(sql);
            pst.setInt(1, idBanquero);

            rs = pst.executeQuery();
            while (rs.next()) {
                lista.add(new Agencia(
                        rs.getInt("id"),
                        rs.getInt("numTicket"),
                        rs.getInt("minutos_cierre"),
                        rs.getInt("jugadaMinima"),
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

    public void setJugadaMinima(int jugadaMinima) {
        this.jugadaMinima = jugadaMinima;
    }

    public ArrayList listarAgencias() {
        ArrayList<Agencia> lista = new ArrayList();

        sql = "call `sp.ListarAgencias` ()";

        try (Connection con = new ConectarDBCloud("ag").getCon()) {
            con.setCatalog("ag");

            pst = con.prepareCall(sql);
            rs = pst.executeQuery();
            Agencia temp = new Agencia();
            while (rs.next()) {
                temp = new Agencia(
                        rs.getInt("id"),
                        rs.getInt("numTicket"),
                        rs.getInt("minutos_cierre"),
                        rs.getInt("jugadaMinima"),
                        rs.getInt("cupoAnimal"),
                        rs.getString("serialPc"),
                        rs.getString("nombreAgencia"),
                        rs.getString("username"),
                        rs.getString("pasword"),
                        rs.getString("estado"),
                        rs.getDouble("comision")
                );
                if (!lista.contains(temp)) {
                    lista.add(temp);
                }
            }
        } catch (Exception e) {
            Logger.getLogger(Ticket.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Error con el manejo de base de datos, contacte con el adm.\n" + e);
        } finally {
            cerrar();
        }

        return lista;
    }

    @Override
    public String toString() {
        return "Agencia{" + "id=" + id + ", numTicket=" + minutosCierre + ", cupoAnimal=" + cupoAnimal + ", serialPC=" + serialPC + ", nombreAgencia=" + nombreAgencia + ", username=" + username + ", password=" + password + ", estado=" + estado + ", comision=" + comision + '}';
    }

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(ArrayList<Ticket> tickets) {
        this.tickets = tickets;
    }

    public int getNumTicket() {
        return numTicket;
    }

    public void setNumTicket(int numTicket) {
        this.numTicket = numTicket;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMinutosCierre() {
        return minutosCierre;
    }

    public void addTicket(Ticket t) {
        tickets.add(t);
    }

    public void setMinutosCierre(int minutosCierre) {
        this.minutosCierre = minutosCierre;
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
        return serialPC == null ? "" : serialPC;
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

    public ArrayList<CupoAgencia> getCupos() {
        return cupos;
    }

    public void setCupos(ArrayList<CupoAgencia> cupos) {
        this.cupos = cupos;
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
