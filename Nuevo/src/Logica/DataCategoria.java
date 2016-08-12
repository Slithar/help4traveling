/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author usuario
 */
public class DataCategoria {
    private String nombre;
    private String rutaCategoria;

    public DataCategoria() {
    }

    public DataCategoria(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getRutaCategoria() {
        return rutaCategoria;
    }

    public void setRutaCategoria(String rutaCategoria) {
        this.rutaCategoria = rutaCategoria;
    }
   
}
