/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;
import java.io.IOException;
import java.util.*;
import java.time.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Mauro
 */
public class Proveedor extends Usuario {
    private ArrayList<Imagen> imagenesUsuario;
    private HashMap<String, Servicio> servicios;
    private String nombreEmpresa;
    private String link;
    
    public Proveedor(){
        super();
        nombreEmpresa = "";
        link = "";
        this.servicios = new HashMap<String, Servicio>();
    }
    
    public Proveedor(String nickname, String nombre, String apellido, String email, LocalDate fechaNac, ArrayList<String> rutaProveedor, String nombreEmpresa, String link, HashMap<String, Servicio> servicios){
        super(nickname, nombre, apellido, email, fechaNac);
        
        this.imagenesUsuario = new ArrayList<Imagen>();
        
        this.nombreEmpresa = nombreEmpresa;
        this.link = link;
        //JOptionPane.showMessageDialog(null, rutaProveedor.size());
        for(int i = 0; i < rutaProveedor.size(); i++){
            //JOptionPane.showMessageDialog(null, rutaProveedor.get(i));
            this.imagenesUsuario.add(new Imagen(rutaProveedor.get(i), this));
        }
        this.servicios = servicios;
    }
    
    public String getNombreEmpresa(){
        return this.nombreEmpresa;
    }
    
    public String getLink(){
        return this.link;
    }
    
    public void setNombreEmpresa(String nombreEmpresa){
        this.nombreEmpresa = nombreEmpresa;
    }
    
    public void setLink(String link){
        this.link = link;
    }

    public ArrayList<Imagen> getImagenesUsuario() {
        return imagenesUsuario;
    }

    public void setImagenesUsuario(ArrayList<Imagen> imagenesUsuario) {
        this.imagenesUsuario = imagenesUsuario;
    }
    
    public void setImagen(ArrayList<String> ruta){
        for(int i = 0; i < ruta.size(); i++){
            this.imagenesUsuario.add(new Imagen(ruta.get(i), this));
        }
        
    }
    
    public boolean copiarPerfil() throws IOException{
        for(int i = 0; i < imagenesUsuario.size(); i++){
            int num = i + 1;
            imagenesUsuario.get(i).copiarImagen(super.getNickname() + "-" + num);
        }
        
        return true;
        
    }

    public HashMap<String, Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(HashMap<String, Servicio> servicios) {
        this.servicios = servicios;
    }
    
    public boolean sitioWebValido(){
        int i = 0;
        
        while(i < this.link.length()){
            if(this.link.charAt(i) == '.')
                return true;
            
            i++;
        }
        
        return false;
    }
}
