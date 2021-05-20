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
public class Servicio {
    
    
    private String id_servicio;
    private String matricula_vehiculo;
    private String nif_cliente;
    private String fecha_alquiler;
    private String fecha_entrega;
    private String total;
    private String precio;

    public Servicio(String matricula_vehiculo, String nif_cliente, String fecha_alquiler, String fecha_entrega, String total, String precio) {
        this.matricula_vehiculo = matricula_vehiculo;
        this.nif_cliente = nif_cliente;
        this.fecha_alquiler = fecha_alquiler;
        this.fecha_entrega = fecha_entrega;
        this.total = total;
        this.precio = precio;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(String id_servicio) {
        this.id_servicio = id_servicio;
    }

    public String getMatricula_vehiculo() {
        return matricula_vehiculo;
    }

    public void setMatricula_vehiculo(String matricula_vehiculo) {
        this.matricula_vehiculo = matricula_vehiculo;
    }

    public String getNif_cliente() {
        return nif_cliente;
    }

    public void setNif_cliente(String nif_cliente) {
        this.nif_cliente = nif_cliente;
    }

    public String getFecha_alquiler() {
        return fecha_alquiler;
    }

    public void setFecha_alquiler(String fecha_alquiler) {
        this.fecha_alquiler = fecha_alquiler;
    }

    public String getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(String fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Servicio{" + "matricula_vehiculo=" + matricula_vehiculo + ", nif_cliente=" + nif_cliente + ", fecha_alquiler=" + fecha_alquiler + ", fecha_entrega=" + fecha_entrega + ", total=" + total + '}';
    }
    
    
    
}
