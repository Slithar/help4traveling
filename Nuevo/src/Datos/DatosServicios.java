/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.*;


/**
 *
 * @author usuario
 */
public class DatosServicios {
    
    private ConexionBD conexion;
    
    public DatosServicios(){
        conexion = new ConexionBD();
    }
    
    public int selectCountNombreServicio(String nombre) throws SQLException, ClassNotFoundException{
        Connection conn = conexion.conectar();
        
        PreparedStatement pConsulta = conn.prepareStatement("select count(*) cantidad from servicios where nombre = ?");
        
        pConsulta.setString(1, nombre);
        
        ResultSet rs = pConsulta.executeQuery();
        
        int resultado = 0;
        
        while(rs.next()){
            resultado = rs.getInt("cantidad");
        }
        
        
        rs.close();
        conexion.cerrar();
        
        return resultado;
    }
    
}
