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
    private ArrayList<Categoria> categoriasHijas;

    public Categoria(){
        this.nombre = "";
        this.rutaCategoria = "";
        this.categoriasHijas = new ArrayList<Categoria>();
    }
    
    public Categoria(String nombre, String rutaCategoria, ArrayList<Categoria> categoriasHijas){
        this.nombre = nombre;
        this.rutaCategoria = rutaCategoria;
        this.categoriasHijas = categoriasHijas;
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

    public ArrayList<Categoria> getCategoriasHijas() {
        return categoriasHijas;
    }

    public void setCategoriasHijas(ArrayList<Categoria> categoriasHijas) {
        this.categoriasHijas = categoriasHijas;
    }

    
}
