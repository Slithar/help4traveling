/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.*;

/**
 *
 * @author usuario
 */
public class DataPromocion {
    private String nombre;
    private int descuento;
    private int precio;

    public DataPromocion() {
    }

    public DataPromocion(String nombre, int descuento, int precio) {
        this.nombre = nombre;
        this.descuento = descuento;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
    
}
