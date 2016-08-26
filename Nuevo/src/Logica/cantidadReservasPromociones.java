/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.time.*;

/**
 *
 * @author chaos
 */
public class cantidadReservasPromociones {
    private int cantidad;
    private int totalLinea;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String nombrePromocion;   
    private Promocion promocion;
    private Proveedor proveedor;
    private String nombreProveedor;

    public cantidadReservasPromociones() {
        
    }
    public cantidadReservasPromociones(int cantidad, int totalLinea, LocalDate fechaInicio, LocalDate fechaFin, Promocion promocion, Proveedor proveedor) {
        this.cantidad = cantidad;
        this.totalLinea = totalLinea;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.promocion = promocion;
        this.proveedor = proveedor;
    }
    
    public String getNombrePromocion(){
        return this.nombrePromocion;
    }
    
    public void setNombrePromocion(String nombrePromocion){
        this.nombrePromocion = nombrePromocion;
    }

    /*public cantidadReservasPromociones(int aInt, int aInt0, LocalDate of, LocalDate of0, Promocion promocion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/

    public String getNombreP(){
        return promocion.getNombre();
    }
    public void setnombreP(String nombre){
        Promocion p = new Promocion();
        p.setNombre(nombre);
        this.promocion = p;
    }
    
    public int getTotalL(){
        return totalLinea;
    }
    public void setTotalL(int totalL){
        this.totalLinea=totalL;
    }
 

    public Promocion getPromocion() {
        return promocion;
    }

    public void setPromocion(Promocion promocion) {
        this.promocion = promocion;
    }
    

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
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

    public int getTotalLinea() {
        return totalLinea;
    }

    public void setTotalLinea(int totalLinea) {
        this.totalLinea = totalLinea;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }    
}
