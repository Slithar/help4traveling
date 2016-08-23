/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;
import Logica.Ciudad;
import Logica.Cliente;
import Logica.DataCantidadReservasPromociones;
import Logica.DataCantidadReservasServicios;
import Logica.Pais;
import Logica.Promocion;
import Logica.Reserva;
import Logica.Servicio;
import Logica.Estado;
import Logica.cantidadReservasPromociones;
import Logica.cantidadReservasServicios;
import java.sql.*;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
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
        
        ResultSet rs = st.executeQuery("select numero from reservas ");
        
        while(rs.next()){
            //System.out.println("a");
            reservas.add(indice,rs.getString("numero"));
            indice++;
        }
        
        rs.close();
        //conexion.cerrar();
        conn.close();
        
        
        return reservas;
        
    }
  public  Reserva getReserva(String numeroRes){
      Reserva dtaux = new Reserva();
      ArrayList <cantidadReservasPromociones> listProm = new ArrayList();
      ArrayList <cantidadReservasServicios> listServ= new ArrayList();
      Connection conn;
        
        ConexionBD conexion = new ConexionBD();
      try{  
        conn = conexion.conectar();
        
     
        
        Statement st = conn.createStatement();
        
        ResultSet rs = st.executeQuery("SELECT * FROM reservas r ,usuarios u WHERE numero = "+numeroRes+" and r.nicknameCliente =u.nickname ");
        
        while(rs.next()){
           Cliente c= new Cliente();
           c.setNickname(rs.getString("nicknameCliente"));
            dtaux.setCliente(c);
           dtaux.setNumero(rs.getInt("numero"));
           dtaux.setPrecio(rs.getInt("precio"));
       
           String fechaR=rs.getString("fecha");
           String[] partesFecha= fechaR.split("-");
           LocalDate fechaReserva=LocalDate.of(Integer.parseInt(partesFecha[0]), Integer.parseInt(partesFecha[1]),Integer.parseInt(partesFecha[2]));
           dtaux.setFecha(fechaReserva);
           dtaux.setEstado(rs.getString("estado"));
           
//           ResultSet rsCant = st.executeQuery("SELECT * FROM cantidadreservaspromociones cr,promociones p WHERE cr.nombrePromocion=p.nombre and numeroReserva="+numeroRes);
//           while(rsCant.next()){
//               Promocion prom = new Promocion();
//               prom.setDescuento(rsCant.getInt("descuento"));
//               prom.setNombre(rsCant.getString("nombrePromocion"));
//               prom.setPrecio(rsCant.getInt("precio"));
//               listProm.add(prom);
//               
//           }
//           dtaux.setReservaPromociones(listProm);
        }
         rs.close();
        //conexion.cerrar();
        conn.close();
      }catch(Exception e){}
      return dtaux; 
  }
  public ArrayList getReservasPromo(String numeroProm){

    ArrayList<cantidadReservasPromociones>  dtProm= new ArrayList();
    Connection conn;  
    ConexionBD conexion = new ConexionBD();
      try{  
        conn = conexion.conectar();
        Statement st = conn.createStatement();
          ResultSet rsCant = st.executeQuery("SELECT * FROM cantidadreservaspromociones cr,promociones p WHERE cr.nombrePromocion=p.nombre and numeroReserva="+numeroProm);
           while(rsCant.next()){
               cantidadReservasPromociones cantProm = new cantidadReservasPromociones();
              cantProm.setnombreP(rsCant.getString("nombrePromocion"));
               cantProm.setCantidad(rsCant.getInt("cantidad"));
               cantProm.setTotalL(rsCant.getInt("totalLinea"));
               String fechaR=rsCant.getString("fechaInicio");
           String[] partesFecha= fechaR.split("-");
           LocalDate fechaReserva=LocalDate.of(Integer.parseInt(partesFecha[0]), Integer.parseInt(partesFecha[1]),Integer.parseInt(partesFecha[2]));
           cantProm.setFechaInicio(fechaReserva);
            String fechaRf=rsCant.getString("fechaFin");
           String[] partesFechaf= fechaRf.split("-");
           LocalDate fechaReservaf=LocalDate.of(Integer.parseInt(partesFechaf[0]), Integer.parseInt(partesFechaf[1]),Integer.parseInt(partesFechaf[2]));
           cantProm.setFechaFin(fechaReservaf);
           
              dtProm.add(cantProm);
               
           }
          //dtaux.setReservaPromociones(listProm);
        
         rsCant.close();
        //conexion.cerrar();
        conn.close();
      }catch(Exception e){}
      return dtProm; 
        
  }
  public ArrayList getServiciosPromo(String numeroSer){
  ArrayList<cantidadReservasServicios>  dtSer= new ArrayList();
    Connection conn;  
    ConexionBD conexion = new ConexionBD();
      try{  
        conn = conexion.conectar();
        Statement st = conn.createStatement();
          ResultSet rsCant = st.executeQuery("SELECT * FROM cantidadreservasservicios cs,servicios s WHERE cs.nombreServicio=s.nombre and numeroReserva="+numeroSer);
      
          while(rsCant.next()){
               cantidadReservasServicios cantSer = new cantidadReservasServicios();
               cantSer.setNombreS(rsCant.getString("nombreServicio"));
               cantSer.setCantidad(rsCant.getInt("cantidad"));
               cantSer.setTotalLinea(rsCant.getInt("totalLinea"));
               String fechaR=rsCant.getString("fechaInicio");
           String[] partesFecha= fechaR.split("-");
           LocalDate fechaReserva=LocalDate.of(Integer.parseInt(partesFecha[0]), Integer.parseInt(partesFecha[1]),Integer.parseInt(partesFecha[2]));
           cantSer.setFechaInicio(fechaReserva);
            String fechaRf=rsCant.getString("fechaFin");
           String[] partesFechaf= fechaRf.split("-");
           LocalDate fechaReservaf=LocalDate.of(Integer.parseInt(partesFechaf[0]), Integer.parseInt(partesFechaf[1]),Integer.parseInt(partesFechaf[2]));
           cantSer.setFechaFin(fechaReservaf);
           
              dtSer.add(cantSer);
            }
         rsCant.close();
        //conexion.cerrar();
        conn.close();
      }catch(Exception e){}
      return dtSer;     
  }
      
       
public ArrayList verInfoCliente() throws SQLException, ClassNotFoundException{
    ArrayList clientes = new ArrayList();
    int indice =0;
    Connection conn;
        
        ConexionBD conexion = new ConexionBD();
        
        conn = conexion.conectar();
        
        Statement st = conn.createStatement();
        
        ResultSet rs = st.executeQuery("select * from usuarios where clientes="+1);
        while(rs.next()){
            //System.out.println("a");
            clientes.add(indice,rs.getString("nickname"));
            indice++;
        }
        
        rs.close();
        //conexion.cerrar();
        conn.close();
        return clientes;
} 
}
