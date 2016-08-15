/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;
import java.sql.*;
import Datos.ConexionBD;
import Logica.Ciudad;
import Logica.Pais;
import java.util.ArrayList;

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
    public ResultSet verInfoReserva()throws SQLException, ClassNotFoundException{
        ResultSet res=null;
         Connection conn;
        
        ConexionBD conexion = new ConexionBD();
        
        conn = conexion.conectar();
        
        Statement st = conn.createStatement();
        try{
        res = st.executeQuery("select *,  from cantidadreservas");
             
        } catch (Exception e) {
            System.out.println("Problema al consultar la base de datos 1 ");
        }
        res.close();
        //conexion.cerrar();
        conn.close();
        
        return res;
        
    }
           
}
