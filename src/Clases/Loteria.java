
package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;





public class Loteria {
    
    
    int  fkGrupoResultado;
    String nombre;
    ArrayList<HoraSorteo> sorteos = new ArrayList();
    
    String sql;
    PreparedStatement pst;
    ResultSet rs;

    public Loteria() {
        
    }

    public Loteria(int fkGrupoResultado, String nombre, ArrayList<HoraSorteo> sorteos) {
        this.fkGrupoResultado = fkGrupoResultado;
        this.nombre = nombre;
        this.sorteos = (ArrayList)sorteos.clone();
    }
    

    
  
     public ArrayList<Loteria> getLoterias(){
        ArrayList<Loteria> lista = new ArrayList();
        ArrayList<HoraSorteo> mySorteos = (ArrayList)new HoraSorteo().getSorteos().clone();
         sql = "call `sp.getLoterias` ()";
        try ( Connection con = new ConectarDBCloud("ag").getCon()) {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                int numGrupo = rs.getInt("fk_grupo_resultado");
                lista.add(new Loteria(
                       numGrupo,
                       rs.getString("nombre"),
                        (ArrayList) mySorteos.stream()
                                .filter(t-> Float.compare(numGrupo,t.getNum_grupo())==0)
                                .collect(Collectors.toList())
                                
                    ));
                
            }
        } catch (Exception e) {
            Logger.getLogger(Loteria.class.getName()).log(Level.SEVERE, null, e);
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
        return lista;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFkGrupoResultado() {
        return fkGrupoResultado;
    }

    public void setFkGrupoResultado(int fkGrupoResultado) {
        this.fkGrupoResultado = fkGrupoResultado;
    }

    @Override
    public String toString() {
        return "Loteria{" + "fkGrupoResultado=" + fkGrupoResultado + ", nombre=" + nombre + '}';
    }

    public ArrayList<HoraSorteo> getSorteos() {
        return sorteos;
    }

    public void setSorteos(ArrayList<HoraSorteo> sorteos) {
        this.sorteos = sorteos;
    }

    
     
     
     
     
     
     
     
     
     
}
