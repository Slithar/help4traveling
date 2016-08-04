/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;
import java.util.*;
/**
 *
 * @author Mauro
 */
public class Reserva {
    private int numero;

    private Date fecha;
    private int precio;
    private ArrayList<Cliente> clientes;
  //  private ArrayList<Reserva> Reserva; wtf una lista de reservas en la clase reserva. piré
    private ArrayList<Servicio> serviciosReserva;
    private ArrayList<Promocion> reservaPromociones;
    //falta estado
    
    public Reserva() {
        
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
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


    public ArrayList<Cliente> getCliente() {
        return clientes;
    }

    public void setCliente(ArrayList<Cliente> Cliente) {
        this.clientes = Cliente;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int Numero) {
        this.numero = Numero;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date Fecha) {
        this.fecha = Fecha;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int Precio) {
        this.precio = Precio;
    }
    
}
