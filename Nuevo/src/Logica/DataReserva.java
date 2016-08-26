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
    private  Cliente clientes;
    private ArrayList<DatacantidadReservasServicios> serviciosReserva;
    private ArrayList<DatacantidadReservasPromociones> reservaPromociones;    
    String  estado;
    
    public DataReserva() {
    }

    public DataReserva(int numero, LocalDate fecha, int precio, Cliente clientess, ArrayList<DatacantidadReservasServicios> serviciosReserva, ArrayList<DatacantidadReservasPromociones> reservaPromociones) {
        this.numero = numero;
        this.fecha = fecha;
        this.precio = precio;
        this.clientes = clientess;
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

    public Cliente getCliente() {
        return clientes;
    }

    public void setCliente(Cliente clientes) {
        this.clientes = clientes;
    }

    public ArrayList<DatacantidadReservasServicios> getServiciosReserva() {
        return serviciosReserva;
    }

    public void setServiciosReserva(ArrayList<DatacantidadReservasServicios> serviciosReserva) {
        this.serviciosReserva = serviciosReserva;
    }

    public ArrayList<DatacantidadReservasPromociones> getReservaPromociones() {
        return reservaPromociones;
    }

    public void setReservaPromociones(ArrayList<DatacantidadReservasPromociones> reservaPromociones) {
        this.reservaPromociones = reservaPromociones;
    }
        public String getEstado(){
        return estado;
        
    }
    public void setEstado(String estado){
        this.estado=estado;
    }
    
}
