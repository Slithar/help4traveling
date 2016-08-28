/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Logica.Cliente;
import Logica.Reserva;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

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
    
    public void deleteReservas(int numReserva) throws SQLException, ClassNotFoundException{
        Connection conn;
        ConexionBD conexion = new ConexionBD();
        conn = conexion.conectar();
        
        PreparedStatement st = conn.prepareStatement("delete from reservas r, cantidadreservaspromociones p, cantidadreservasservicios s where r.nombre = p.numeroReserva and r.nombre = s.numeroReserva and r.nombre = ?");
        st.setInt(1, numReserva);
        st.executeUpdate();
        conn.close();
                
        
    }
    
    public ArrayList<Reserva> getAllReservas() throws SQLException, ClassNotFoundException{
        ArrayList<Reserva> todasReservas = new ArrayList();
        Reserva reserva = new Reserva();
        
        Connection conn;
        ConexionBD conexion = new ConexionBD();
        conn = conexion.conectar();
        
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("Select * from reservas order by numero");
        if(rs.next()){
            reserva.setNumero(rs.getInt("numero"));
            reserva.setFecha(LocalDate.parse(rs.getString("fecha")));
            reserva.setPrecio(rs.getInt("precio"));
            reserva.setEstado(rs.getString("estado"));
            Cliente cli = new Cliente();
            cli.setNickname(rs.getString("nicknameCliente"));
            reserva.setCliente(cli);
            todasReservas.add(reserva);
        }
        conn.close();
        return todasReservas;
        
    }
}
