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
    private String cliente;
    private ArrayList<cantidadReservasServicios> serviciosReserva;
    private ArrayList<cantidadReservasPromociones> reservaPromociones;    
    private String  estado;
    public DataReserva() {
    }

    public DataReserva(int numero, LocalDate fecha, int precio, String cliente, ArrayList<cantidadReservasServicios> serviciosReserva, ArrayList<cantidadReservasPromociones> reservaPromociones) {
        this.numero = numero;
        this.fecha = fecha;
        this.precio = precio;
        this.cliente = cliente;
        this.serviciosReserva = serviciosReserva;
        this.reservaPromociones = reservaPromociones;
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

    public ArrayList<cantidadReservasServicios> getServiciosReserva() {
        return serviciosReserva;
    }

    public void setServiciosReserva(ArrayList<cantidadReservasServicios> serviciosReserva) {
        this.serviciosReserva = serviciosReserva;
    }

    public ArrayList<cantidadReservasPromociones> getReservaPromociones() {
        return reservaPromociones;
    }

    public void setReservaPromociones(ArrayList<cantidadReservasPromociones> reservaPromociones) {
        this.reservaPromociones = reservaPromociones;
    }
        public String getEstado(){
        return estado;
        
    }
    public void setEstado(String estado){
        this.estado=estado;
    }
    
}
