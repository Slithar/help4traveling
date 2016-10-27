/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.*;
import java.time.*;

/**
 *
 * @author usuario
 */
public class DataReserva {
    private int numero;
    private LocalDate fecha;
    private int precio;
    private String estadoReserva;
    private String fechaReserva;
    private String cliente;    
    private ArrayList<DataCantidadReservasServicios> serviciosReserva;
    private ArrayList<DataCantidadReservasPromociones> reservaPromociones;    
    private Estado estado;
    
    public DataReserva() {
    }

    public DataReserva(int numero, LocalDate fecha, int precio, String cliente, ArrayList<DataCantidadReservasServicios> serviciosReserva, ArrayList<DataCantidadReservasPromociones> reservaPromociones) {
        this.numero = numero;
        this.fecha = fecha;
        this.precio = precio;
        this.cliente = cliente;
        this.serviciosReserva = serviciosReserva;
        this.reservaPromociones = reservaPromociones;
        
        String fechaRe = fecha.toString();
        String[] fechaPartida = fechaRe.split("-");
        this.fechaReserva = fechaPartida[2] + "/" + fechaPartida[1] + "/" + fechaPartida[0];
    }
    
    public DataReserva(int numero, LocalDate fecha, int precio, String cliente, ArrayList<DataCantidadReservasServicios> serviciosReserva, ArrayList<DataCantidadReservasPromociones> reservaPromociones, Estado estado) {
        this.numero = numero;
        this.fecha = fecha;
        this.precio = precio;
        this.cliente = cliente;
        this.serviciosReserva = serviciosReserva;
        this.reservaPromociones = reservaPromociones;
        this.estado = estado;
        this.estadoReserva = estado.toString();
        
        String fechaRe = fecha.toString();
        String[] fechaPartida = fechaRe.split("-");
        this.fechaReserva = fechaPartida[2] + "/" + fechaPartida[1] + "/" + fechaPartida[0];
    }   

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
        
        String fechaRe = fecha.toString();
        String[] fechaPartida = fechaRe.split("-");
        this.fechaReserva = fechaPartida[2] + "/" + fechaPartida[1] + "/" + fechaPartida[0];
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public ArrayList<DataCantidadReservasServicios> getServiciosReserva() {
        return serviciosReserva;
    }

    public void setServiciosReserva(ArrayList<DataCantidadReservasServicios> serviciosReserva) {
        this.serviciosReserva = serviciosReserva;
    }

    public ArrayList<DataCantidadReservasPromociones> getReservaPromociones() {
        return reservaPromociones;
    }

    public void setReservaPromociones(ArrayList<DataCantidadReservasPromociones> reservaPromociones) {
        this.reservaPromociones = reservaPromociones;
    }
         public Estado getEstado(){
        return estado;
        
    }
    public void setEstado(String estado){        
        this.estado = Estado.obtenerEstado(estado);
        this.estadoReserva = estado;
    }
    
    public String getEstadoString(){
        return estado.toString();
        
    }

    public String getEstadoReserva() {
        return estadoReserva;
    }

    public void setEstadoReserva(String estadoReserva) {
        this.estadoReserva = estadoReserva;
    }

    public String getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(String fechaReserva) {
        this.fechaReserva = fechaReserva;
    }
    
    
}
