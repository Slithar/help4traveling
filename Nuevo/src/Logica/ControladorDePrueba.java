/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;
import java.sql.*;
import Datos.Datos;

/**
 *
 * @author usuario
 */
public class ControladorDePrueba {
    
    public ControladorDePrueba(){
       
    }
    
    public String pruebaBD() throws SQLException, ClassNotFoundException{
        Datos d = new Datos();
        
        return d.probar();
    }
    
}
