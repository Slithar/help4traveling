/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.*;
import javax.swing.*;
import java.util.*;
import Logica.Servicio;
import Logica.Proveedor;
import Logica.Ciudad;
import Logica.Pais;


/**
 *
 * @author usuario
 */
public class DatosServicios {
    
    //private ConexionBD conexion;
    
    public DatosServicios(){
        //conexion = new ConexionBD();
    }
    
    public int selectCountNombreServicio(String nombre, String nombreProveedor) throws SQLException, ClassNotFoundException{
        Connection conn;
        
        ConexionBD conexion = new ConexionBD();
        
        conn = conexion.conectar();
        
        PreparedStatement pConsulta = conn.prepareStatement("select count(*) cantidad from servicios where nombre = ? and nombreProveedor = ?");
        
        pConsulta.setString(1, nombre);
        pConsulta.setString(2, nombreProveedor);
        
        ResultSet rs = pConsulta.executeQuery();
        
        int resultado = 0;
        
        while(rs.next()){
            resultado = rs.getInt("cantidad");
        }
        
        
        rs.close();
        //conexion.cerrar();
        conn.close();
        
        return resultado;
    }
    
    public void insertar(String nombre, String nombreProveedor, String ciudadOrigen, String ciudadDestino, String descripcion, int precio, boolean tieneDestino) throws SQLException, ClassNotFoundException{
        Connection conn;
        
        ConexionBD conexion = new ConexionBD();
        
        conn = conexion.conectar();
        
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
        
        //conexion.cerrar();
        conn.close();
    }
    
    public void agregarCategoria(String nombreServicio, String nombreProveedor, String nombreCategoria, String rutaCategoria) throws SQLException, ClassNotFoundException{
        
        //JOptionPane.showMessageDialog(null, nombreCategoria);
        
        Connection conn;
        
        ConexionBD conexion = new ConexionBD();
        
        conn = conexion.conectar();
        
        PreparedStatement pConsulta = conn.prepareStatement("insert into categoriasdeservicios values(?, ?, ?, ?)");
        pConsulta.setString(1, nombreServicio);
        pConsulta.setString(2, nombreProveedor);
        pConsulta.setString(3, nombreCategoria);
        pConsulta.setString(4, rutaCategoria);
        
        pConsulta.executeUpdate();
        
        //conexion.cerrar();
        conn.close();
    }
    
    public void agregarImagen(String ruta, String nombreServicio, String nombreProveedor) throws SQLException, ClassNotFoundException{
        Connection conn;
        
        ConexionBD conexion = new ConexionBD();
        
        conn = conexion.conectar();
        PreparedStatement pConsulta = conn.prepareStatement("insert into imagenesservicios values(?, ?, ?)");
        pConsulta.setString(1, ruta);
        pConsulta.setString(2, nombreServicio);
        pConsulta.setString(3, nombreProveedor);
        
        pConsulta.executeUpdate();
        
        //conexion.cerrar();
        conn.close();
    }
    
    public ArrayList<Servicio> selectNombreServicios() throws SQLException, ClassNotFoundException{
        Connection conn;
        
        ConexionBD conexion = new ConexionBD();
        
        conn = conexion.conectar();
        
        Statement st = conn.createStatement();
        
        ResultSet rs = st.executeQuery("select nombre, nombreProveedor from servicios order by nombre");
        
        ArrayList<Servicio> resultado = new ArrayList<Servicio>();
        
        while(rs.next()){
            Servicio s = new Servicio();
            s.setNombreServicio(rs.getString("nombre"));
            Proveedor p = new Proveedor();
            p.setNombreEmpresa(rs.getString("nombreProveedor"));
            s.setProveedorServicio(p);
            
            resultado.add(s);
        }
        
        rs.close();
        
        conn.close();
        
        return resultado;
    }
    
    public Servicio selectServicioPorNombre(String nombre, String nombreProveedor) throws SQLException, ClassNotFoundException{
        Connection conn;
        
        ConexionBD conexion = new ConexionBD();
        
        conn = conexion.conectar();
        
        /*Statement st = conn.createStatement();
        
        ResultSet rs = st.executeQuery("select nombre from servicios order by nombre");
        
        ArrayList<Servicio> resultado = new ArrayList<Servicio>();*/
        
        PreparedStatement pConsulta = conn.prepareStatement("select nombreProveedor, descripcion, precio from servicios where nombre = ? and nombreProveedor = ?");
        
        pConsulta.setString(1, nombre);
        pConsulta.setString(2, nombreProveedor);
        
        ResultSet rs = pConsulta.executeQuery();
        
        Servicio s = new Servicio();
        
        while(rs.next()){
            
            Proveedor p = new Proveedor();
            p.setNombreEmpresa(rs.getString("nombreProveedor"));
            s.setProveedorServicio(p);
            s.setDescripcionServicio(rs.getString("descripcion"));
            s.setPrecioServicio(rs.getInt("precio"));
        }
        
        rs.close();
        conn.close();
        
        return s;
    }
    
    public Ciudad getCiudadOrigen(String nombre, String nombreProveedor) throws SQLException, ClassNotFoundException{
        Connection conn;
        
        ConexionBD conexion = new ConexionBD();
        
        conn = conexion.conectar();
        
        PreparedStatement pConsulta = conn.prepareStatement("select s.ciudadOrigen, c.nombrePais from servicios s, ciudades c where s.ciudadOrigen = c.nombre and s.nombre = ? and nombreProveedor = ?");
        
        pConsulta.setString(1, nombre);
        pConsulta.setString(2, nombreProveedor);
        
        ResultSet rs = pConsulta.executeQuery();
        
        Ciudad c = new Ciudad();
        
        while(rs.next()){
            c.setNombre(rs.getString("ciudadOrigen"));
            c.setPais(new Pais(rs.getString("nombrePais")));
        }
        
        rs.close();
        
        conn.close();
        
        return c;
    }
    
    public Ciudad getCiudadDestino(String nombre, String nombreProveedor) throws SQLException, ClassNotFoundException{
        Connection conn;
        
        ConexionBD conexion = new ConexionBD();
        
        conn = conexion.conectar();
        
        PreparedStatement pConsulta = conn.prepareStatement("select s.ciudadDestino, c.nombrePais from servicios s, ciudades c where s.ciudadDestino = c.nombre and s.nombre = ? and nombreProveedor = ?");
        
        pConsulta.setString(1, nombre);
        pConsulta.setString(2, nombreProveedor);
        
        ResultSet rs = pConsulta.executeQuery();
        
        Ciudad c = new Ciudad();
        
        while(rs.next()){
            c.setNombre(rs.getString("ciudadDestino"));
            c.setPais(new Pais(rs.getString("nombrePais")));
        }
        
        rs.close();
        
        conn.close();
        
        return c;
        
    }
    
}
