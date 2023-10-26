package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CupoAnimal {

    int id = -1;
    String fecha, programa, sorteo,animalVendido;
    double maximo, animal_0, animal_00,
            animal_1, animal_2, animal_3, animal_4, animal_5, animal_6, animal_7, animal_8, animal_9, animal_10,
            animal_11, animal_12, animal_13, animal_14, animal_15, animal_16, animal_17, animal_18, animal_19, animal_20,
            animal_21, animal_22, animal_23, animal_24, animal_25, animal_26, animal_27, animal_28, animal_29, animal_30,
            animal_31, animal_32, animal_33, animal_34, animal_35, animal_36,montoVendido;
    PreparedStatement pst;
    ResultSet rs;

    public CupoAnimal() {
    }
    public CupoAnimal(String programa,String sorteo,String fecha,String animalVendido,double montoVendido){
        this.programa=programa;
        this.sorteo=sorteo;
        this.fecha=fecha;
        this.animalVendido=animalVendido;
        this.montoVendido=montoVendido;
    }

    public CupoAnimal(int id, String fecha, String programa, String sorteo, double maximo, double animal_0, double animal_00, double animal_1, double animal_2, double animal_3, double animal_4, double animal_5, double animal_6, double animal_7, double animal_8, double animal_9, double animal_10, double animal_11, double animal_12, double animal_13, double animal_14, double animal_15, double animal_16, double animal_17, double animal_18, double animal_19, double animal_20, double animal_21, double animal_22, double animal_23, double animal_24, double animal_25, double animal_26, double animal_27, double animal_28, double animal_29, double animal_30, double animal_31, double animal_32, double animal_33, double animal_34, double animal_35, double animal_36) {
        this.id = id;
        this.fecha = fecha;
        this.programa = programa;
        this.sorteo = sorteo;
        this.maximo = maximo;
        this.animal_0 = animal_0;
        this.animal_00 = animal_00;
        this.animal_1 = animal_1;
        this.animal_2 = animal_2;
        this.animal_3 = animal_3;
        this.animal_4 = animal_4;
        this.animal_5 = animal_5;
        this.animal_6 = animal_6;
        this.animal_7 = animal_7;
        this.animal_8 = animal_8;
        this.animal_9 = animal_9;
        this.animal_10 = animal_10;
        this.animal_11 = animal_11;
        this.animal_12 = animal_12;
        this.animal_13 = animal_13;
        this.animal_14 = animal_14;
        this.animal_15 = animal_15;
        this.animal_16 = animal_16;
        this.animal_17 = animal_17;
        this.animal_18 = animal_18;
        this.animal_19 = animal_19;
        this.animal_20 = animal_20;
        this.animal_21 = animal_21;
        this.animal_22 = animal_22;
        this.animal_23 = animal_23;
        this.animal_24 = animal_24;
        this.animal_25 = animal_25;
        this.animal_26 = animal_26;
        this.animal_27 = animal_27;
        this.animal_28 = animal_28;
        this.animal_29 = animal_29;
        this.animal_30 = animal_30;
        this.animal_31 = animal_31;
        this.animal_32 = animal_32;
        this.animal_33 = animal_33;
        this.animal_34 = animal_34;
        this.animal_35 = animal_35;
        this.animal_36 = animal_36;
    }

    public CupoAnimal get(String fechax, String programax, String sorteox) {
        String sql = "select * from cupo_animal where fecha=? and lower (programa) like lower ('%"+programax+"%') and sorteo=?";

        try ( Connection con = new ConectarDBSQLLite().getCon()) {
            pst = con.prepareStatement(sql);
            pst.setString(1, fechax);
            pst.setString(2, sorteox.toLowerCase().replace(" ", ""));
            rs = pst.executeQuery();
            CupoAnimal cupo = new CupoAnimal();
            if(rs.next()) {
                 return  new CupoAnimal(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDouble(5),
                        rs.getDouble(6),
                        rs.getDouble(7),
                        rs.getDouble(8),
                        rs.getDouble(9),
                        rs.getDouble(10),
                        rs.getDouble(11),
                        rs.getDouble(12),
                        rs.getDouble(13),
                        rs.getDouble(14),
                        rs.getDouble(15),
                        rs.getDouble(16),
                        rs.getDouble(17),
                        rs.getDouble(18),
                        rs.getDouble(19),
                        rs.getDouble(20),
                        rs.getDouble(21),
                        rs.getDouble(22),
                        rs.getDouble(23),
                        rs.getDouble(24),
                        rs.getDouble(25),
                        rs.getDouble(26),
                        rs.getDouble(27),
                        rs.getDouble(28),
                        rs.getDouble(29),
                        rs.getDouble(30),
                        rs.getDouble(31),
                        rs.getDouble(32),
                        rs.getDouble(33),
                        rs.getDouble(34),
                        rs.getDouble(35),
                        rs.getDouble(36),
                        rs.getDouble(37),
                        rs.getDouble(38),
                        rs.getDouble(39),
                        rs.getDouble(40),
                        rs.getDouble(41),
                        rs.getDouble(42),
                        rs.getDouble(43));

            } else{
                return insert(fechax, programax, sorteox);
            }
            
            
        } catch (Exception e) {
            Logger.getLogger(CupoAnimal.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e);
            return new CupoAnimal();
        } finally {
            try {
                pst.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(CupoAnimal.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, ex);
            }
        }

    }

    private CupoAnimal insert(String fechax, String programax, String sorteox) {
        int resultado = 0;
        String sql = "insert into cupo_animal (fecha,programa,sorteo) values (?,?,?)";

        try ( Connection con = new ConectarDBSQLLite().getCon()) {
            pst = con.prepareStatement(sql);
            pst.setString(1, fechax);
            pst.setString(2, programax);
            pst.setString(3, sorteox);

            resultado = pst.executeUpdate();

        } catch (Exception e) {
            Logger.getLogger(CupoAnimal.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e);
            return new CupoAnimal();
        } finally {
            try {
                pst.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(CupoAnimal.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, ex);
            }
        }

        return resultado > 0
                ? get(fechax, programax, sorteox)
                : null;
    }

    public double getCupoActual(String animal) {

        switch (animal) {
            case "00":
                return this.maximo - this.animal_00;
            case "0":
                return this.maximo - this.animal_0;
            case "1":
                return this.maximo - this.animal_1;
            case "2":
                return this.maximo - this.animal_2;
            case "3":
                return this.maximo - this.animal_3;
            case "4":
                return this.maximo - this.animal_4;
            case "5":
                return this.maximo - this.animal_5;
            case "6":
                return this.maximo - this.animal_6;
            case "7":
                return this.maximo - this.animal_7;
            case "8":
                return this.maximo - this.animal_8;
            case "9":
                return this.maximo - this.animal_9;
            case "10":
                return this.maximo - this.animal_10;
            case "11":
                return this.maximo - this.animal_11;
            case "12":
                return this.maximo - this.animal_12;
            case "13":
                return this.maximo - this.animal_13;
            case "14":
                return this.maximo - this.animal_14;
            case "15":
                return this.maximo - this.animal_15;
            case "16":
                return this.maximo - this.animal_16;
            case "17":
                return this.maximo - this.animal_17;
            case "18":
                return this.maximo - this.animal_18;
            case "19":
                return this.maximo - this.animal_19;
            case "20":
                return this.maximo - this.animal_20;
            case "21":
                return this.maximo - this.animal_21;
            case "22":
                return this.maximo - this.animal_22;
            case "23":
                return this.maximo - this.animal_23;
            case "24":
                return this.maximo - this.animal_24;
            case "25":
                return this.maximo - this.animal_25;
            case "26":
                return this.maximo - this.animal_26;
            case "27":
                return this.maximo - this.animal_27;
            case "28":
                return this.maximo - this.animal_28;
            case "29":
                return this.maximo - this.animal_29;
            case "30":
                return this.maximo - this.animal_30;
            case "31":
                return this.maximo - this.animal_31;
            case "32":
                return this.maximo - this.animal_32;
            case "33":
                return this.maximo - this.animal_33;
            case "34":
                return this.maximo - this.animal_34;
            case "35":
                return this.maximo - this.animal_35;
            case "36":
                return this.maximo - this.animal_36;
            default:
                return 0.0;
        }

    }

    public CupoAnimal setVendido(String animal,double monto) {

        switch (animal) {
            case "00":this.animal_00+=monto;break;
            case "0":this.animal_0+=monto;break;
            case "1":this.animal_1+=monto;break;
            case "2":this.animal_2+=monto;break;
            case "3":this.animal_3+=monto;break;
            case "4":this.animal_4+=monto;break;
            case "5":this.animal_5+=monto;break;
            case "6":this.animal_6+=monto;break;
            case "7":this.animal_7+=monto;break;
            case "8":this.animal_8+=monto;break;
            case "9":this.animal_9+=monto;break;
            case "10":this.animal_10+=monto;break;
            case "11":this.animal_11+=monto;break;
            case "12":this.animal_12+=monto;break;
            case "13":this.animal_13+=monto;break;
            case "14":this.animal_14+=monto;break;
            case "15":this.animal_15+=monto;break;
            case "16":this.animal_16+=monto;break;
            case "17":this.animal_17+=monto;break;
            case "18":this.animal_18+=monto;break;
            case "19":this.animal_19+=monto;break;
            case "20":this.animal_20+=monto;break;
            case "21":this.animal_21+=monto;break;
            case "22":this.animal_22+=monto;break;
            case "23":this.animal_23+=monto;break;
            case "24":this.animal_24+=monto;break;
            case "25":this.animal_25+=monto;break;
            case "26":this.animal_26+=monto;break;
            case "27":this.animal_27+=monto;break;
            case "28":this.animal_28+=monto;break;
            case "29":this.animal_29+=monto;break;
            case "30":this.animal_30+=monto;break;
            case "31":this.animal_31+=monto;break;
            case "32":this.animal_32+=monto;break;
            case "33":this.animal_33+=monto;break;
            case "34":this.animal_34+=monto;break;
            case "35":this.animal_35+=monto;break;
            case "36":this.animal_36+=monto;break;
            
        }
        return this;
    }
    
    public void updateCupo() {

        String sql = "update cupo_animal set animal_00=?,"
                + "animal_0=?,"
                + "animal_1=?,"
                + "animal_2=?,"
                + "animal_3=?,"
                + "animal_4=?,"
                + "animal_5=?,"
                + "animal_6=?,"
                + "animal_7=?,"
                + "animal_8=?,"
                + "animal_9=?,"
                + "animal_10=?,"
                + "animal_11=?,"
                + "animal_12=?,"
                + "animal_13=?,"
                + "animal_14=?,"
                + "animal_15=?,"
                + "animal_16=?,"
                + "animal_17=?,"
                + "animal_18=?,"
                + "animal_19=?,"
                + "animal_20=?,"
                + "animal_21=?,"
                + "animal_22=?,"
                + "animal_23=?,"
                + "animal_24=?,"
                + "animal_25=?,"
                + "animal_26=?,"
                + "animal_27=?,"
                + "animal_28=?,"
                + "animal_29=?,"
                + "animal_30=?,"
                + "animal_31=?,"
                + "animal_32=?,"
                + "animal_33=?,"
                + "animal_34=?,"
                + "animal_35=?,"
                + "animal_36=?"
                + " where fecha=? and programa=? and sorteo=?";
        PreparedStatement pst;

        try ( Connection con = new ConectarDBSQLLite().getCon()) {
            pst = con.prepareStatement(sql);
                
                pst.setDouble(1,animal_00 );
                pst.setDouble(2,animal_0 );
                pst.setDouble(3,animal_1 );
                pst.setDouble(4,animal_2 );
                pst.setDouble(5,animal_3 );
                pst.setDouble(6,animal_4 );
                pst.setDouble(7,animal_5 );
                pst.setDouble(8,animal_6 );
                pst.setDouble(9,animal_7 );
                pst.setDouble(10,animal_8 );
                pst.setDouble(11,animal_9 );
                pst.setDouble(12,animal_10 );
                pst.setDouble(13,animal_11 );
                pst.setDouble(14,animal_12 );
                pst.setDouble(15,animal_13 );
                pst.setDouble(16,animal_14 );
                pst.setDouble(17,animal_15 );
                pst.setDouble(18,animal_16 );
                pst.setDouble(19,animal_17 );
                pst.setDouble(20,animal_18 );
                pst.setDouble(21,animal_19 );
                pst.setDouble(22,animal_20 );
                pst.setDouble(23,animal_21 );
                pst.setDouble(24,animal_22 );
                pst.setDouble(25,animal_23 );
                pst.setDouble(26,animal_24 );
                pst.setDouble(27,animal_25 );
                pst.setDouble(28,animal_26 );
                pst.setDouble(29,animal_27 );
                pst.setDouble(30,animal_28 );
                pst.setDouble(31,animal_29 );
                pst.setDouble(32,animal_30 );
                pst.setDouble(33,animal_31 );
                pst.setDouble(34,animal_32 );
                pst.setDouble(35,animal_33 );
                pst.setDouble(36,animal_34);
                pst.setDouble(37,animal_35 );
                pst.setDouble(38,animal_36 );
                pst.setString(39,fecha);
                pst.setString(40,programa);
                pst.setString(41,sorteo);
                
                pst.execute();
        } catch (Exception e) {
            Logger.getLogger(CupoAnimal.class.getName()).log(Level.SEVERE, null, e);
        }
    }

}
