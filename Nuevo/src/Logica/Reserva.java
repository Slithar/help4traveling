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
 * @author Mauro
 */
public class Reserva {
    private int numero;
    private LocalDate fecha;
    private int precio;
    private Cliente cliente;
    private ArrayList<cantidadReservasServicios> serviciosReserva;
    private ArrayList<cantidadReservasPromociones> reservacantPromociones;
    private Estado estado;
    
    public Reserva() {
        this.numero = 0;
        this.fecha = LocalDate.of(1990, 1, 1);
        this.cliente=new Cliente();
        this.estado=Estado.REGISTRADA;
        this.serviciosReserva=new ArrayList();
        this.reservacantPromociones=new ArrayList();               
    }

    public Reserva(int numero, LocalDate fecha, int precio, Cliente cliente, ArrayList<cantidadReservasServicios> serviciosReserva, ArrayList<cantidadReservasPromociones> reservacantPromociones, Estado estado) {
        this.numero = numero;
        this.fecha = fecha;
        this.precio = precio;
        this.cliente = cliente;
        this.serviciosReserva = serviciosReserva;
        this.reservacantPromociones = reservacantPromociones;
        this.estado = estado;
    }
    
    

    public Cliente getCliente() {
        return cliente;
    }
    public Estado getEstado(){
        return estado;
        
    }
    public void setEstado(String estado){        
        this.estado = Estado.obtenerEstado(estado);
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<cantidadReservasServicios> getServiciosReserva() {
        return serviciosReserva;
    }

    public void setServiciosReserva(ArrayList<cantidadReservasServicios> serviciosReserva) {
        this.serviciosReserva = serviciosReserva;
    }
    
    public ArrayList<cantidadReservasPromociones> getReservacantPromociones() {
        return reservacantPromociones;
    }
    

    public void setReservacantPromociones(ArrayList<cantidadReservasPromociones> ReservaPromociones) {
        this.reservacantPromociones = ReservaPromociones;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int Numero) {
        this.numero = Numero;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate Fecha) {
        this.fecha = Fecha;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int Precio) {
        this.precio = Precio;
    }
     
    
    
}
