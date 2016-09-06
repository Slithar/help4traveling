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
public class Ciudad {
    private String nombre;
    private Pais pais;
    
    public Ciudad(){
        this.nombre = "No";
        this.pais = new Pais();
    }

    public Ciudad(String nombre, ArrayList servicios, Pais pais){
        this.nombre = nombre;
        this.pais = pais;
    }
    
    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais Pais) {
        this.pais = Pais;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String Nombre) {
        this.nombre = Nombre;
    }
}
