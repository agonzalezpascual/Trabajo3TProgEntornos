/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author dam1
 */
public class Donante {
    
    private String DNI;
    
    private String Nombre;
    
    private String Direccion;
    
    private String CodPosatal;
    
    private String Localidad;
    
    private LocalDate FechaNac;
    
    private String Correo;
    
    private String Telefono;
    
    private String GrupoSang;
    
    private String FactorRH;
    
    private int PK;

    public Donante() {
    }

    public Donante(String DNI, String Nombre, String Direccion, String CodPosatal, String Localidad, LocalDate FechaNac, String Correo, String Telefono, String GrupoSang, String FactorRH) {
        this.DNI = DNI;
        this.Nombre = Nombre;
        this.Direccion = Direccion;
        this.CodPosatal = CodPosatal;
        this.Localidad = Localidad;
        this.FechaNac = FechaNac;
        this.Correo = Correo;
        this.Telefono = Telefono;
        this.GrupoSang = GrupoSang;
        this.FactorRH = FactorRH;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDireccion() {
        return getLocalidad()+ ", " +  Direccion  + ", "+ getCodPostal() ;
    }
    
    public String getSoloDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getCodPostal() {
        return CodPosatal;
    }

    public void setCodPosatal(String CodPosatal) {
        this.CodPosatal = CodPosatal;
    }

    public String getLocalidad() {
        return Localidad;
    }

    public void setLocalidad(String Localidad) {
        this.Localidad = Localidad;
    }

    public LocalDate getFechaNac() {
        return FechaNac;
    }

    public void setFechaNac(LocalDate FechaNac) {
        this.FechaNac = FechaNac;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getGrupoSang() {
        return GrupoSang;
    }

    public void setGrupoSang(String GrupoSang) {
        this.GrupoSang = GrupoSang;
    }

    public String getFactorRH() {
        return FactorRH;
    }

    public void setFactorRH(String FactorRH) {
        this.FactorRH = FactorRH;
    }

    public int getPK() {
        return PK;
    }

    public void setPK(int PK) {
        this.PK = PK;
    }

    public String getCodPosatal() {
        return CodPosatal;
    }
    
    
    
}
