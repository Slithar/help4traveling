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
    private Cliente clientes;
  //  private ArrayList<Reserva> Reserva; wtf una lista de reservas en la clase reserva. piré
    private ArrayList<Servicio> serviciosReserva;
    private ArrayList<Promocion> reservaPromociones;
    private ArrayList<cantidadReservasPromociones> reservacantPromociones;
    String  estado;
    
    public Reserva() {
        
    }

    public Cliente getCliente() {
        return clientes;
    }
    public String getEstado(){
        return estado;
        
    }
    public void setEstado(String estado){
        this.estado=estado;
    }

    public void setCliente(Cliente clientes) {
        this.clientes = clientes;
    }

    public ArrayList<Servicio> getServiciosReserva() {
        return serviciosReserva;
    }

    public void setServiciosReserva(ArrayList<Servicio> serviciosReserva) {
        this.serviciosReserva = serviciosReserva;
    }
    
    public ArrayList<Promocion> getReservaPromociones() {
        return reservaPromociones;
    }
    

    public void setReservaPromociones(ArrayList<Promocion> ReservaPromociones) {
        this.reservaPromociones = ReservaPromociones;
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
