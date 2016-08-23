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
    //private String nombrePromocion;   
    private Promocion promocion;

    public String getNombreP(){
        /*Promocion p = new Promocion();
        p.setNombre(nombrePromocion);
        return nombrePromocion;*/
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
    
    
}
