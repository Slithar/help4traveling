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
    private String Nickname;
    private String Nombre;
    private String Apellido;
    private String Email;
    private Date FechaNac;
    private Imagen ImagenCliente;

    public Imagen getImagenCliente() {
        return ImagenCliente;
    }

    public void setImagenCliente(Imagen ImagenCliente) {
        this.ImagenCliente = ImagenCliente;
    }

    public String getNickname() {
        return Nickname;
    }

    public void setNickname(String Nickname) {
        this.Nickname = Nickname;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public Date getFechaNac() {
        return FechaNac;
    }

    public void setFechaNac(Date FechaNac) {
        this.FechaNac = FechaNac;
    }
    
}
