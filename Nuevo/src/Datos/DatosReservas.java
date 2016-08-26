/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ezequiel
 */
public class DatosReservas {
    
    public DatosReservas(){
        
    }
    public int insertarReserva(String fecha, int precio, String estado, String cliente) throws SQLException, ClassNotFoundException{
        Connection conn;
        ConexionBD conexion = new ConexionBD();
        conn = conexion.conectar();
        
        int numRes = 0;
        
        PreparedStatement st = conn.prepareStatement("insert into reservas (fecha, precio, estado, nicknameCliente)values (? ,? ,? ,?)", Statement.RETURN_GENERATED_KEYS);
        
        st.setString(1, fecha);
        st.setInt(2, precio);
        st.setString(3, estado);
        st.setString(4, cliente);
        
        st.executeUpdate();
        ResultSet rs = st.getGeneratedKeys();
        if(rs != null && rs.next()){
           numRes = rs.getInt(1);
        }

        conn.close();
        return numRes;
    }
    
    public void insertarServicioReserva(int numRes, String nombreServicio, String nombreProveedor, int cantidad, int totalLinea, String fechaInicio, String fechaFin ) throws SQLException, ClassNotFoundException{
       Connection conn;
       ConexionBD conexion = new ConexionBD();
       conn = conexion.conectar();
       
       PreparedStatement st = conn.prepareStatement("insert into cantidadreservasservicios values (?, ?, ?, ?, ?, ?, ?)");
       
       st.setInt(1, numRes);
       st.setString(2, nombreServicio);
       st.setString(3, nombreProveedor);
       st.setInt(4, cantidad);
       st.setInt(5, totalLinea);
       st.setString(6, fechaInicio);
       st.setString(7, fechaFin);
       
       st.executeUpdate();
       conn.close();
       
    }
    
    public void insertarPromocionReserva(int numRes, String nombrePromocion, String nombreProveedor, int cantidad, int totalLinea, String fechaInicio, String fechaFin) throws SQLException, ClassNotFoundException{
        Connection conn;
        ConexionBD conexion = new ConexionBD();
        conn = conexion.conectar();
        
        PreparedStatement st = conn.prepareStatement("insert into cantidadreservaspromociones values(?, ?, ?, ?, ?, ?, ?)");
        st.setInt(1, numRes);
        st.setString(2, nombrePromocion);
        st.setString(3, nombreProveedor);
        st.setInt(4, cantidad);
        st.setInt(5, totalLinea);
        st.setString(6, fechaInicio);
        st.setString(7, fechaFin);
        
        st.executeUpdate();
        conn.close();
        
                
    }
    
}
