/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author dam1
 */
public class Donacion {
    
    
    private String DNI;
    private String codSan;
    private String cant;
    private String inc;
    private String nomSan;
    private String nomCen;
    private String telSan;
    private String fecDon;

    public Donacion(String DNI, String codSan, String cant, String inc, String nomCen, String nomSan, String telSan, String fecDon) {
        this.DNI = DNI;
        this.codSan = codSan;
        this.cant = cant;
        this.inc = inc;
        this.nomCen = nomCen;
        this.nomSan = nomSan;
        this.telSan = telSan;
        this.fecDon = fecDon;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getCodSan() {
        return codSan;
    }

    public void setCodSan(String codSan) {
        this.codSan = codSan;
    }

    public String getCant() {
        return cant;
    }

    public void setCant(String cant) {
        this.cant = cant;
    }

    public String getInc() {
        return inc;
    }

    public void setInc(String inc) {
        this.inc = inc;
    }

    public String getNomSan() {
        return nomSan;
    }

    public void setNomSan(String nomSan) {
        this.nomSan = nomSan;
    }

    public String getNomCen() {
        return nomCen;
    }

    public void setNomCen(String nomCen) {
        this.nomCen = nomCen;
    }

    public String getFecDon() {
        return fecDon;
    }

    public void setFecDon(String fecDon) {
        this.fecDon = fecDon;
    }
    
    public String getTelSan() {
        return telSan;
    }

    public void setTelSan(String telSan) {
        this.telSan = telSan;
    }
    
    
    
}
