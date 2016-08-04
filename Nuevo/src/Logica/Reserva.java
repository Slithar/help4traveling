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
    private ArrayList<Cliente> Clientes;
  //  private ArrayList<Reserva> Reserva; wtf una lista de reservas en la clase reserva. piré
    private ArrayList<Promocion> reservaPromociones;
    //falta estado

    public ArrayList<Promocion> getReservaPromociones() {
        return reservaPromociones;
    }

    public void setReservaPromociones(ArrayList<Promocion> ReservaPromociones) {
        this.reservaPromociones = ReservaPromociones;
    }


    public ArrayList<Cliente> getCliente() {
        return cliente;
    }

    public void setCliente(ArrayList<Cliente> Cliente) {
        this.cliente = Cliente;
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
