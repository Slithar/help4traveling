/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;
import Logica.Ciudad;
import Logica.DataCantidadReservas;
import Logica.Pais;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author usuario
 */
public class DatosClientes {
    
    //private ConexionBD conexion;
    
    public DatosClientes(){
        //conexion = new ConexionBD();
    }
   
    public void insertar(String nickname, String nombre, String apellido, String email, String fechaNac) throws SQLException, ClassNotFoundException{
        Connection conn;
        
        ConexionBD conexion = new ConexionBD();
        
        conn = conexion.conectar();
        
        PreparedStatement pConsulta = conn.prepareStatement("insert into usuarios values(?, ?, ?, ?, ?, true)");
        
        pConsulta.setString(1, nickname);
        pConsulta.setString(2, nombre);
        pConsulta.setString(3, apellido);
        pConsulta.setString(4, email);
        pConsulta.setString(5, fechaNac);
        
        pConsulta.executeUpdate();
        
        //conexion.cerrar();
        conn.close();
    }
    
    public void agregarImagen(String nickname, String ruta) throws SQLException, ClassNotFoundException{
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
    public ArrayList verInfoReserva()throws SQLException, ClassNotFoundException{
       ArrayList reservas = new ArrayList();
        int indice = 0;
        Connection conn;
        
        ConexionBD conexion = new ConexionBD();
        
        conn = conexion.conectar();
        
        Statement st = conn.createStatement();
        
        ResultSet rs = st.executeQuery("select * from cantidadreservas");
        
        while(rs.next()){
            System.out.println("a");
            reservas.add(indice,rs.getString("numeroReserva"));
            indice++;
        }
        
        rs.close();
        //conexion.cerrar();
        conn.close();
        
        
        return reservas;
        
    }
  public  DataCantidadReservas getReserva(String numeroRes){
      DataCantidadReservas dtaux = new DataCantidadReservas();
      Connection conn;
        
        ConexionBD conexion = new ConexionBD();
      try{  
        conn = conexion.conectar();
        
        PreparedStatement pConsulta = conn.prepareStatement("select * from cantidadreservas where numeroReserva=?");
        
        pConsulta.setString(1, numeroRes);
        
        ResultSet rs = pConsulta.executeQuery();
        
        //Statement st = conn.createStatement();
        
        //ResultSet rs = st.executeQuery("select * from cantidadreservas where numeroReserva="+numeroRes);
        
        while(rs.next()){
           
           /* dtaux
            dtaux.setCantidad(rs.getInt("cantidad"));*/
           
           
           
        }
         rs.close();
        //conexion.cerrar();
        conn.close();
      }catch(Exception e){}
      return dtaux; 
  }  
}
