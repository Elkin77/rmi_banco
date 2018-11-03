/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiclient;

import Conexion.Conexion;
import com.mysql.jdbc.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author lurreaf
 */
public class Cuenta {

    private int id_cuenta;
    private String titular;
    private String numero_cuenta;
    private String tipo;
    private Double saldo_total;
    private Transaccion lista_transacciones;
    private Connection conectar;

    public Cuenta() {
    }

    public Cuenta(int id_cuenta, String titular, String numero_cuenta, String tipo, Double saldo_total, Transaccion lista_transacciones) {
        this.id_cuenta = id_cuenta;
        this.titular = titular;
        this.numero_cuenta = numero_cuenta;
        this.tipo = tipo;
        this.saldo_total = saldo_total;
        this.lista_transacciones = lista_transacciones;
    }

    public Cuenta(String titular, String numero_cuenta, String tipo, Double saldo_total, Transaccion lista_transacciones) {
        this.titular = titular;
        this.numero_cuenta = numero_cuenta;
        this.tipo = tipo;
        this.saldo_total = saldo_total;
        this.lista_transacciones = lista_transacciones;
    }

    public Cuenta(String titular, String numero_cuenta, String tipo, Double saldo_total) {
        this.titular = titular;
        this.numero_cuenta = numero_cuenta;
        this.tipo = tipo;
        this.saldo_total = saldo_total;
    }

    public int getId_cuenta() {
        return id_cuenta;
    }

    public void setId_cuenta(int id_cuenta) {
        this.id_cuenta = id_cuenta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getNumero_cuenta() {
        return numero_cuenta;
    }

    public void setNumero_cuenta(String numero_cuenta) {
        this.numero_cuenta = numero_cuenta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getSaldo_total() {
        return saldo_total;
    }

    public void setSaldo_total(Double saldo_total) {
        this.saldo_total = saldo_total;
    }

    public Transaccion getLista_transacciones() {
        return lista_transacciones;
    }

    public void setLista_transacciones(Transaccion lista_transacciones) {
        this.lista_transacciones = lista_transacciones;
    }

    public boolean crearCuenta() {
        try {
            String Query = "INSERT INTO Cuenta (titular,numero_cuenta,tipo,saldo_total)VALUES("
                    + "\"" + titular + "\", "
                    + "\"" + numero_cuenta + "\", "
                    + "\"" + tipo + "\", "
                    + "\"" + saldo_total + "\")";
            System.out.println(Query);
            Conexion new_conexion = new Conexion();
            conectar = new_conexion.MySQLConnection();
            Statement st = conectar.createStatement();
            st.executeUpdate(Query);
            JOptionPane.showMessageDialog(null, "Datos almacenados de forma exitosa");
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en el almacenamiento de datos");
            return false;
        }
    }

    public boolean borrarCuenta(int id_cuenta) {
        try {
            String Query = "DELETE FROM Cuenta WHERE id_cuenta = " + id_cuenta + ";";
            System.out.println(Query);
            Conexion new_conexion = new Conexion();
            conectar = new_conexion.MySQLConnection();
            Statement st = conectar.createStatement();
            st.executeUpdate(Query);
            JOptionPane.showMessageDialog(null, "Se ha eliminado esta cuenta");
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar cuenta");
            return false;
        }
    }

    public boolean modificarCuenta(int id_cuenta, String numero_cuenta, String tipo) {
        try {
            String Query = "UPDATE Cuenta SET numero_cuenta = '"
                    + numero_cuenta + "', tipo = '"
                    + tipo + "' WHERE id_cuenta =" + id_cuenta + ";";
            System.out.println(Query);
            Conexion new_conexion = new Conexion();
            conectar = new_conexion.MySQLConnection();
            Statement st = conectar.createStatement();
            st.executeUpdate(Query);
            JOptionPane.showMessageDialog(null, "Datos almacenados de forma exitosa");
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en el almacenamiento de datos");
            return false;
        }
    }

    public boolean adicionarDinero(int id_cuenta, double monto) {
        Double total = 0.0;
        Double response;
        try {
            String Query = "SELECT saldo_total FROM Cuenta WHERE id_cuenta = "
                    + id_cuenta + ";";
            System.out.println(Query);
            Conexion new_conexion = new Conexion();
            conectar = new_conexion.MySQLConnection();
            Statement st = conectar.createStatement();
            //st.executeUpdate(Query);
            ResultSet rs = st.executeQuery(Query);
            System.out.println("Traigo esto" + rs);
            if (!rs.next()) {
                throw new SQLException("No se encontró registro con el nombre");
            }else{
                System.out.println("se encontro");
                response = rs.getDouble("saldo_total");
                System.out.println("sfasga "+ response);
            }
            
            System.out.println("llegueeee");
            total = response + monto;
            System.out.println(total);
            JOptionPane.showMessageDialog(null, "Datos almacenados de forma exitosa");

            try {
                String QueryTwo = "UPDATE Cuenta SET saldo_total = "
                        + total + " WHERE id_cuenta =" + id_cuenta + ";";
                System.out.println(QueryTwo);
                st.executeUpdate(QueryTwo);
                JOptionPane.showMessageDialog(null, "Transaccin Exitosa");
                return true;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error en el almacenamiento de datos");
                return false;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en el almacenamiento de datos");
            return false;
        }

    }

}
