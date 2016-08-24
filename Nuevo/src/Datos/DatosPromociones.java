/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;
import java.util.*;
import java.sql.*;
import Logica.Promocion;
import Logica.Servicio;
import Logica.Proveedor;


/**
 *
 * @author usuario
 */
public class DatosPromociones {
    
    public ArrayList<Promocion> selectAllPromociones() throws SQLException, ClassNotFoundException{
        
        ArrayList<Promocion> promociones = new ArrayList<Promocion>();
        
        ConexionBD conexion = new ConexionBD();
        
        Connection conn;
        
        conn = conexion.conectar();
        
        Statement st = conn.createStatement();
        
        ResultSet rs = st.executeQuery("select * from promociones");
        
        while(rs.next()){
            promociones.add(new Promocion(rs.getString("nombre"), rs.getInt("descuento"), rs.getInt("precio"), new ArrayList()));
        }
        
        rs.close();
        conn.close();
        
        return promociones;
        
    }
    
    public ArrayList<Servicio> selectServiciosPromocion(String nombre) throws SQLException, ClassNotFoundException{
        
        ArrayList<Servicio> servicios = new ArrayList<Servicio>();
        
        ConexionBD conexion = new ConexionBD();
        
        Connection conn;
        
        conn = conexion.conectar();
        
        PreparedStatement pConsulta = conn.prepareCall("select * from serviciosdepromociones where nombrePromocion = ?");
        
        pConsulta.setString(1, nombre);
        
        ResultSet rs = pConsulta.executeQuery();
        
        while(rs.next()){
            Servicio s = new Servicio();
            s.setNombreServicio(rs.getString("nombreServicio"));
            Proveedor p = new Proveedor();
            p.setNombreEmpresa(rs.getString("nombreProveedor"));
            s.setProveedorServicio(p);
            servicios.add(s);
        }
        
        rs.close();
        conn.close();
        
        return servicios;
        
    }
    
}
