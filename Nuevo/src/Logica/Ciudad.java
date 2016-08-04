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
    private String Nombre;
    private ArrayList<Servicio> Servicio;
    private Pais Pais;

    public Pais getPais() {
        return Pais;
    }

    public void setPais(Pais Pais) {
        this.Pais = Pais;
    }
    
    // No tengo muy claro como hacer la relación de este lado de las clases....
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public ArrayList<Servicio> getServicio() {
        return Servicio;
    }

    public void setServicio(ArrayList<Servicio> Servicio) {
        this.Servicio = Servicio;
    }
}
