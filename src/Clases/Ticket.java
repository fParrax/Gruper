package Clases;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.json.JSONArray;
import org.json.JSONObject;

public class Ticket {

    int id = 0 ,numTicket;
    String fecha,  serial, estado,agencia;
    float totalJugado = 0, totalPremio = 0, montoPagado = 0;
    String sql;
    PreparedStatement pst;
    ResultSet rs;
    ArrayList<JugadasTicket> jugadas = new ArrayList();

    public Ticket() {
    }

    public Ticket(int id, String fecha,String agencia,String serial,int numTicket, String estado, float totalJugado, float totalPremio, float montoPagado) {
        this.id = id;
        this.fecha = fecha;
        this.agencia=agencia;
        this.serial = serial;
        this.numTicket=numTicket;
        this.estado = estado;
        this.totalJugado = totalJugado;
        this.totalPremio = totalPremio;
        this.montoPagado = montoPagado;
    }

    public ArrayList getTicketsByAgencia(int idAgencia, String fecha01, String fecha02) {
        ArrayList<Ticket> lista = new ArrayList();

        sql = "call `sp.getTicket` (?,?,?)";
        try (java.sql.Connection con = new ConectarDBCloud("ag").getCon()) {
            con.setCatalog("ag");
            pst = con.prepareCall(sql);
            pst.setInt(1,idAgencia);
            pst.setString(2,fecha01+" 00:00:01");
            pst.setString(3,fecha02+" 23:59:59");
            rs = pst.executeQuery();
            
            while (rs.next()) {
                Ticket temp = new Ticket(rs.getInt("id"),rs.getString("fecha"),rs.getString("agencia"),
                rs.getString("serialTicket"),rs.getInt("numTicket"),rs.getString("estado"),rs.getFloat("totalJugado"),
                rs.getFloat("totalPremio"),rs.getFloat("montoPagado"));
                
                JugadasTicket j = new JugadasTicket(rs.getInt("idJugada"),rs.getInt("idTicket"),
                rs.getString("programa"),rs.getString("fechaJugada"),rs.getString("sorteo"),
                rs.getString("animal"),rs.getFloat("montoJugada"),rs.getString("estadoJugada"));
                
                if(!lista.contains(temp)){
                     temp.addJugada(j);
                     lista.add(temp); 
                }else{
                    int index = lista.indexOf(temp);
                    
                    if(!lista.get(index).getJugadas().contains(j)){
                        lista.get(index).addJugada(j);
                    }
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
    public ArrayList getTicketsByBanquero(int idBanquero, String fecha01, String fecha02) {
        ArrayList<Agencia> lista = new ArrayList();

        sql = "call `sp.getTicketByBanquero` (?,?,?)";
        try (java.sql.Connection con = new ConectarDBCloud("ag").getCon()) {
            con.setCatalog("ag");
            pst = con.prepareCall(sql);
            pst.setInt(1,idBanquero);
            pst.setString(2,fecha01+" 00:00:01");
            pst.setString(3,fecha02+" 23:59:59");
            rs = pst.executeQuery();
            
            while (rs.next()) {
                
                Agencia agenciaTemp = new Agencia(
                        rs.getInt("myIdAgencia"),
                        rs.getInt("myNumTicket"),
                        rs.getInt("cupoAnimal"),
                        rs.getString("serialPc"),
                        rs.getString("nombreAgencia"),
                            rs.getString("username"),
                        rs.getString("pasword"),
                        rs.getString("myEstado"),
                        rs.getDouble("comision")
                );
                
                Ticket ticketTemp = new Ticket(
                        rs.getInt("id"),
                        rs.getString("fecha"),
                        rs.getString("agencia"),
                        rs.getString("serialTicket"),
                        rs.getInt("numTicket"),
                        rs.getString("estado"),
                        rs.getFloat("totalJugado"),
                        rs.getFloat("totalPremio"),
                        rs.getFloat("montoPagado")
                );
                
                JugadasTicket jugadaTemp = new JugadasTicket(
                        rs.getInt("idJugada"),
                        rs.getInt("idTicket"),
                        rs.getString("programa"),
                        rs.getString("fechaJugada"),
                        rs.getString("sorteo"),
                        rs.getString("animal"),
                        rs.getFloat("montoJugada"),
                        rs.getString("estadoJugada")
                );
                
                
                if(!lista.contains(agenciaTemp)){
                    ticketTemp.addJugada(jugadaTemp);
                    agenciaTemp.addTicket(ticketTemp);
                    lista.add(agenciaTemp);
                }else{
                    int indexAgencia = lista.indexOf(agenciaTemp);
                    if(!lista.get(indexAgencia).getTickets().contains(ticketTemp)){
                        ticketTemp.addJugada(jugadaTemp);
                        lista.get(indexAgencia).addTicket(ticketTemp);
                    }else{
                        int indexTicket = lista.get(indexAgencia).getTickets().indexOf(ticketTemp);
                        lista.get(indexAgencia).getTickets().get(indexTicket).addJugada(jugadaTemp);
                    }
                }
                /*
                if(!lista.contains()){
                     ticketTemp.addJugada(jugadaTemp);
                     lista.add(ticketTemp); 
                }else{
                    int index = lista.indexOf(ticketTemp);
                    
                    if(!lista.get(index).getJugadas().contains(jugadaTemp)){
                        lista.get(index).addJugada(jugadaTemp);
                    }
                }
                */
                
               
                
            }
        } catch (Exception e) {
            Logger.getLogger(Ticket.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Error con el manejo de base de datos, contacte con el adm.\n" + e);
        } finally {
            cerrar();
        }

        return lista;
    }

    public Ticket getTicketBySerial(String serialx) {
        Ticket my = new Ticket();

        sql = "call `sp.getTicketBySerial` (?)";
        
        try (java.sql.Connection con = new ConectarDBCloud("ag").getCon()) {
            con.setCatalog("ag");
            pst = con.prepareStatement(sql);
            pst.setString(1,serialx);
            
            rs = pst.executeQuery();
            while (rs.next()) {
                    my = new Ticket(rs.getInt("id"),rs.getString("fecha"),rs.getString("agencia"),
                rs.getString("serial"),rs.getInt("numTicket"),rs.getString("estado"),rs.getFloat("totalJugado"),
                rs.getFloat("totalPremio"),rs.getFloat("montoPagado"));

                    JugadasTicket jugada = new JugadasTicket(rs.getInt("idJugada"),rs.getInt("idTicket"),
                rs.getString("programa"),rs.getString("fechaJugada"),rs.getString("sorteo"),
                rs.getString("animal"),rs.getFloat("montoJugada"),rs.getString("estadoJugada"));
                
                if(!my.getJugadas().contains(jugada)){
                    my.addJugada(jugada);
                }
            }
        } catch (Exception e) {
            Logger.getLogger(Ticket.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Error con el manejo de base de datos, contacte con el adm.\n" + e);
        } finally {
            cerrar();
        }

        return my;
    }

    public Ticket getTicketByNum(int idAgencia,String fecha01, int numTicketx) {
        Ticket my = new Ticket();

        sql = "call `sp.getTicketbyNum` (?,?,?)";
        
        try (java.sql.Connection con = new ConectarDBCloud("ag").getCon()) {
            pst = con.prepareStatement(sql);
            pst.setInt(1,idAgencia);
            pst.setString(2,fecha01);
            pst.setInt(3,numTicketx);
            
            rs = pst.executeQuery();
            while (rs.next()) {
                    my = new Ticket(rs.getInt("id"),rs.getString("fecha"),rs.getString("agencia"),
                rs.getString("serial"),rs.getInt("numTicket"),rs.getString("estado"),rs.getFloat("totalJugado"),
                rs.getFloat("totalPremio"),rs.getFloat("montoPagado"));
            }
        } catch (Exception e) {
            Logger.getLogger(Ticket.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Error con el manejo de base de datos, contacte con el adm.\n" + e);
        } finally {
            cerrar();
        }

        return my;
    }

    public String insert(int numTicketx,String agenciax,double totalJugadox, ArrayList jugadax) {
        String serialTicket = "error";

        
        
        sql = " call `sp.insertTicket` (?,?,?,?)";
        try (java.sql.Connection con = new ConectarDBCloud("ag").getCon()) {
            con.setCatalog("ag");
            pst = con.prepareCall(sql);
            pst.setInt(1, numTicketx);
            pst.setString(2, agenciax);
            pst.setDouble(3, totalJugadox);
            pst.setString(4, convertJugadasToJSON(jugadax));
            rs = pst.executeQuery();
            while(rs.next()){
                serialTicket = rs.getString("serial");
            }
            
            //rstl = pst.executeUpdate();
            
        } catch (Exception e) {
            Logger.getLogger(Ticket.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Error con el manejo de base de datos, contacte con el adm.\n" + e);
        } finally {
            cerrar();
        }
        return serialTicket;
    }
    
    public int pagar(int idJugadax){
        int rsp=0;//pagarJugada
        try (java.sql.Connection con = new ConectarDBCloud("ag").getCon()) {
            sql = "call `sp.pagarJugada` (?)";
            pst = con.prepareCall(sql);
            pst.setInt(1, idJugadax);
            rsp = pst.executeUpdate();
        } catch (Exception e) {
            Logger.getLogger(Ticket.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Error con el manejo de base de datos, contacte con el adm.\n" + e);
        } finally {
            cerrar();
        }
        
        return rsp;
    }
    
    public int anular(int idTicketx) {
     int rsp=0;   
     try (java.sql.Connection con = new ConectarDBCloud("ag").getCon()) {
         con.setCatalog("ag");
            sql = "call `sp.anularTicket` (?)";
            pst = con.prepareCall(sql);
            pst.setInt(1, idTicketx);
            rsp = pst.executeUpdate();
     
     } catch (Exception e) {
            Logger.getLogger(Ticket.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Error con el manejo de base de datos, contacte con el adm.\n" + e);
        } finally {
            cerrar();
        }
     return rsp;
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
            Logger.getLogger(Ticket.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public String toString() {
        return "Ticket{" + "id=" + id + ", numTicket=" + numTicket + ", fecha=" + fecha + ", horaTicket=" + ", serial=" + serial + ", estado=" + estado + ", totalJugado=" + totalJugado + ", totalPremio=" + totalPremio + ", montoPagado=" + montoPagado + '}';
    }

    
    @Override
    public int hashCode() {
        return Objects.hash(id, fecha,agencia,serial,numTicket, estado, totalJugado, totalPremio, montoPagado );
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
        final Ticket other = (Ticket) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.numTicket != other.numTicket) {
            return false;
        }
        if (Float.floatToIntBits(this.totalJugado) != Float.floatToIntBits(other.totalJugado)) {
            return false;
        }
        if (Float.floatToIntBits(this.totalPremio) != Float.floatToIntBits(other.totalPremio)) {
            return false;
        }
        if (Float.floatToIntBits(this.montoPagado) != Float.floatToIntBits(other.montoPagado)) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        if (!Objects.equals(this.serial, other.serial)) {
            return false;
        }
        if (!Objects.equals(this.estado, other.estado)) {
            return false;
        }
        return Objects.equals(this.agencia, other.agencia);
    }
    
    
    private String convertJugadasToJSON(){
        JSONArray jsonArray = new JSONArray();
        JSONObject json = new JSONObject();
        for(JugadasTicket j : jugadas){
            json.put("id", j.getId());
            json.put("idTicket", j.getId());
            json.put("programa", j.getId());
            json.put("fecha", j.getId());
            json.put("sorteo", j.getId());
            json.put("animal", j.getId());
            json.put("monto", j.getId());
            json.put("estado", j.getId());
        }
        
        return jsonArray.toString();
}
    
    private String convertJugadasToJSON(ArrayList<JugadasTicket> jugadas){
        JSONArray jsonArray = new JSONArray();
        
        for(JugadasTicket j : jugadas){
            JSONObject json = new JSONObject();
            json.put("programa", j.getPrograma());
            json.put("sorteo", j.getSorteo());
            json.put("animal", j.getAnimal());
            json.put("monto", j.getMonto());
            
            jsonArray.put(json);
        }
       
        
        return jsonArray.toString();
}
    
    public double getMontoPagado() {
        return montoPagado;
    }

    public void setMontoPagado(float montoPagado) {
        this.montoPagado = montoPagado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public double getTotalJugado() {
        return totalJugado;
    }

    public void setTotalJugado(float totalJugado) {
        this.totalJugado = totalJugado;
    }

    public double getTotalPremio() {
        return totalPremio;
    }

    public void setTotalPremio(float totalPremio) {
        this.totalPremio = totalPremio;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }


    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getEstado() {
        return estado;
    }

    public int getNumTicket() {
        return numTicket;
    }

    public void setNumTicket(int numTicket) {
        this.numTicket = numTicket;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public ArrayList<JugadasTicket> getJugadas() {
        return jugadas;
    }

    public void setJugadas(ArrayList<JugadasTicket> jugadas) {
        this.jugadas = jugadas;
    }

    public void addJugada(JugadasTicket jugada) {
        jugadas.add(jugada);
    }

}
