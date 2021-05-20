/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Cliente
 */
public class Cliente {
    
    private String NIF;
    private String Nombre;
    private String Direccion;
    private String Poblacion;

    public Cliente(String NIF, String Nombre, String Direccion, String Poblacion) {
        this.NIF = NIF;
        this.Nombre = Nombre;
        this.Direccion = Direccion;
        this.Poblacion = Poblacion;
    }

    public Cliente() {
    }

    public String getNIF() {
        return NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getPoblacion() {
        return Poblacion;
    }

    public void setPoblacion(String Poblacion) {
        this.Poblacion = Poblacion;
    }
    
    
    
}
