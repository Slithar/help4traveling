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
            Proveedor p = new Proveedor();
            p.setNombreEmpresa(rs.getString("nombreProveedor"));
            promociones.add(new Promocion(rs.getString("nombre"), rs.getInt("descuento"), rs.getInt("precio"), new ArrayList(), p));
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
    
    public void deleteAllPromociones(String s) throws SQLException, ClassNotFoundException{
        ConexionBD conexion = new ConexionBD();
        
        Connection conn;
        
        conn = conexion.conectar();       
        
        Statement st = conn.createStatement();
        
        String[] sql = s.split(";");
        
        for(int i = 0; i < sql.length; i++){
            st.executeUpdate(sql[i]);
        }
        
        conn.close();
        
        
    }
    
    public void insertDatosPromocionesDePrueba(String s) throws SQLException, ClassNotFoundException{
        ConexionBD conexion = new ConexionBD();
        
        Connection conn;
        
        conn = conexion.conectar();
        
        Statement st = conn.createStatement();
        
        String[] sql = s.split(";");
        
        for(int i = 0; i < sql.length; i++){
            st.executeUpdate(sql[i]);
        }
        
        conn.close();
        
        
    }
    
    public int agregarPromocion(int PrecioPromocion, String NombrePromocion, int Descuento, String nombreProveedor) throws SQLException, ClassNotFoundException{
        
        ConexionBD conexion = new ConexionBD();
        
        Connection conn;
        
        conn = conexion.conectar();
        
        PreparedStatement pConsulta = conn.prepareCall("INSERT INTO promociones VALUES (?,?,?,?)");
        
        pConsulta.setString(1,NombrePromocion );
        
        pConsulta.setInt(2, Descuento);
        
        pConsulta.setInt(3,PrecioPromocion);
        
        pConsulta.setString(4,nombreProveedor);
        
        int a = 0;
        
        a = pConsulta.executeUpdate();
        
        conn.close();
        
        return a;
    }
    public int agregarServiciosPromocion (String NombrePromo, String NombreServ, String NombreProve) throws SQLException, ClassNotFoundException{
        ConexionBD conexion = new ConexionBD();
        
        Connection conn;
        
        conn = conexion.conectar();
        
        PreparedStatement pConsulta = conn.prepareCall("INSERT INTO serviciosdepromociones VALUES (?,?,?)");
        
        pConsulta.setString(1,NombrePromo);
        
        pConsulta.setString(2, NombreServ);
        
        pConsulta.setString(3,NombreProve);
        
        int a = 0;
        
        a = pConsulta.executeUpdate();
        
        conn.close();
        
        return a;
    }
}
