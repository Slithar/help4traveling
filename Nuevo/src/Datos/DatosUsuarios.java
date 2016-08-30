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
    
    public ArrayList<Imagen> selectImagenesPerfil(Usuario u) throws SQLException, ClassNotFoundException{
        
        ArrayList<Imagen> imagenes = new ArrayList<Imagen>();
        
        ConexionBD conexion = new ConexionBD();
        
        Connection conn;
        
        conn = conexion.conectar();
        
        //Statement st = conn.createStatement();
        
        PreparedStatement pConsulta = conn.prepareStatement("select * from imagenesusuarios where nickname = ?");
        
        pConsulta.setString(1, u.getNickname());
                
        ResultSet rs = pConsulta.executeQuery();
        
        while(rs.next()){
            //categorias.add(new Proveedor(rs.getString("nombre"), "", new ArrayList()));
            /*String fecha = rs.getString("fechaNacimiento");
            String[] datosFecha = fecha.split("-");
            proveedores.add(new Proveedor(rs.getString("nickname"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("email"), LocalDate.of(Integer.parseInt(datosFecha[0]), Integer.parseInt(datosFecha[1]), Integer.parseInt(datosFecha[2])), new ArrayList(), rs.getString("nombreEmpresa"), rs.getString("link"), new HashMap()));
            */
            /*Servicio s = new Servicio();
            
            s.setNombreServicio(rs.getString("nombre"));
            s.setProveedorServicio(p);
            s.setDescripcionServicio(rs.getString("descripcion"));
            s.setPrecioServicio(rs.getInt("precio"));
            servicios.add(s);*/
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
        
        //Statement st = conn.createStatement();
        
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
}
