/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;
import java.sql.*;
import Datos.ConexionBD;

/**
 *
 * @author Mauro
 */
public class Datos {
    public Datos(){
        
    }
    
    public String probar() throws SQLException, ClassNotFoundException{
        ConexionBD c = new ConexionBD();
        
        
        c.conectar();
        String resultado = "listoo";
        
        c.cerrar();
        
        return resultado;
    }
}
