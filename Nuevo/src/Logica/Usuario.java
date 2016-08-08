/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Logica;
import java.io.IOException;
import java.util.*;

/**
 *
 * @author Mauro
 */
public class Usuario {
    private String nickname;
    private String nombre;
    private String apellido;
    private String email;
    private Fecha fechaNac;
    private Imagen imagenUsuario;
    
    public Usuario(){
        nickname = "";
        nombre = "";
        apellido = "";
        email = "";
        fechaNac = new Fecha();
        imagenUsuario = new Imagen("perfiles/perfil.PNG", this);
        
    }
    
    public Usuario(String nickname, String nombre, String apellido, String email, Fecha fechaNac, String rutaImagen){
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

    public Fecha getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Fecha FechaNac) {
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
    
    public boolean fechaValida(){
        /*String[] fecha = this.fechaNac.split("-");
        if("1".equals(fecha[1]) || "3".equals(fecha[1]) || "5".equals(fecha[1]) || "7".equals(fecha[1]) || "8".equals(fecha[1]) || "10".equals(fecha[1]) || "12".equals(fecha[1])){
            return true;
        }
        else{
            if("4".equals(fecha[1]) || "6".equals(fecha[1]) || "9".equals(fecha[1]) || "11".equals(fecha[1])){
                if("31".equals(fecha[2]))
                    return false;
                else 
                    return true;
            }
            else{
                if("30".equals(fecha[2]) || "31".equals(fecha[2]))
                    return false;
                else 
                    return true;
            }
        }*/
        if(fechaNac.getMes() == 1 || fechaNac.getMes() == 3 || fechaNac.getMes() == 5 || fechaNac.getMes() == 7 || fechaNac.getMes() == 8 || fechaNac.getMes() == 10 || fechaNac.getMes() == 12){
            return true;
        }
        else if(fechaNac.getMes() == 4 || fechaNac.getMes() == 6 || fechaNac.getMes() == 9 || fechaNac.getMes() == 11){
            if(fechaNac.getDia() == 31)
                return false;
            else
                return true;
        }
        else{
            if(fechaNac.getDia() == 30 || fechaNac.getDia() == 31)
                return false;
            else
                return true;
        }
    }
    
    public boolean copiarPerfil() throws IOException{
        imagenUsuario.copiarImagen(this.nickname);
        return true;
        
    }
    
}
