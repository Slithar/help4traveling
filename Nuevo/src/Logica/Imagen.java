/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;
import java.io.*;
import java.util.*;
import java.nio.file.*;
/**
 *
 * @author Mauro
 */
public class Imagen {
    private String path;
    /*private Cliente cliente;
    private Proveedor proveedor;*/
    private Usuario usuario;
    
    public Imagen(String path, Usuario usuario){
        this.path = path;
        this.usuario = usuario;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    /*public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }*/
    
    public Usuario getUsuario(){
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }
    
    public void copiarImagen(String nombre) throws IOException{
        Path desde = Paths.get(this.path);
        File fichero = new File("src/Logica/Perfiles/" + nombre + ".jpg");
        Path hasta = Paths.get(fichero.getAbsolutePath());
       
        CopyOption[] opciones = new CopyOption[]{
          StandardCopyOption.REPLACE_EXISTING,
          StandardCopyOption.COPY_ATTRIBUTES
        };
       
        Files.copy(desde, hasta, opciones);
        this.path = "src/Logica/perfiles/" + nombre + ".jpg";
        
        
    }
    
}
