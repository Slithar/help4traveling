/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.time.LocalDate;

/**
 *
 * @author chaos
 */
public class cantidadReservasServicios {
    //private Reserva reserva;
    private Proveedor proveedor;
    private Servicio servicio;
    //private String nombre;
    private int cantidad;
    private int totalLinea;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
    
    public String getNombreS() {
        return servicio.getNombreServicio();
    }

    public void setNombreS(String nombre) {
        Servicio s = new Servicio();
        s.setNombreServicio(nombre);
        //this.nombre=nombre;
        this.servicio = s;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getTotalLinea() {
        return totalLinea;
    }

    public void setTotalLinea(int totalLinea) {
        this.totalLinea = totalLinea;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }
    
}
