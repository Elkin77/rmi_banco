/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiclient;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Random;
import javax.swing.JOptionPane;
import rminterface.RMIInterface;

/**
 *
 * @author lurreaf
 */
public class Sucursal {
    
    private int id_sucursal;
    private String nombre;
    private Permisos lista_permisos;
    private Transaccion lista_transacciones;
    private Usuario lista_usuarios;

    public Sucursal(int id_sucursal, String nombre, Permisos lista_permisos, Transaccion lista_transacciones, Usuario lista_usuarios) {
        this.id_sucursal = id_sucursal;
        this.nombre = nombre;
        this.lista_permisos = lista_permisos;
        this.lista_transacciones = lista_transacciones;
        this.lista_usuarios = lista_usuarios;
    }

    public Sucursal() {
    }

    public int getId_sucursal() {
        return id_sucursal;
    }

    public void setId_sucursal(int id_sucursal) {
        this.id_sucursal = id_sucursal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Permisos getLista_permisos() {
        return lista_permisos;
    }

    public void setLista_permisos(Permisos lista_permisos) {
        this.lista_permisos = lista_permisos;
    }

    public Transaccion getLista_transacciones() {
        return lista_transacciones;
    }

    public void setLista_transacciones(Transaccion lista_transacciones) {
        this.lista_transacciones = lista_transacciones;
    }

    public Usuario getLista_usuarios() {
        return lista_usuarios;
    }

    public void setLista_usuarios(Usuario lista_usuarios) {
        this.lista_usuarios = lista_usuarios;
    }
    
      public static void main(String[] args)
            throws MalformedURLException, RemoteException, NotBoundException {
        Sucursal c = new Sucursal();
        c.connectRemote();

    }

    private void connectRemote() throws RemoteException {
        try {
            Registry reg = LocateRegistry.getRegistry("localhost", 1234);
            RMIInterface ad = (RMIInterface) reg.lookup("localhost");

            
                Random aleatorio = new Random(System.currentTimeMillis());
                switch (1) {

                    case 1: {
                        String txt = JOptionPane.showInputDialog("Binvenido");
                        
                        if( ad.crearCuenta("1", "4547545", "Ahorros", "5.000.000")){
                             JOptionPane.showMessageDialog(null, "OK CUENTA");
                        }else{
                            JOptionPane.showMessageDialog(null, "False CUENTA");
                        }
                        
                        if( ad.añadirUsuario("12345", "pepito", "perez", "puser", "145547", "7545", "juan@gmail.com")){
                             JOptionPane.showMessageDialog(null, "OK USUARIO");
                        }else{
                            JOptionPane.showMessageDialog(null, "FALSE USUARIO");
                        }
                       
                        break;
                    }


                    default: {
                        JOptionPane.showMessageDialog(null, "WRONG INPUT");
                        break;
                    }

                }

        } catch (NotBoundException | RemoteException e) {
            System.out.println("Exepion " + e);
        }
    }
}
