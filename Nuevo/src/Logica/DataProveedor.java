/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.time.*;
import java.util.ArrayList;

/**
 *
 * @author usuario
 */
public class DataProveedor {
    
    private String nickname;
    private String nombre;
    private String apellido;
    private String email;
    private LocalDate fechaNac;
    private String fechaProveedor;
    private ArrayList<String> rutaImagen;
    private String nombreEmpresa;
    private String link;

    public DataProveedor() {
    }

    public DataProveedor(String nickname, String nombre, String apellido, String email, LocalDate fechaNac, ArrayList<String> rutaImagen, String nombreEmpresa, String link) {
        this.nickname = nickname;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.fechaNac = fechaNac;
        this.rutaImagen = rutaImagen;
        this.nombreEmpresa = nombreEmpresa;
        this.link = link;
        
        String fechaProv = fechaNac.toString();
        String[] fechaPartida = fechaProv.split("-");
        this.fechaProveedor = fechaPartida[2] + "/" + fechaPartida[1] + "/" + fechaPartida[0];
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
        
        String fechaProv = fechaNac.toString();
        String[] fechaPartida = fechaProv.split("-");
        this.fechaProveedor = fechaPartida[2] + "/" + fechaPartida[1] + "/" + fechaPartida[0];
    }

    public ArrayList<String> getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(ArrayList<String> rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getFechaProveedor() {
        return fechaProveedor;
    }

    public void setFechaProveedor(String fechaProveedor) {
        this.fechaProveedor = fechaProveedor;
    }   
    
}
