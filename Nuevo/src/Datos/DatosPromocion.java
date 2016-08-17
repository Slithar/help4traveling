/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Mauro
 */
public class DatosPromocion {

    public DatosPromocion() {
    }
    
    public int agregarPromo(String nombrePromo, int descuentoPromo, int precioPromo ) throws SQLException,ClassNotFoundException{
        int resultado=0;
        
        Connection conn;
        
        ConexionBD conexion = new ConexionBD();
        
        conn = conexion.conectar();
        
        PreparedStatement pConsulta = conn.prepareStatement("INSERT INTO promociones VALUES(?,?,?)"); 
        
        pConsulta.setString(1,nombrePromo);
        
        pConsulta.setInt(2,descuentoPromo );
        
        pConsulta.setInt(3,precioPromo);
        
        resultado = pConsulta.executeUpdate();
        
        return resultado;
    }
    public int agregarServiciosPromo(String nombrePromo, String nombreServicio,String nombreProveedor)throws SQLException, ClassNotFoundException{
        int resultado=0;
        
        Connection conn;
        
        ConexionBD conexion = new ConexionBD();
        
        conn = conexion.conectar();
        
        PreparedStatement pConsulta = conn.prepareStatement("INSERT INTO serviciosdepromociones VALUES(?,?,?)"); 
        
        pConsulta.setString(1,nombrePromo);
        
        pConsulta.setString(2, nombreServicio);
        
        pConsulta.setString(3, nombreProveedor);
        
        resultado = pConsulta.executeUpdate();
        
        return resultado;
    }
}
