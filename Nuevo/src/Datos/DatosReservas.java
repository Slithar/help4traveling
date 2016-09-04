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
    
    public void insertarServicioReserva(int numRes, String nombreServicio, String nombreProveedor, int cantidad, int totalLinea, String fechaInicio, String fechaFin, int precioUnit ) throws SQLException, ClassNotFoundException{
       Connection conn;
       ConexionBD conexion = new ConexionBD();
       conn = conexion.conectar();
       
       PreparedStatement st = conn.prepareStatement("insert into cantidadreservasservicios values (?, ?, ?, ?, ?, ?, ?, ?)");
       
       st.setInt(1, numRes);
       st.setString(2, nombreServicio);
       st.setString(3, nombreProveedor);
       st.setInt(4, cantidad);
       st.setInt(5, totalLinea);
       st.setString(6, fechaInicio);
       st.setString(7, fechaFin);
       st.setInt(8, precioUnit);
       
       st.executeUpdate();
       conn.close();
       
    }
    
    public void insertarPromocionReserva(int numRes, String nombrePromocion, String nombreProveedor, int cantidad, int totalLinea, String fechaInicio, String fechaFin, int precioUnit) throws SQLException, ClassNotFoundException{
        Connection conn;
        ConexionBD conexion = new ConexionBD();
        conn = conexion.conectar();
        
        PreparedStatement st = conn.prepareStatement("insert into cantidadreservaspromociones values(?, ?, ?, ?, ?, ?, ?, ?)");
        st.setInt(1, numRes);
        st.setString(2, nombrePromocion);
        st.setString(3, nombreProveedor);
        st.setInt(4, cantidad);
        st.setInt(5, totalLinea);
        st.setString(6, fechaInicio);
        st.setString(7, fechaFin);
        st.setInt(8, precioUnit);
        
        st.executeUpdate();
        conn.close();
        
                
    }
    
    public void deleteReservas(int numReserva) throws SQLException, ClassNotFoundException{
        Connection conn;
        ConexionBD conexion = new ConexionBD();
        conn = conexion.conectar();
        
            PreparedStatement st = conn.prepareStatement("delete from reservas where reservas.numero = ?");
            st.setInt(1, numReserva);
        st.executeUpdate();
        conn.close();
                
        
    }
    
    public void deleteCantResServ(int numRes) throws SQLException, ClassNotFoundException{
        Connection conn;
        ConexionBD conexion = new ConexionBD();
        conn = conexion.conectar();
        
        PreparedStatement st = conn.prepareStatement("delete from cantidadreservasservicios where cantidadreservasservicios.numeroReserva = ? ");
        st.setInt(1, numRes);
        
        st.executeUpdate();
        conn.close();
    }
    public void deleteCantResPromo(int numRes) throws SQLException, ClassNotFoundException{
        Connection conn;
        ConexionBD conexion = new ConexionBD();
        conn = conexion.conectar();
        
        PreparedStatement st = conn.prepareStatement("delete from cantidadreservaspromociones where cantidadreservaspromociones.numeroReserva = ? ");
        st.setInt(1, numRes);
        
        st.executeUpdate();
        conn.close();
    }
    public ArrayList<Reserva> getAllReservas() throws SQLException, ClassNotFoundException{
        ArrayList<Reserva> todasReservas = new ArrayList();
        
        
        Connection conn;
        ConexionBD conexion = new ConexionBD();
        conn = conexion.conectar();
        
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("Select * from reservas ");
        while(rs.next()){
            Reserva reserva = new Reserva();
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
    
    public int getNumeroReserva(String fecha, int precio, String nickname) throws SQLException, ClassNotFoundException{
        ConexionBD conexion = new ConexionBD();
        
        Connection conn;
        
        conn = conexion.conectar();
        
        PreparedStatement pConsulta = conn.prepareCall("select max(numero) numero from reservas where fecha = ? and precio = ? and nicknameCliente = ? and estado = 'REGISTRADA'");
        
        pConsulta.setString(1, fecha);
        pConsulta.setInt(2, precio);
        pConsulta.setString(3, nickname);
        
        ResultSet rs = pConsulta.executeQuery();
        
        int numeroConsulta = 0;
        
        while(rs.next()){
            numeroConsulta = rs.getInt("numero");
        }
        
        rs.close();
        conn.close();
        
        return numeroConsulta;
    }
}
