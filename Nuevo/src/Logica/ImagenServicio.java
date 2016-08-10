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
public class ImagenServicio {
    private String path;
    private Servicio servicio;
    
    public ImagenServicio(){
        this.path = "";
        this.servicio = new Servicio();
    }
    
    public ImagenServicio(String path, Servicio servicio){
        this.path = path;
        this.servicio = servicio;
    }
    
    public String getPath(){
        return this.path;
    }
    
    public Servicio getServicio(){
        return this.servicio;
    }
    
    public void setPath(String path){
        this.path = path;
    }
    
    public void setServicio(Servicio servicio){
        this.servicio = servicio;
    }
    
}
