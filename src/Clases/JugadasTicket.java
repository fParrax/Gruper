
package Clases;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Objects;
import java.util.regex.Pattern;


public class JugadasTicket {
    
    int id=0,idTicket=0;
    String fecha,sorteo,animal,programa;
    float monto;
    String estado;
    
    String sql;
    PreparedStatement pst;
    ResultSet rs;

    public JugadasTicket() {
    }

    public JugadasTicket(int id, int idTicket,String programa,String fecha, String sorteo, String animal, float monto, String estado) {
        this.id = id;
        this.idTicket = idTicket;
        this.programa=programa;
        this.fecha=fecha;
        this.sorteo = sorteo;
        this.animal = animal;
        this.monto = monto;
        this.estado = estado;
    }

   
    
    @Override
    public int hashCode() {
        return Objects.hash(id, idTicket,programa, fecha,  sorteo,  animal,  monto,  estado);
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

        JugadasTicket jt = (JugadasTicket) obj;

        return Float.compare(id, jt.id) == 0 && Float.compare(idTicket, jt.idTicket) == 0 &&
                fecha.equals(jt.fecha) && sorteo.equals(jt.sorteo) && animal.equals(jt.animal) &&
                Float.compare(monto, jt.monto) == 0 && estado.equals(jt.estado) && programa.equals(jt.programa);
    }

    @Override
    public String toString() {
        return "JugadasTicket{" + "id=" + id + ", idTicket=" + idTicket + ", fecha=" + fecha + ", sorteo=" + sorteo + ", animal=" + animal + ", programa=" + programa + ", monto=" + monto + ", estado=" + estado + '}';
    }
    
    
    public int getHoradelSorteo(){
        int rsp=0;
        String separador = Pattern.quote(" ");
        String [] horaArray = sorteo.split(separador);
                int temp = Integer.parseInt(horaArray[1]);
                
                rsp = temp==1 //&& horaArray[2].equalsIgnoreCase("pm")
                    ?  13 
                    : temp==2 //&& horaArray[2].equalsIgnoreCase("pm")
                    ?  14
                    : temp==3 //&& horaArray[2].equalsIgnoreCase("pm")
                    ?  15
                    : temp==4 //&& horaArray[2].equalsIgnoreCase("pm")
                    ?  16
                    : temp==5 //&& horaArray[2].equalsIgnoreCase("pm")
                    ?  17
                    : temp==6 //&& horaArray[2].equalsIgnoreCase("pm")
                    ?  18
                    : temp==7 //&& horaArray[2].equalsIgnoreCase("pm")
                    ?  19
                    : temp ;
            
                
        
        return rsp;
    }
     public int getHoradelSorteo(String hora){
        int rsp=0;
                int temp = Integer.parseInt(hora);
                
                rsp = temp==1 //&& horaArray[2].equalsIgnoreCase("pm")
                    ?  13 
                    : temp==2 //&& horaArray[2].equalsIgnoreCase("pm")
                    ?  14
                    : temp==3 //&& horaArray[2].equalsIgnoreCase("pm")
                    ?  15
                    : temp==4 //&& horaArray[2].equalsIgnoreCase("pm")
                    ?  16
                    : temp==5 //&& horaArray[2].equalsIgnoreCase("pm")
                    ?  17
                    : temp==6 //&& horaArray[2].equalsIgnoreCase("pm")
                    ?  18
                    : temp==7 //&& horaArray[2].equalsIgnoreCase("pm")
                    ?  19
                    : temp ;
            
                
        
        return rsp;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getSorteo() {
        return sorteo;
    }

    public void setSorteo(String sorteo) {
        this.sorteo = sorteo;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public String getEstado() {
        return estado;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
}
