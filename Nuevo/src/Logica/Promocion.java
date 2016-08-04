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
public class Promocion {
    private String Nombre;
    private int Descuento;
    private int Precio;
    private ArrayList<Servicio> Servicios;
    private ArrayList<Reserva> Reservas;

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getDescuento() {
        return Descuento;
    }

    public void setDescuento(int Descuento) {
        this.Descuento = Descuento;
    }

    public int getPrecio() {
        return Precio;
    }

    public void setPrecio(int Precio) {
        this.Precio = Precio;
    }

    public ArrayList<Servicio> getServicios() {
        return Servicios;
    }

    public void setServicios(ArrayList<Servicio> Servicios) {
        this.Servicios = Servicios;
    }

    public ArrayList<Reserva> getReservas() {
        return Reservas;
    }

    public void setReservas(ArrayList<Reserva> Reservas) {
        this.Reservas = Reservas;
    }
}
