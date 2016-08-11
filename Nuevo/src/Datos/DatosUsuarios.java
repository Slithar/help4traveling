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
public class DatosUsuarios {
    
    //private ConexionBD conexion;
    
    public DatosUsuarios(){
        //conexion = new ConexionBD();
    }
    
    public int selectCountUsuarios(String nickname) throws SQLException, ClassNotFoundException{
        int num = 0;
       // Statement st = null;
        
                
        Connection conn;
        
        ConexionBD conexion = new ConexionBD();
        
        conn = conexion.conectar();
               
        PreparedStatement pConsulta = conn.prepareStatement("select count(*) cantidad from usuarios where nickname = ?");
        
        pConsulta.setString(1, nickname);
        
        ResultSet rs = pConsulta.executeQuery();
        
        //rs = st.executeQuery("select count(*) cantidad from usuarios where nickname = 'hola'");
        
        //num = rs.getInt("cantidad");
        while(rs.next()){
            num = rs.getInt("cantidad");
        }
        
        rs.close();
        //conexion.cerrar();
        conn.close();
        
        return num;
        
    }
}
