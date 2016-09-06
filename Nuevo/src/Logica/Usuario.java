/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Logica;
import java.io.IOException;
import java.io.*;
import java.util.*;
import java.time.*;

/**
 *
 * @author Mauro
 */
public class Usuario {
    private String nickname;
    private String nombre;
    private String apellido;
    private String email;
    private LocalDate fechaNac;
    
    
        
    public Usuario(){
        nickname = "";
        nombre = "";
        apellido = "";
        email = "";
        fechaNac = LocalDate.of(1900, 1, 1);       
    }
    
    public Usuario(String nickname, String nombre, String apellido, String email, LocalDate fechaNac){
        
        this.nickname = nickname;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.fechaNac = fechaNac;
             
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String Nickname) {
        this.nickname = Nickname;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String Nombre) {
        this.nombre = Nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String Apellido) {
        this.apellido = Apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String Email) {
        this.email = Email;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate FechaNac) {
        this.fechaNac = FechaNac;
    } 
    
    
    
    public boolean correoValido(){
        int cantArrobas = 0;
        for(int i = 0; i < this.email.length(); i++){
            if(this.email.charAt(i) == '@')
                cantArrobas++;
        }
        if(cantArrobas == 1)
            return true;
        else
            return false;
    }   
}
