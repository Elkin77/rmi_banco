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
            int a, b, sum, valor = 0;

            Random aleatorio = new Random(System.currentTimeMillis());
            JOptionPane.showMessageDialog(null, "Elija una opcion");

            valor = Integer.parseInt(JOptionPane.showInputDialog("1. Crear cuenta\n 2. Añadir usuario\n 3. Añadir permiso\n "
                    + "4. Obtener saldos \n 5. Modificar Cuenta \n 6. Eliminar Cuenta \n 7. Agregar dinero"));

            Random r = new Random();
            switch (valor) {

                case 1: {
                    String cuenta = "", tipo = "", valorcuenta = "";
                    int valorDado = r.nextInt(900) + 1;

                    String prueba = String.valueOf(valorDado);
                    String usuario = JOptionPane.showInputDialog("Ingrese id Usuario");
                    cuenta = JOptionPane.showInputDialog("Ingrese numero de cuenta");
                    tipo = JOptionPane.showInputDialog("Ingrese tipo cuenta");
                    valorcuenta = JOptionPane.showInputDialog("Ingrese valor");
                    Double monto_inicial = Double.parseDouble(valorcuenta);

                    if (ad.crearCuenta(usuario, cuenta, tipo, monto_inicial)) {
                        JOptionPane.showMessageDialog(null, "OK CUENTA CREADA");
                    } else {
                        JOptionPane.showMessageDialog(null, "ERROR TRANSACCIÓN");
                    }

                    break;
                }

                case 2: {

                    String cedula = "", Nombre = "", apellido = "", user = "", pass = "", telefono = "", email = "";
                    cedula = JOptionPane.showInputDialog("Ingrese cedula");
                    Nombre = JOptionPane.showInputDialog("Ingrese nombre");
                    apellido = JOptionPane.showInputDialog("Ingrese apellido");
                    user = JOptionPane.showInputDialog("Ingrese usuario");
                    pass = JOptionPane.showInputDialog("Ingrese contraseña");
                    telefono = JOptionPane.showInputDialog("Ingrese telefono");
                    email = JOptionPane.showInputDialog("Ingrese email");
                    int id_sucursal = Integer.parseInt(JOptionPane.showInputDialog("Id Sucursal"));
                    if (ad.añadirUsuario(cedula, Nombre, apellido, user, pass, telefono, email, id_sucursal)) {
                        JOptionPane.showMessageDialog(null, "OK USUARIO");
                    } else {
                        JOptionPane.showMessageDialog(null, "FALSE USUARIO");
                    }

                    break;
                }

                case 3: {

                    String cedula = "", acceso = "";
                    cedula = JOptionPane.showInputDialog("Ingrese cedula");
                    acceso = JOptionPane.showInputDialog("Ingrese acceso");
                    if (ad.añadirPermisos(cedula, acceso)) {
                        JOptionPane.showMessageDialog(null, "OK permiso");
                    } else {
                        JOptionPane.showMessageDialog(null, "FALSE permiso");
                    }

                    break;
                }

                case 4: {

                    String cedula = "", respuesta = "";
                    cedula = JOptionPane.showInputDialog("Ingrese cedula");
                    respuesta = ad.obtenerSaldos(cedula);
                    JOptionPane.showMessageDialog(null, "Saldo " + respuesta);

                    break;
                }

                case 5: {

                    
                    int id_cuenta = Integer.parseInt(JOptionPane.showInputDialog("Ingrese ID de la cuenta"));
                    String numero_cuenta = JOptionPane.showInputDialog("Ingrese nombre");
                    String tipo = JOptionPane.showInputDialog("Ingrese Tipo de cuenta");
                    

                    if (ad.modificarCuentas(id_cuenta, numero_cuenta, tipo)) {
                        JOptionPane.showMessageDialog(null, "OK CUENTA MODIFICADA");
                    } else {
                        JOptionPane.showMessageDialog(null, "ERROR CUENTA MODIFICA");
                    }

                    break;
                }
                
                case 6: {

                    
                    int id_cuenta = Integer.parseInt(JOptionPane.showInputDialog("Ingrese ID de la cuenta"));
                    
                    if (ad.borrarCuentas(id_cuenta)) {
                        JOptionPane.showMessageDialog(null, "CUENTA ELIMINADA OK");
                    } else {
                        JOptionPane.showMessageDialog(null, "CUENTA ELIMINADA OK");
                    }

                    break;
                }
                
                case 7: {

                    
                    int id_cuenta = Integer.parseInt(JOptionPane.showInputDialog("Ingrese ID de la cuenta"));
                    Double monto = Double.parseDouble(JOptionPane.showInputDialog("Ingrese Monto de la transaccion"));
                    
                    if (ad.adicionarDinero(id_cuenta, monto)) {
                        JOptionPane.showMessageDialog(null, "OK, TRANSACCION EXITOSA");
                    } else {
                        JOptionPane.showMessageDialog(null, "ERROR EN TRANSACCION");
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

        try {
            Registry reg = LocateRegistry.getRegistry("localhost", 1234);
            RMIInterface ad = (RMIInterface) reg.lookup("localhost");

            Random aleatorio = new Random(System.currentTimeMillis());
            switch (1) {

                case 1: {
                    String txt = JOptionPane.showInputDialog("Binvenido");

                    /*
                        if( ad.crearCuenta("1", "4547545", "Ahorros", 5000.00)){
                             JOptionPane.showMessageDialog(null, "OK CUENTA");
                        }else{
                            JOptionPane.showMessageDialog(null, "False CUENTA");
                        }
                     */
 /*
                    if (ad.borrarCuentas(2)) {
                        JOptionPane.showMessageDialog(null, "OK Se borro");
                    } else {
                        JOptionPane.showMessageDialog(null, "False no se borro");
                    }
                     */
 /*
                    if( ad.modificarCuentas(3, "4547545", "Credito")){
                             JOptionPane.showMessageDialog(null, "OK CUENTA");
                        }else{
                            JOptionPane.showMessageDialog(null, "False CUENTA");
                        }
                     */
                    if (ad.adicionarDinero(3, 5000.00)) {
                        JOptionPane.showMessageDialog(null, "OK CUENTA");
                    } else {
                        JOptionPane.showMessageDialog(null, "False CUENTA");
                    }
                    /*
                        if( ad.añadirUsuario("12345", "pepito", "perez", "puser", "145547", "7545", "juan@gmail.com")){
                             JOptionPane.showMessageDialog(null, "OK USUARIO");
                        }else{
                            JOptionPane.showMessageDialog(null, "FALSE USUARIO");
                        }
                     */
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
