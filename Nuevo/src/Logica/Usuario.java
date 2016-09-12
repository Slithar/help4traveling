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
    private String pass;    
    
        
    public Usuario(){
        nickname = "";
        nombre = "";
        apellido = "";
        email = "";
        fechaNac = LocalDate.of(1900, 1, 1);  
        pass = "";
    }
    
    public Usuario(String nickname, String nombre, String apellido, String email, LocalDate fechaNac, String pass){
        
        this.nickname = nickname;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.fechaNac = fechaNac;
        this.pass = pass;
        
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

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }   
    
    
    public boolean correoValido(){
        int cantArrobas = 0;
        int cantPuntos = 0;
        
        int posicionArroba = 0;
        int posicionPunto = 0;
        
        if(this.email.charAt(0) == '@' || this.email.charAt(0) == '.')
            return false;
        else if(this.email.charAt(this.email.length() - 1) == '@' || this.email.charAt(this.email.length() - 1) == '.')
            return false;
        
        for(int i = 0; i < this.email.length(); i++){
            if(this.email.charAt(i) == '@'){
                cantArrobas++;
                posicionArroba = i;
            }
            if(this.email.charAt(i) == '.'){
                cantPuntos++;
                posicionPunto = i;
            }
        }
        if(cantArrobas == 1 && cantPuntos > 0)
            if(posicionPunto > posicionArroba)
                return true;
            else
                return false;
        else
            return false;
    }   
}
