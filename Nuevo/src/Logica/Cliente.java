/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;
import java.io.IOException;
import java.util.*;
import java.time.*;
/**
 *
 * @author Mauro
 */
public class Cliente extends Usuario {
    private Imagen imagenUsuario;
    private HashMap<Integer, Reserva> reservasCliente;
    
    public Cliente(){
        super();
        imagenUsuario = new Imagen("../Logica/perfiles/perfil.PNG", this);
        reservasCliente = new HashMap<Integer, Reserva>();
        
    }
    
    public Cliente(String nickname, String nombre, String apellido, String email, LocalDate fechaNac, String rutaCliente, HashMap<Integer, Reserva> reservasCliente){
        super(nickname, nombre, apellido, email, fechaNac);
        Imagen imagenUsuario = new Imagen(rutaCliente, this);
        this.imagenUsuario = imagenUsuario;   
        this.reservasCliente = reservasCliente;  
    }
   
    public HashMap<Integer, Reserva> getReservasCliente() {
        return reservasCliente;
    }

    public void setReservasCliente(HashMap<Integer, Reserva> ReservasCliente) {
        this.reservasCliente = ReservasCliente;
    }

    public Imagen getImagenUsuario() {
        return imagenUsuario;
    }

    public void setImagenUsuario(Imagen imagenUsuario) {
        this.imagenUsuario = imagenUsuario;
    }
    
    public void setImagen(String ruta){
        this.imagenUsuario = new Imagen(ruta, this);
    }
    
    public boolean copiarPerfil() throws IOException{
        imagenUsuario.copiarImagen(super.getNickname());
        return true;
        
    }
}
