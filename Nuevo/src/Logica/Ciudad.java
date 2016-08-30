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

    /*public Ciudad() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
    
    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais Pais) {
        this.pais = Pais;
    }
    
    // No tengo muy claro como hacer la relación de este lado de las clases....
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String Nombre) {
        this.nombre = Nombre;
    }
}
