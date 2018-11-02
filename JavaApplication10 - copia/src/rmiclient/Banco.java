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
public class Banco {
    
     private int id_banco;
    private String nombre;
    private String ubicacion;
    private Sucursal lista_sucursales;

    public Banco(int id_banco, String nombre, String ubicacion, Sucursal lista_sucursales) {
        this.id_banco = id_banco;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.lista_sucursales = lista_sucursales;
    }

    public Banco() {
    }

    public int getId_banco() {
        return id_banco;
    }

    public void setId_banco(int id_banco) {
        this.id_banco = id_banco;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Sucursal getLista_sucursales() {
        return lista_sucursales;
    }

    public void setLista_sucursales(Sucursal lista_sucursales) {
        this.lista_sucursales = lista_sucursales;
    }
    
    
    
}
