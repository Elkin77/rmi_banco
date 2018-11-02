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
public class Cuenta {
    private int id_cuenta;
    private String titular;
    private String numero_cuenta;
    private String tipo;
    private String saldo_total;
    private Transaccion lista_transacciones;

    public Cuenta() {
    }

    public Cuenta(int id_cuenta, String titular, String numero_cuenta, String tipo, String saldo_total, Transaccion lista_transacciones) {
        this.id_cuenta = id_cuenta;
        this.titular = titular;
        this.numero_cuenta = numero_cuenta;
        this.tipo = tipo;
        this.saldo_total = saldo_total;
        this.lista_transacciones = lista_transacciones;
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

    public String getSaldo_total() {
        return saldo_total;
    }

    public void setSaldo_total(String saldo_total) {
        this.saldo_total = saldo_total;
    }

    public Transaccion getLista_transacciones() {
        return lista_transacciones;
    }

    public void setLista_transacciones(Transaccion lista_transacciones) {
        this.lista_transacciones = lista_transacciones;
    }
    
    
    
    
    
}