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
public class Cliente extends Usuario {
    private ArrayList<Reserva> reservasCliente;
    
    public Cliente(){
        super();
        reservasCliente = new ArrayList();
        
    }
    
    public Cliente(String nickname, String nombre, String apellido, String email, String fechaNac, String rutaCliente, ArrayList reservasCliente){
        super(nickname, nombre, apellido, email, fechaNac, rutaCliente);
        this.reservasCliente = reservasCliente;  
    }
   
    public ArrayList<Reserva> getReservasCliente() {
        return reservasCliente;
    }

    public void setReservasCliente(ArrayList<Reserva> ReservasCliente) {
        this.reservasCliente = ReservasCliente;
    }
    
}
