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
   private ArrayList<Reserva> ReservasCliente;

    public ArrayList<Reserva> getReservasCliente() {
        return ReservasCliente;
    }

    public void setReservasCliente(ArrayList<Reserva> ReservasCliente) {
        this.ReservasCliente = ReservasCliente;
    }
    
}
