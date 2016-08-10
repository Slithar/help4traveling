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
    private Imagen imagenUsuario;
    
    /*Comentario para GIT*/
    
    public Usuario(){
        nickname = "";
        nombre = "";
        apellido = "";
        email = "";
        fechaNac = LocalDate.of(1900, 1, 1);
        imagenUsuario = new Imagen("../Logica/perfiles/perfil.PNG", this);
        
    }
    
    public Usuario(String nickname, String nombre, String apellido, String email, LocalDate fechaNac, String rutaImagen){
        
        this.nickname = nickname;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.fechaNac = fechaNac;
        Imagen imagenUsuario = new Imagen(rutaImagen, this);
        this.imagenUsuario = imagenUsuario;        
    }

    public Imagen getImagenUsuario() {
        return imagenUsuario;
    }

    public void setImagenUsuario(Imagen imagenUsuario) {
        this.imagenUsuario = imagenUsuario;
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
    
    /*public boolean fechaValida(){
        
        if(fechaNac.getMonthValue() == 1 || fechaNac.getMonthValue() == 3 || fechaNac.getMonthValue() == 5 || fechaNac.getMonthValue() == 7 || fechaNac.getMonthValue() == 8 || fechaNac.getMonthValue() == 10 || fechaNac.getMonthValue() == 12){
            return true;
        }
        else if(fechaNac.getMonthValue() == 4 || fechaNac.getMonthValue() == 6 || fechaNac.getMonthValue() == 9 || fechaNac.getMonthValue() == 11){
            if(fechaNac.getDayOfMonth()== 31)
                return false;
            else
                return true;
        }
        else{
            if(fechaNac.getDayOfMonth() == 30 || fechaNac.getDayOfMonth() == 31)
                return false;
            else
                return true;
        }
    }*/
    
    public boolean copiarPerfil() throws IOException{
        imagenUsuario.copiarImagen(this.nickname);
        return true;
        
    }
    
}
