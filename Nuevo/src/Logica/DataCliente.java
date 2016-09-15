/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.time.*;
import java.util.*;

/**
 *
 * @author usuario
 */
public class DataCliente {
    
    private String nickname;
    private String nombre;
    private String apellido;
    private String email;
    private LocalDate fechaNac;
    private String rutaImagen;
    private HashMap<Integer, DataReserva> reservas;
    private String password;
    public DataCliente() {
        
    }

    public DataCliente(String nickname, String nombre, String apellido, String email, LocalDate fechaNac, String rutaImagen, HashMap reservas) {
        this.nickname = nickname;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.fechaNac = fechaNac;
        this.rutaImagen = rutaImagen;
        this.reservas = reservas;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    
    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public HashMap<Integer, DataReserva> getReservas() {
        return reservas;
    }

    public void setReservas(HashMap<Integer, DataReserva> reservas) {
        this.reservas = reservas;
    }
    
    
     
    
}
 