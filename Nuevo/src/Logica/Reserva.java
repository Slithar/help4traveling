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
    private int Numero;
    private Date Fecha;
    private int Precio;
    private ArrayList<Cliente> Cliente;
    private ArrayList<Reserva> Reserva;
    private ArrayList<Promocion> ReservaPromociones;
    //falta estado

    public ArrayList<Promocion> getReservaPromociones() {
        return ReservaPromociones;
    }

    public void setReservaPromociones(ArrayList<Promocion> ReservaPromociones) {
        this.ReservaPromociones = ReservaPromociones;
    }

    public ArrayList<Reserva> getReserva() {
        return Reserva;
    }

    public void setReserva(ArrayList<Reserva> Reserva) {
        this.Reserva = Reserva;
    }

    public ArrayList<Cliente> getCliente() {
        return Cliente;
    }

    public void setCliente(ArrayList<Cliente> Cliente) {
        this.Cliente = Cliente;
    }

    public int getNumero() {
        return Numero;
    }

    public void setNumero(int Numero) {
        this.Numero = Numero;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public int getPrecio() {
        return Precio;
    }

    public void setPrecio(int Precio) {
        this.Precio = Precio;
    }
    
}
