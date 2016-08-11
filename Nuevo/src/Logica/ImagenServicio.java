/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.*;
import java.nio.file.*;

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
    
    public void copiarImagen(String nombre) throws IOException{
        Path desde = Paths.get(this.path);
        File fichero = new File("src/Logica/ImagenesServicios/" + nombre + ".jpg");
        Path hasta = Paths.get(fichero.getAbsolutePath());
       
        CopyOption[] opciones = new CopyOption[]{
          StandardCopyOption.REPLACE_EXISTING,
          StandardCopyOption.COPY_ATTRIBUTES
        };
       
        Files.copy(desde, hasta, opciones);
        this.path = "../Logica/ImagenesServicios/" + nombre + ".jpg";       
    }
    
}
