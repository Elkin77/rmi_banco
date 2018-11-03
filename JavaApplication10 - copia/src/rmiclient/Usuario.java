/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiclient;

import com.mysql.jdbc.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author lurreaf
 */
public class Usuario {

    private int id;
    private String nombre;
    private String apellido;
    private String usuario;
    private String pass;
    private String telefono;
    private String email;
    private String cedula;
    private int sucursal;
    private Connection conectar;
    public Usuario() {
    }

    public Usuario(int id, String nombre, String apellido, String usuario, String pass, String telefono, String email, String cedula) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.pass = pass;
        this.telefono = telefono;
        this.email = email;
        this.cedula = cedula;
    }

    public Usuario(String nombre, String apellido, String usuario, String pass, String telefono, String email, String cedula, int sucursal) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.pass = pass;
        this.telefono = telefono;
        this.email = email;
        this.cedula = cedula;
        this.sucursal = sucursal;
    }

    public int getSucursal() {
        return sucursal;
    }

    public void setSucursal(int sucursal) {
        this.sucursal = sucursal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    
    public boolean insertUsuario( ) {
        try {
            String Query = "INSERT INTO " + "Usuario" + " (cedula,nombre,apellido,usuario,Pass,telefono,email,id_sucursal)VALUES("
                    + "\"" + cedula + "\", "
                    + "\"" + nombre + "\", "
                    + "\"" + apellido + "\", "
                    + "\"" + usuario + "\", "
                    + "\"" + pass + "\", "
                    + "\"" + telefono + "\", "
                    + "\"" + email + "\", "
                    + "\"" + sucursal + "\")";
            System.out.println(Query);
            Statement st = conectar.createStatement();
            st.executeUpdate(Query);
            JOptionPane.showMessageDialog(null, "Datos almacenados de forma exitosa");
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en el almacenamiento de datos");
             return false;
        }
    }

}
