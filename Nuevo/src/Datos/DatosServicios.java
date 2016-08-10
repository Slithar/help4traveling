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
    
    public void insertar(String nombre, String nombreProveedor, String ciudadOrigen, String ciudadDestino, String descripcion, int precio, boolean tieneDestino) throws SQLException, ClassNotFoundException{
        Connection conn = conexion.conectar();
        
        if(tieneDestino){
            PreparedStatement pConsulta = conn.prepareStatement("insert into servicios values (?, ?, ?, ?, ?, ?)");
            
            pConsulta.setString(1, nombre);
            pConsulta.setString(2, nombreProveedor);
            pConsulta.setString(3, ciudadOrigen);
            pConsulta.setString(4, ciudadDestino);
            pConsulta.setString(5, descripcion);
            pConsulta.setInt(6, precio);
            
            pConsulta.executeUpdate();
        }
        else{
            PreparedStatement pConsulta = conn.prepareStatement("insert into servicios values (?, ?, ?, null, ?, ?)");
            
            pConsulta.setString(1, nombre);
            pConsulta.setString(2, nombreProveedor);
            pConsulta.setString(3, ciudadOrigen);
            pConsulta.setString(4, descripcion);
            pConsulta.setInt(5, precio);
            
            pConsulta.executeUpdate();
        }
        
        conexion.cerrar();
    }
    
    public void agregarCategoria(String nombreServicio, String nombreProveedor, String nombreCategoria) throws SQLException, ClassNotFoundException{
        Connection conn = conexion.conectar();
        PreparedStatement pConsulta = conn.prepareStatement("insert into categoriasdeservicios values(?, ?, ?)");
        pConsulta.setString(1, nombreServicio);
        pConsulta.setString(2, nombreProveedor);
        pConsulta.setString(3, nombreCategoria);
        
        pConsulta.executeUpdate();
        
        conexion.cerrar();
    }
    
    public void agregarImagen(String ruta, String nombreServicio, String nombreProveedor) throws SQLException, ClassNotFoundException{
        Connection conn = conexion.conectar();
        PreparedStatement pConsulta = conn.prepareStatement("insert into imagenesservicios values(?, ?, ?)");
        pConsulta.setString(1, ruta);
        pConsulta.setString(2, nombreServicio);
        pConsulta.setString(3, nombreProveedor);
        
        pConsulta.executeUpdate();
        
        conexion.cerrar();
    }
    
}
