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
public class Categoria {
    private String nombre;
    private ArrayList<Servicio> Servicios;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String Nombre) {
        this.nombre = Nombre;
    }

    public ArrayList<Servicio> getServicios() {
        return Servicios;
    }

    public void setServicios(ArrayList<Servicio> Servicios) {
        this.Servicios = Servicios;
    }
}
