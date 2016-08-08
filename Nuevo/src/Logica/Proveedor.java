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
public class Proveedor extends Usuario {
    private String nombreEmpresa;
    private String link;
    
    public Proveedor(){
        super();
        nombreEmpresa = "";
        link = "";
    }
    
    public Proveedor(String nickname, String nombre, String apellido, String email, Fecha fechaNac, String rutaProveedor, String nombreEmpresa, String link){
        super(nickname, nombre, apellido, email, fechaNac, rutaProveedor);
        this.nombreEmpresa = nombreEmpresa;
        this.link = link;
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
}
