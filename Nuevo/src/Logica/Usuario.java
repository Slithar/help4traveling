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
public class Usuario {
    private String nickname;
    private String nombre;
    private String apellido;
    private String email;
    private Date fechaNac;
    private Imagen imagenCliente;

    public Imagen getImagenCliente() {
        return imagenCliente;
    }

    public void setImagenCliente(Imagen ImagenCliente) {
        this.imagenCliente = ImagenCliente;
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

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date FechaNac) {
        this.fechaNac = FechaNac;
    }
    
}
