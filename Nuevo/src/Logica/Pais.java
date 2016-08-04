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
public class Pais {
    private String Nombre;
    private ArrayList<Ciudad> Ciudades;
    
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public ArrayList<Ciudad> getCiudades() {
        return Ciudades;
    }

    public void setCiudades(ArrayList<Ciudad> Ciudades) {
        this.Ciudades = Ciudades;
    }
    
}
