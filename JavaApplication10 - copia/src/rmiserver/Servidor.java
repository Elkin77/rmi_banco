package rmiserver;

import Conexion.Conexion;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import rmiclient.Cuenta;
import rmiclient.Transaccion;
import rmiclient.Usuario;

import rminterface.RMIInterface;

public class Servidor extends UnicastRemoteObject implements RMIInterface {

    private final String tabla = "tareas";
    Conexion cx = new Conexion();

    protected Servidor() throws RemoteException {

        super();

    }

    public static void main(String[] args) throws RemoteException {

        try {

            Registry reg = LocateRegistry.createRegistry(1234);
            reg.rebind("localhost", new Servidor());
            System.err.println("Server ready");

        } catch (Exception e) {

            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();

        }

    }

    @Override
    public boolean añadirPermisos(String cedula, String permiso) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean crearCuenta(String titular, String numero_cuenta, String tipo, Double saldo_total) throws RemoteException {
        Boolean respuesta;
        Cuenta new_cuenta = new Cuenta(titular, numero_cuenta, tipo, saldo_total);
        respuesta = new_cuenta.crearCuenta();

        return respuesta;
    }

    @Override
    public boolean borrarCuentas(int id_cuenta) throws RemoteException {
        Boolean respuesta;
        Cuenta cuenta_cliente = new Cuenta();
        respuesta = cuenta_cliente.borrarCuenta(id_cuenta);
        return respuesta;
    }

    @Override
    public boolean modificarCuentas(int id_cuenta, String numero_cuenta, String tipo) throws RemoteException {
        Boolean respuesta;
        Cuenta cuenta_cliente = new Cuenta();
        respuesta = cuenta_cliente.modificarCuenta(id_cuenta, numero_cuenta, tipo);
        return respuesta;

    }

    @Override
    public boolean adicionarDinero(int id_cuenta, Double monto) throws RemoteException {
        Boolean respuesta;
        Cuenta cuenta_cliente = new Cuenta();
        respuesta = cuenta_cliente.adicionarDinero(id_cuenta, monto);
        return respuesta;

    }

    @Override
    public String retirarDinero(String cedula, String valor) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String obtenerSaldos(String cedula) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean añadirUsuario(String cedula,String Nombre,  String apellido,  String usuario,  String pass,  String telefono, String email, int id_sucursal) throws RemoteException {
        Boolean  respuesta ;
        Usuario new_usuario = new Usuario(cedula,Nombre,apellido,usuario,pass,telefono,email, id_sucursal);
        respuesta = new_usuario.insertUsuario();
        
        return respuesta;

        
    }

}
