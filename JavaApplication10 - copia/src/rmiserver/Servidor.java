package rmiserver;

import Conexion.Conexion;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;

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
        public boolean crearCuenta(String Nombre, String Cedula, String Telefono, String sucursal) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
        public boolean borrarCuentas(String Cedula) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
        public boolean modificarCuentas(String Nombre, String Cedula, String Telefono, String sucursal) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

    @Override
        public boolean adicionarDinero(String cedula, String valor) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public boolean añadirUsuario(String cedula, String Nombre, String apellido, String usuario, String pass, String telefono, String email) throws RemoteException {
        cx.MySQLConnection();
        return(cx.insertUsuario("Usuario",cedula,Nombre,apellido,usuario,pass,telefono,email));
    }

   
   

}
