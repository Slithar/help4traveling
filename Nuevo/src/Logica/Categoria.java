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
    private String rutaCategoria;
    private ArrayList<Servicio> servicios;

    public Categoria(){
        
    }
    
    public Categoria(String nombre, String rutaCategoria, ArrayList servicios){
        this.nombre = nombre;
        this.rutaCategoria = rutaCategoria;
        this.servicios = servicios;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String Nombre) {
        this.nombre = Nombre;
    }
    
    public String getRutaCategoria(){
        return this.rutaCategoria;
    }
    
    public void setRutaCategoria(String rutaCategoria){
        this.rutaCategoria = rutaCategoria;
    }

    public ArrayList<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(ArrayList<Servicio> Servicios) {
        this.servicios = Servicios;
    }
}
