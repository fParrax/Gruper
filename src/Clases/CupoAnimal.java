package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import org.json.JSONArray;

public class CupoAnimal {

    int id = -1, idGrupero,idAgencia, idBanquero;
    String fecha, programa, sorteo, animalVendido;
    double maximo, animal_0, animal_00,
            animal_1, animal_2, animal_3, animal_4, animal_5, animal_6, animal_7, animal_8, animal_9, animal_10,
            animal_11, animal_12, animal_13, animal_14, animal_15, animal_16, animal_17, animal_18, animal_19, animal_20,
            animal_21, animal_22, animal_23, animal_24, animal_25, animal_26, animal_27, animal_28, animal_29, animal_30,
            animal_31, animal_32, animal_33, animal_34, animal_35, animal_36, montoVendido;
    PreparedStatement pst;
    ResultSet rs;

    public CupoAnimal() {
    }

    public CupoAnimal(String programa, String sorteo, String fecha, String animalVendido, double montoVendido) {
        this.programa = programa;
        this.sorteo = sorteo;
        this.fecha = fecha;
        this.animalVendido = animalVendido;
        this.montoVendido = montoVendido + getAnimal(animalVendido);
    }
    public CupoAnimal(int id,int idAgencia, int idGrupero, int idBanquero, String fecha, String programa, String sorteo, double maximo, double animal_0, double animal_00, double animal_1, double animal_2, double animal_3, double animal_4, double animal_5, double animal_6, double animal_7, double animal_8, double animal_9, double animal_10, double animal_11, double animal_12, double animal_13, double animal_14, double animal_15, double animal_16, double animal_17, double animal_18, double animal_19, double animal_20, double animal_21, double animal_22, double animal_23, double animal_24, double animal_25, double animal_26, double animal_27, double animal_28, double animal_29, double animal_30, double animal_31, double animal_32, double animal_33, double animal_34, double animal_35, double animal_36) {
        this.id = id;
        this.idAgencia=idAgencia;
        this.idGrupero = idGrupero;
        this.idBanquero = idBanquero;
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


    public ArrayList getCupoAgencia(int idAgencia, String fechax) {
        ArrayList<CupoAnimal> cupos = new ArrayList();
        String sql = "call `sp.getCuposAgencia` (?,?)";
        int id = 0;

        try (Connection con = new ConectarDBCloud("ag").getCon()) {
            pst = con.prepareStatement(sql);
            pst.setInt(1, idAgencia);
            pst.setString(2, fechax);
            rs = pst.executeQuery();
            while (rs.next()) {

                cupos.add(new CupoAnimal(
                        rs.getInt(1),
                        rs.getInt("idAgencia"),
                        rs.getInt("idGrupero"),
                        rs.getInt("idBanquero"),
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
                        rs.getDouble(43))
                );

            }

        } catch (Exception e) {
            Logger.getLogger(CupoAnimal.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e);
            //return new CupoAnimal();
        } finally {
            try {
                pst.close();
                rs.close();
                //boolean goUpdate = actualizar ? updateMaximo(id,cupoTotal) : false;
            } catch (SQLException ex) {
                Logger.getLogger(CupoAnimal.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, ex);
            }
        }

        return cupos;
    }

    public ArrayList getCupoAgenciaByRangoFecha(String fechaInicio, String fechaFin) {
        ArrayList<CupoAnimal> cupos = new ArrayList();
        String sql = "call `sp.getAllCupoAnimal` (?,?)";
        int id = 0;

        try (Connection con = new ConectarDBCloud("ag").getCon()) {
            pst = con.prepareStatement(sql);
            pst.setString(1, fechaInicio);
            pst.setString(2, fechaFin);
            rs = pst.executeQuery();
            while (rs.next()) {

                cupos.add(new CupoAnimal(
                        rs.getInt(1),
                        rs.getInt("idAgencia"),
                        rs.getInt("idGrupero"),
                        rs.getInt("idBanquero"),
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
                        rs.getDouble(43))
                );

            }

        } catch (Exception e) {
            Logger.getLogger(CupoAnimal.class.getName()).log(Level.SEVERE, null, e);
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

        return cupos;
    }
    
    public CupoAnimal setVendido(String animal, double monto) {

        switch (animal) {
            case "00":
                this.animal_00 += monto;
                setAnimalVendido(animal);
                break;
            case "0":
                this.animal_0 += monto;
                setAnimalVendido(animal);
                break;
            case "01":
                this.animal_1 += monto;
                setAnimalVendido(animal);
                break;
            case "1":
                this.animal_1 += monto;
                setAnimalVendido(animal);
                break;
            case "02":
                this.animal_2 += monto;
                setAnimalVendido(animal);
                break;
            case "2":
                this.animal_2 += monto;
                setAnimalVendido(animal);
                break;
            case "03":
                this.animal_3 += monto;
                setAnimalVendido(animal);
                break;
            case "3":
                this.animal_3 += monto;
                setAnimalVendido(animal);
                break;
            case "04":
                this.animal_4 += monto;
                setAnimalVendido(animal);
                break;
            case "4":
                this.animal_4 += monto;
                setAnimalVendido(animal);
                break;
            case "05":
                this.animal_5 += monto;
                setAnimalVendido(animal);
                break;
            case "5":
                this.animal_5 += monto;
                setAnimalVendido(animal);
                break;
            case "06":
                this.animal_6 += monto;
                setAnimalVendido(animal);
                break;
            case "6":
                this.animal_6 += monto;
                setAnimalVendido(animal);
                break;
            case "07":
                this.animal_7 += monto;
                setAnimalVendido(animal);
                break;
            case "7":
                this.animal_7 += monto;
                setAnimalVendido(animal);
                break;
            case "08":
                this.animal_8 += monto;
                setAnimalVendido(animal);
                break;
            case "8":
                this.animal_8 += monto;
                setAnimalVendido(animal);
                break;
            case "09":
                this.animal_9 += monto;
                setAnimalVendido(animal);
                break;
            case "9":
                this.animal_9 += monto;
                setAnimalVendido(animal);
                break;
            case "10":
                this.animal_10 += monto;
                setAnimalVendido(animal);
                break;
            case "11":
                this.animal_11 += monto;
                setAnimalVendido(animal);
                break;
            case "12":
                this.animal_12 += monto;
                setAnimalVendido(animal);
                break;
            case "13":
                this.animal_13 += monto;
                setAnimalVendido(animal);
                break;
            case "14":
                this.animal_14 += monto;
                setAnimalVendido(animal);
                break;
            case "15":
                this.animal_15 += monto;
                setAnimalVendido(animal);
                break;
            case "16":
                this.animal_16 += monto;
                setAnimalVendido(animal);
                break;
            case "17":
                this.animal_17 += monto;
                setAnimalVendido(animal);
                break;
            case "18":
                this.animal_18 += monto;
                setAnimalVendido(animal);
                break;
            case "19":
                this.animal_19 += monto;
                setAnimalVendido(animal);
                break;
            case "20":
                this.animal_20 += monto;
                setAnimalVendido(animal);
                break;
            case "21":
                this.animal_21 += monto;
                setAnimalVendido(animal);
                break;
            case "22":
                this.animal_22 += monto;
                setAnimalVendido(animal);
                break;
            case "23":
                this.animal_23 += monto;
                setAnimalVendido(animal);
                break;
            case "24":
                this.animal_24 += monto;
                setAnimalVendido(animal);
                break;
            case "25":
                this.animal_25 += monto;
                setAnimalVendido(animal);
                break;
            case "26":
                this.animal_26 += monto;
                setAnimalVendido(animal);
                break;
            case "27":
                this.animal_27 += monto;
                setAnimalVendido(animal);
                break;
            case "28":
                this.animal_28 += monto;
                setAnimalVendido(animal);
                break;
            case "29":
                this.animal_29 += monto;
                setAnimalVendido(animal);
                break;
            case "30":
                this.animal_30 += monto;
                setAnimalVendido(animal);
                break;
            case "31":
                this.animal_31 += monto;
                setAnimalVendido(animal);
                break;
            case "32":
                this.animal_32 += monto;
                setAnimalVendido(animal);
                break;
            case "33":
                this.animal_33 += monto;
                setAnimalVendido(animal);
                break;
            case "34":
                this.animal_34 += monto;
                setAnimalVendido(animal);
                break;
            case "35":
                this.animal_35 += monto;
                setAnimalVendido(animal);
                break;
            case "36":
                this.animal_36 += monto;
                setAnimalVendido(animal);
                break;

        }
        return this;
    }

    public void actualizarCupo(JSONArray jsonAnimalesVendidos) {
        String sql = "call `sp.UpdateCupoAnimalAgenciaByJson` (?)";

        try (Connection con = new ConectarDBCloud("ag").getCon()) {
            pst = con.prepareCall(sql);
            pst.setString(1, jsonAnimalesVendidos.toString());
            pst.executeUpdate();

        } catch (Exception e) {
            Logger.getLogger(CupoAnimal.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                pst.close();
            } catch (SQLException ex) {
                Logger.getLogger(CupoAnimal.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }

    
   
    public double getCupoActual(String animal) {

        switch (animal) {
            case "00":
                return this.maximo - this.animal_00;
            case "0":
                return this.maximo - this.animal_0;
            case "1":
                return this.maximo - this.animal_1;
            case "01":
                return this.maximo - this.animal_1;
            case "02":
                return this.maximo - this.animal_2;
            case "2":
                return this.maximo - this.animal_2;
            case "03":
                return this.maximo - this.animal_3;
            case "3":
                return this.maximo - this.animal_3;
            case "04":
                return this.maximo - this.animal_4;
            case "4":
                return this.maximo - this.animal_4;
            case "05":
                return this.maximo - this.animal_5;
            case "5":
                return this.maximo - this.animal_5;
            case "06":
                return this.maximo - this.animal_6;
            case "6":
                return this.maximo - this.animal_6;
            case "07":
                return this.maximo - this.animal_7;
            case "7":
                return this.maximo - this.animal_7;
            case "08":
                return this.maximo - this.animal_8;
            case "8":
                return this.maximo - this.animal_8;
            case "09":
                return this.maximo - this.animal_9;
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

    public double getAnimal(String animal) {

        switch (animal) {
            case "00":
                return this.animal_00;
            case "0":
                return this.animal_0;
            case "1":
                return this.animal_1;
            case "2":
                return this.animal_2;
            case "3":
                return this.animal_3;
            case "4":
                return this.animal_4;
            case "5":
                return this.animal_5;
            case "6":
                return this.animal_6;
            case "7":
                return this.animal_7;
            case "8":
                return this.animal_8;
            case "9":
                return this.animal_9;
            case "10":
                return this.animal_10;
            case "11":
                return this.animal_11;
            case "12":
                return this.animal_12;
            case "13":
                return this.animal_13;
            case "14":
                return this.animal_14;
            case "15":
                return this.animal_15;
            case "16":
                return this.animal_16;
            case "17":
                return this.animal_17;
            case "18":
                return this.animal_18;
            case "19":
                return this.animal_19;
            case "20":
                return this.animal_20;
            case "21":
                return this.animal_21;
            case "22":
                return this.animal_22;
            case "23":
                return this.animal_23;
            case "24":
                return this.animal_24;
            case "25":
                return this.animal_25;
            case "26":
                return this.animal_26;
            case "27":
                return this.animal_27;
            case "28":
                return this.animal_28;
            case "29":
                return this.animal_29;
            case "30":
                return this.animal_30;
            case "31":
                return this.animal_31;
            case "32":
                return this.animal_32;
            case "33":
                return this.animal_33;
            case "34":
                return this.animal_34;
            case "35":
                return this.animal_35;
            case "36":
                return this.animal_36;
            default:
                return 0.0;
        }

    }

    @Override
    public String toString() {
        return "CupoAnimal{" + "id=" + id + ", idGrupero=" + idGrupero + ", idAgencia=" + idAgencia + ", idBanquero=" + idBanquero + ", fecha=" + fecha + ", programa=" + programa + ", sorteo=" + sorteo + ", animalVendido=" + animalVendido + ", maximo=" + maximo + ", animal_0=" + animal_0 + ", animal_00=" + animal_00 + ", animal_1=" + animal_1 + ", animal_2=" + animal_2 + ", animal_3=" + animal_3 + ", animal_4=" + animal_4 + ", animal_5=" + animal_5 + ", animal_6=" + animal_6 + ", animal_7=" + animal_7 + ", animal_8=" + animal_8 + ", animal_9=" + animal_9 + ", animal_10=" + animal_10 + ", animal_11=" + animal_11 + ", animal_12=" + animal_12 + ", animal_13=" + animal_13 + ", animal_14=" + animal_14 + ", animal_15=" + animal_15 + ", animal_16=" + animal_16 + ", animal_17=" + animal_17 + ", animal_18=" + animal_18 + ", animal_19=" + animal_19 + ", animal_20=" + animal_20 + ", animal_21=" + animal_21 + ", animal_22=" + animal_22 + ", animal_23=" + animal_23 + ", animal_24=" + animal_24 + ", animal_25=" + animal_25 + ", animal_26=" + animal_26 + ", animal_27=" + animal_27 + ", animal_28=" + animal_28 + ", animal_29=" + animal_29 + ", animal_30=" + animal_30 + ", animal_31=" + animal_31 + ", animal_32=" + animal_32 + ", animal_33=" + animal_33 + ", animal_34=" + animal_34 + ", animal_35=" + animal_35 + ", animal_36=" + animal_36 + ", montoVendido=" + montoVendido + '}';
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

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public int getIdAgencia() {
        return idAgencia;
    }

    public void setIdAgencia(int idAgencia) {
        this.idAgencia = idAgencia;
    }

    public String getSorteo() {
        return sorteo;
    }

    public void setSorteo(String sorteo) {
        this.sorteo = sorteo;
    }

    public String getAnimalVendido() {
        return animalVendido;
    }

    public void setAnimalVendido(String animalVendido) {
        this.animalVendido = animalVendido;
    }

    public double getMaximo() {
        return maximo;
    }

    public void setMaximo(double maximo) {
        this.maximo = maximo;
    }

    public double getAnimal_0() {
        return animal_0;
    }

    public void setAnimal_0(double animal_0) {
        this.animal_0 = animal_0;
    }

    public double getAnimal_00() {
        return animal_00;
    }

    public void setAnimal_00(double animal_00) {
        this.animal_00 = animal_00;
    }

    public double getAnimal_1() {
        return animal_1;
    }

    public void setAnimal_1(double animal_1) {
        this.animal_1 = animal_1;
    }

    public double getAnimal_2() {
        return animal_2;
    }

    public void setAnimal_2(double animal_2) {
        this.animal_2 = animal_2;
    }

    public double getAnimal_3() {
        return animal_3;
    }

    public void setAnimal_3(double animal_3) {
        this.animal_3 = animal_3;
    }

    public double getAnimal_4() {
        return animal_4;
    }

    public void setAnimal_4(double animal_4) {
        this.animal_4 = animal_4;
    }

    public double getAnimal_5() {
        return animal_5;
    }

    public void setAnimal_5(double animal_5) {
        this.animal_5 = animal_5;
    }

    public double getAnimal_6() {
        return animal_6;
    }

    public void setAnimal_6(double animal_6) {
        this.animal_6 = animal_6;
    }

    public double getAnimal_7() {
        return animal_7;
    }

    public void setAnimal_7(double animal_7) {
        this.animal_7 = animal_7;
    }

    public double getAnimal_8() {
        return animal_8;
    }

    public void setAnimal_8(double animal_8) {
        this.animal_8 = animal_8;
    }

    public double getAnimal_9() {
        return animal_9;
    }

    public void setAnimal_9(double animal_9) {
        this.animal_9 = animal_9;
    }

    public double getAnimal_10() {
        return animal_10;
    }

    public void setAnimal_10(double animal_10) {
        this.animal_10 = animal_10;
    }

    public double getAnimal_11() {
        return animal_11;
    }

    public void setAnimal_11(double animal_11) {
        this.animal_11 = animal_11;
    }

    public int getIdGrupero() {
        return idGrupero;
    }

    public void setIdGrupero(int idGrupero) {
        this.idGrupero = idGrupero;
    }

    public int getIdBanquero() {
        return idBanquero;
    }

    public void setIdBanquero(int idBanquero) {
        this.idBanquero = idBanquero;
    }

    public double getAnimal_12() {
        return animal_12;
    }

    public void setAnimal_12(double animal_12) {
        this.animal_12 = animal_12;
    }

    public double getAnimal_13() {
        return animal_13;
    }

    public void setAnimal_13(double animal_13) {
        this.animal_13 = animal_13;
    }

    public double getAnimal_14() {
        return animal_14;
    }

    public void setAnimal_14(double animal_14) {
        this.animal_14 = animal_14;
    }

    public double getAnimal_15() {
        return animal_15;
    }

    public void setAnimal_15(double animal_15) {
        this.animal_15 = animal_15;
    }

    public double getAnimal_16() {
        return animal_16;
    }

    public void setAnimal_16(double animal_16) {
        this.animal_16 = animal_16;
    }

    public double getAnimal_17() {
        return animal_17;
    }

    public void setAnimal_17(double animal_17) {
        this.animal_17 = animal_17;
    }

    public double getAnimal_18() {
        return animal_18;
    }

    public void setAnimal_18(double animal_18) {
        this.animal_18 = animal_18;
    }

    public double getAnimal_19() {
        return animal_19;
    }

    public void setAnimal_19(double animal_19) {
        this.animal_19 = animal_19;
    }

    public double getAnimal_20() {
        return animal_20;
    }

    public void setAnimal_20(double animal_20) {
        this.animal_20 = animal_20;
    }

    public double getAnimal_21() {
        return animal_21;
    }

    public void setAnimal_21(double animal_21) {
        this.animal_21 = animal_21;
    }

    public double getAnimal_22() {
        return animal_22;
    }

    public void setAnimal_22(double animal_22) {
        this.animal_22 = animal_22;
    }

    public double getAnimal_23() {
        return animal_23;
    }

    public void setAnimal_23(double animal_23) {
        this.animal_23 = animal_23;
    }

    public double getAnimal_24() {
        return animal_24;
    }

    public void setAnimal_24(double animal_24) {
        this.animal_24 = animal_24;
    }

    public double getAnimal_25() {
        return animal_25;
    }

    public void setAnimal_25(double animal_25) {
        this.animal_25 = animal_25;
    }

    public double getAnimal_26() {
        return animal_26;
    }

    public void setAnimal_26(double animal_26) {
        this.animal_26 = animal_26;
    }

    public double getAnimal_27() {
        return animal_27;
    }

    public void setAnimal_27(double animal_27) {
        this.animal_27 = animal_27;
    }

    public double getAnimal_28() {
        return animal_28;
    }

    public void setAnimal_28(double animal_28) {
        this.animal_28 = animal_28;
    }

    public double getAnimal_29() {
        return animal_29;
    }

    public void setAnimal_29(double animal_29) {
        this.animal_29 = animal_29;
    }

    public double getAnimal_30() {
        return animal_30;
    }

    public void setAnimal_30(double animal_30) {
        this.animal_30 = animal_30;
    }

    public double getAnimal_31() {
        return animal_31;
    }

    public void setAnimal_31(double animal_31) {
        this.animal_31 = animal_31;
    }

    public double getAnimal_32() {
        return animal_32;
    }

    public void setAnimal_32(double animal_32) {
        this.animal_32 = animal_32;
    }

    public double getAnimal_33() {
        return animal_33;
    }

    public void setAnimal_33(double animal_33) {
        this.animal_33 = animal_33;
    }

    public double getAnimal_34() {
        return animal_34;
    }

    public void setAnimal_34(double animal_34) {
        this.animal_34 = animal_34;
    }

    public double getAnimal_35() {
        return animal_35;
    }

    public void setAnimal_35(double animal_35) {
        this.animal_35 = animal_35;
    }

    public double getAnimal_36() {
        return animal_36;
    }

    public void setAnimal_36(double animal_36) {
        this.animal_36 = animal_36;
    }

    public double getMontoVendido() {
        return montoVendido;
    }

    public void setMontoVendido(double montoVendido) {
        this.montoVendido = montoVendido;
    }

}
