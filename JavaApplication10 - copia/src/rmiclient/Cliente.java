package rmiclient;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Random;

import javax.swing.JOptionPane;


public class Cliente {

    
     private int id_cliente;
    private String nombre;
    private String apellido;    
    private String cedula;
    private String telefono;
    private String usuario;
    private String pass;
    private Cuenta lista_cuentas;

    public Cliente() {
    }

    public Cliente(int id_cliente, String nombre, String apellido, String cedula, String telefono, String usuario, String pass, Cuenta lista_cuentas) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.telefono = telefono;
        this.usuario = usuario;
        this.pass = pass;
        this.lista_cuentas = lista_cuentas;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
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

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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

    public Cuenta getLista_cuentas() {
        return lista_cuentas;
    }

    public void setLista_cuentas(Cuenta lista_cuentas) {
        this.lista_cuentas = lista_cuentas;
    }

}
