/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiclient;

/**
 *
 * @author lurreaf
 */
public class Transaccion {
    
     private int id_transaccion;
    private String nombre;
    private String fecha;
    private String valor;
    private String tipo;
    private String descripcion;
    private Cuenta lista_cuenta;

    public Transaccion() {
    }

    public Transaccion(int id_transaccion, String nombre, String fecha, String valor, String tipo, String descripcion, Cuenta lista_cuenta) {
        this.id_transaccion = id_transaccion;
        this.nombre = nombre;
        this.fecha = fecha;
        this.valor = valor;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.lista_cuenta = lista_cuenta;
    }

    public int getId_transaccion() {
        return id_transaccion;
    }

    public void setId_transaccion(int id_transaccion) {
        this.id_transaccion = id_transaccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Cuenta getLista_cuenta() {
        return lista_cuenta;
    }

    public void setLista_cuenta(Cuenta lista_cuenta) {
        this.lista_cuenta = lista_cuenta;
    }
    
    
    
    
    
}
