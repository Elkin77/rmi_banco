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
public class Permisos {
    
     private int id_permisos;
    private String nombre;
    private String acceso;
    private String descripcion;

    public Permisos(int id_permisos, String nombre, String acceso, String descripcion) {
        this.id_permisos = id_permisos;
        this.nombre = nombre;
        this.acceso = acceso;
        this.descripcion = descripcion;
    }

    public Permisos() {
    }

    public int getId_permisos() {
        return id_permisos;
    }

    public void setId_permisos(int id_permisos) {
        this.id_permisos = id_permisos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAcceso() {
        return acceso;
    }

    public void setAcceso(String acceso) {
        this.acceso = acceso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
}
