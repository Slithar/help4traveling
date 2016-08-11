/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.*;
import java.util.*;
import Logica.Proveedor;

/**
 *
 * @author usuario
 */
public class DatosProveedores {
    
    //private ConexionBD conexion;
    
    public DatosProveedores(){
        //conexion = new ConexionBD();
    }
    
    public void insertar(String nickname, String nombre, String apellido, String email, String fechaNac) throws SQLException, ClassNotFoundException{
        //Connection conn = conexion.conectar();
        
        Connection conn;
        
        ConexionBD conexion = new ConexionBD();
        
        conn = conexion.conectar();
        
        PreparedStatement pConsulta = conn.prepareStatement("insert into usuarios values(?, ?, ?, ?, ?, false)");
        
        pConsulta.setString(1, nickname);
        pConsulta.setString(2, nombre);
        pConsulta.setString(3, apellido);
        pConsulta.setString(4, email);
        pConsulta.setString(5, fechaNac);
        
        pConsulta.executeUpdate();
        
        //conexion.cerrar();
        conn.close();
    }
    
    public void agregarDatosProveedor(String nickname, String nombreEmpresa, String link) throws SQLException, ClassNotFoundException{
        //Connection conn = conexion.conectar();
        
        Connection conn;
        
        ConexionBD conexion = new ConexionBD();
        
        conn = conexion.conectar();
        
        PreparedStatement pConsulta = conn.prepareStatement("insert into proveedores values(?, ?, ?)");
        
        pConsulta.setString(1, nombreEmpresa);
        pConsulta.setString(2, link);
        pConsulta.setString(3, nickname);
        
        pConsulta.executeUpdate();
        
        //conexion.cerrar();
        conn.close();
    }
    
    public void agregarImagen(String nickname, String ruta) throws SQLException, ClassNotFoundException{
        //Connection conn = conexion.conectar();
        
        Connection conn;
        
        ConexionBD conexion = new ConexionBD();
        
        conn = conexion.conectar();
        
        PreparedStatement pConsulta = conn.prepareStatement("insert into imagenesusuarios values(?, ?)");
        
        pConsulta.setString(1, ruta);
        pConsulta.setString(2, nickname);
        
        pConsulta.executeUpdate();
        
        //conexion.cerrar();
        conn.close();
    }
    
    public int selectCountNombreEmpresa(String nombreEmpresa) throws SQLException, ClassNotFoundException{
        int cant = 0;
        
        //Connection conn = conexion.conectar();
        
        Connection conn;
        
        ConexionBD conexion = new ConexionBD();
        
        conn = conexion.conectar();
        
        PreparedStatement pConsulta = conn.prepareStatement("select count(*) cantidad from proveedores where nombreEmpresa = ?");
        
        pConsulta.setString(1, nombreEmpresa);
        
        ResultSet rs = pConsulta.executeQuery();
        
        while(rs.next()){
            cant = rs.getInt("cantidad");
        }
        
        rs.close();
        //conexion.cerrar();
        conn.close();
        
        return cant;
    }
    
    public ArrayList<Proveedor> selectAllProveedores() throws SQLException, ClassNotFoundException{
        ArrayList proveedores = new ArrayList();
        int indice = 0;
        
        //Connection conn = conexion.conectar();
        
        Connection conn;
        
        ConexionBD conexion = new ConexionBD();
        
        conn = conexion.conectar();
        
        Statement st = conn.createStatement();
        
        ResultSet rs = st.executeQuery("select nombreEmpresa from proveedores order by nombreEmpresa");
        
        while(rs.next()){
            Proveedor prov = new Proveedor();
            prov.setNombreEmpresa(rs.getString("nombreEmpresa"));
            proveedores.add(indice, prov);
            indice++;
        }
        
        rs.close();
        //conexion.cerrar();
        conn.close();
        
        return proveedores;
        
    }
    
}
