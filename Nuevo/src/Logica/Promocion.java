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
    private String nombre;
    private int descuento;
    private int precio;
    private ArrayList<Servicio> Servicios;
    private ArrayList<Reserva> Reservas;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String Nombre) {
        this.nombre = Nombre;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int Descuento) {
        this.descuento = Descuento;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int Precio) {
        this.precio = Precio;
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