/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author usuario
 */
public class ControladorPromociones implements IControladorPromociones{
    
    public ControladorPromociones(){
        
    }
    public int devolverPrecio(String cadena){
        String [] array = cadena.split(",");
        int A = Integer.parseInt(array[1].trim());
        return A;
    }
}
