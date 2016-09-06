/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;
import Logica.Imagen;
import Logica.Usuario;
import java.sql.*;
import java.util.*;

/**
 *
 * @author usuario
 */
public class DatosUsuarios {
        
    public DatosUsuarios(){
        
    }
    
    public int selectCountUsuarios(String nickname) throws SQLException, ClassNotFoundException{
        int num = 0;
        
                
        Connection conn;
        
        ConexionBD conexion = new ConexionBD();
        
        conn = conexion.conectar();
               
        PreparedStatement pConsulta = conn.prepareStatement("select count(*) cantidad from usuarios where nickname = ?");
        
        pConsulta.setString(1, nickname);
        
        ResultSet rs = pConsulta.executeQuery();
        while(rs.next()){
            num = rs.getInt("cantidad");
        }
        
        rs.close();
        conn.close();
        
        return num;
        
    }
    
    public ArrayList<Imagen> selectImagenesPerfil(Usuario u) throws SQLException, ClassNotFoundException{
        
        ArrayList<Imagen> imagenes = new ArrayList<Imagen>();
        
        ConexionBD conexion = new ConexionBD();
        
        Connection conn;
        
        conn = conexion.conectar();
        
        PreparedStatement pConsulta = conn.prepareStatement("select * from imagenesusuarios where nickname = ?");
        
        pConsulta.setString(1, u.getNickname());
                
        ResultSet rs = pConsulta.executeQuery();
        
        while(rs.next()){
            imagenes.add(new Imagen(rs.getString("ruta"), u));
        }
        
        rs.close();
        conn.close();
        
        return imagenes;
        
    }
    
    public Imagen selectImagenPerfil(Usuario u) throws SQLException, ClassNotFoundException{
        
        Imagen imagen = new Imagen("", u);
        
        ConexionBD conexion = new ConexionBD();
        
        Connection conn;
        
        conn = conexion.conectar();
        
        PreparedStatement pConsulta = conn.prepareStatement("select * from imagenesusuarios where nickname = ?");
        
        pConsulta.setString(1, u.getNickname());
                
        ResultSet rs = pConsulta.executeQuery();
        
        while(rs.next()){
            imagen = new Imagen(rs.getString("ruta"), u);
        }
        
        rs.close();
        conn.close();
        
        return imagen;
        
    }
    
    public int cantidadEmail(String email) throws SQLException, ClassNotFoundException{
        
        int cant = 0;
        
        ConexionBD conexion = new ConexionBD();
        
        Connection conn;
        
        conn = conexion.conectar();
        
        PreparedStatement pConsulta = conn.prepareCall("select count(*) cantidad from usuarios where email = ?");
        
        pConsulta.setString(1, email);
        
        ResultSet rs = pConsulta.executeQuery();
        
        while(rs.next()){
            cant = rs.getInt("cantidad");
        }
        
        rs.close();
        conn.close();
        
        return cant;
    }
}
