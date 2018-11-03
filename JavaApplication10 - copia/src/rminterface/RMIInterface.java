package rminterface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIInterface extends Remote {
    
    public boolean añadirPermisos( String cedula,  String permiso)throws java.rmi.RemoteException;
    public boolean crearCuenta(String titular, String numero_cuenta, String tipo, Double saldo_total)throws java.rmi.RemoteException;
    public boolean borrarCuentas(int id_cuenta) throws java.rmi.RemoteException;
    public boolean modificarCuentas(int id_cuenta, String numero_cuenta, String tipo) throws java.rmi.RemoteException;
    public boolean añadirUsuario( String cedula,String Nombre,  String apellido,  String usuario,  String pass,  String telefono, String email, int id_sucursal) throws java.rmi.RemoteException;
    public boolean adicionarDinero( int id_cuenta,  Double monto) throws java.rmi.RemoteException;
    public String retirarDinero( String cedula,  String valor)throws java.rmi.RemoteException;
    public String obtenerSaldos( String cedula)throws java.rmi.RemoteException;

}
