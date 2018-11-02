package rminterface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIInterface extends Remote {
    
    public boolean añadirPermisos( String cedula,  String permiso)throws java.rmi.RemoteException;
    public boolean crearCuenta(String Nombre, String Cedula, String Telefono, String sucursal)throws java.rmi.RemoteException;
    public boolean borrarCuentas(String Cedula) throws java.rmi.RemoteException;
    public boolean modificarCuentas( String Nombre,  String Cedula,  String Telefono,  String sucursal) throws java.rmi.RemoteException;
    public boolean añadirUsuario( String cedula,String Nombre,  String apellido,  String usuario,  String pass,  String telefono, String email) throws java.rmi.RemoteException;
    public boolean adicionarDinero( String cedula,  String valor) throws java.rmi.RemoteException;
    public String retirarDinero( String cedula,  String valor)throws java.rmi.RemoteException;
    public String obtenerSaldos( String cedula)throws java.rmi.RemoteException;

}
