/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Logica.Cliente;
import Logica.Imagen;
import Logica.ImagenServicio;
import java.sql.*;
import java.util.*;
import Logica.Proveedor;
import Logica.Reserva;
import Logica.Servicio;
import Logica.Usuario;
import java.time.*;

/**
 *
 * @author usuario
 */
public class DatosProveedores {
    
    public DatosProveedores(){
        
    }
    
    public void insertar(String nickname, String nombre, String apellido, String email, String fechaNac, String nombreEmpresa, String link, String pass) throws SQLException, ClassNotFoundException{
        Connection conn;
        
        ConexionBD conexion = new ConexionBD();
        
        conn = conexion.conectar();
        
        PreparedStatement pConsulta = conn.prepareStatement("insert into usuarios values(?, ?, ?, ?, ?, false, ? ,?, ?)");
        
        pConsulta.setString(1, nickname);
        pConsulta.setString(2, nombre);
        pConsulta.setString(3, apellido);
        pConsulta.setString(4, email);
        pConsulta.setString(5, fechaNac);
        pConsulta.setString(6, nombreEmpresa);
        pConsulta.setString(7, link);
        pConsulta.setString(8, pass);
        
        pConsulta.executeUpdate();
        
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
        
        conn.close();
    }
    
    public Proveedor getNombreEmpresa(String nick) throws SQLException, ClassNotFoundException{
        Proveedor p = new Proveedor();
        //int indice = 0;
        
        Connection conn;
        
        ConexionBD conexion = new ConexionBD();
        
        conn = conexion.conectar();
        
        PreparedStatement pConsulta = conn.prepareCall("select nombreEmpresa from usuarios where nickname = ?");
        
        pConsulta.setString(1, nick);
        
        ResultSet rs = pConsulta.executeQuery();
        
        while(rs.next()){            
            p.setNombreEmpresa(rs.getString("nombreEmpresa"));
        }
        
        rs.close();
        
        conn.close();
        
        return p;
    }
    
    public ArrayList<Proveedor> selectAllProveedores() throws SQLException, ClassNotFoundException{
        ArrayList proveedores = new ArrayList();
        int indice = 0;
        
        Connection conn;
        
        ConexionBD conexion = new ConexionBD();
        
        conn = conexion.conectar();
        
        Statement st = conn.createStatement();
        
        ResultSet rs = st.executeQuery("select nickname, nombreEmpresa from usuarios where cliente = false order by nickname");
        
        while(rs.next()){
            
            Proveedor prov = new Proveedor();
            prov.setNickname(rs.getString("nickname"));
            prov.setNombreEmpresa(rs.getString("nombreEmpresa"));
            proveedores.add(indice, prov);
            indice++;
        }
        
        rs.close();
        
        conn.close();
        
        return proveedores;
        
    }
    
    public ArrayList<Proveedor> selectAllObjetosProveedores() throws SQLException, ClassNotFoundException{
        
        ArrayList<Proveedor> proveedores = new ArrayList<Proveedor>();
        
        ConexionBD conexion = new ConexionBD();
        
        Connection conn;
        
        conn = conexion.conectar();
        
        Statement st = conn.createStatement();
        
        ResultSet rs = st.executeQuery("select * from usuarios u where cliente = false");
        
        while(rs.next()){
            String fecha = rs.getString("fechaNacimiento");
            String[] datosFecha = fecha.split("-");
            proveedores.add(new Proveedor(rs.getString("nickname"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("email"), LocalDate.of(Integer.parseInt(datosFecha[0]), Integer.parseInt(datosFecha[1]), Integer.parseInt(datosFecha[2])), new ArrayList(), rs.getString("nombreEmpresa"), rs.getString("link"), new HashMap(), rs.getString("pass")));
        }
        
        rs.close();
        conn.close();
        
        return proveedores;
        
    }
    
    public ArrayList<Servicio> selectServiciosPorProveedor(Proveedor p) throws SQLException, ClassNotFoundException{
        
        ArrayList<Servicio> servicios = new ArrayList<Servicio>();
        
        ConexionBD conexion = new ConexionBD();
        
        Connection conn;
        
        conn = conexion.conectar();
        
        PreparedStatement pConsulta = conn.prepareStatement("select * from servicios where nickProveedor = ?");
        
        pConsulta.setString(1, p.getNombreEmpresa());
                
        ResultSet rs = pConsulta.executeQuery();
        
        while(rs.next()){
            Servicio s = new Servicio();
            
            s.setNombreServicio(rs.getString("nombre"));
            s.setProveedorServicio(p);
            s.setDescripcionServicio(rs.getString("descripcion"));
            s.setPrecioServicio(rs.getInt("precio"));
            servicios.add(s);
        }
        
        rs.close();
        conn.close();
        
        return servicios;
        
    }
    
    
    
    public void deleteAllProveedores(String s) throws SQLException, ClassNotFoundException{
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
    
    public void insertDatosProveedoresDePrueba(String s) throws SQLException, ClassNotFoundException{
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
    
  public ArrayList<Proveedor> verInfoProveedorBusqueda(String nickname) throws SQLException, ClassNotFoundException {
        ArrayList<Proveedor> proveedor = new ArrayList();
        int indice = 0;
        Connection conn;

        ConexionBD conexion = new ConexionBD();

        conn = conexion.conectar();

        PreparedStatement pConsulta = conn.prepareCall("select * from usuarios where cliente= false and nickname like ? order by nickname");
        
        pConsulta.setString(1, "%" + nickname + "%");
        
        ResultSet rs = pConsulta.executeQuery();
        
        while (rs.next()) {
            Proveedor p = new Proveedor();
            p.setNickname(rs.getString("nickname"));
            proveedor.add(indice, p);
            indice++;
        }

        rs.close();
        conn.close();
        return proveedor;
    }  
   
  
      public Proveedor seleccionarProveedor(String nickname) throws SQLException, ClassNotFoundException{
        ConexionBD conexion = new ConexionBD();
        
        Connection conn;
        
        conn = conexion.conectar();
        
        PreparedStatement pConsulta = conn.prepareCall("select * from usuarios WHERE cliente=false and nickname=?");
        
        pConsulta.setString(1,nickname);
        
        ResultSet rs = pConsulta.executeQuery();
        
        Proveedor p = new Proveedor();
        HashMap<String,Servicio> servicio = new HashMap<String,Servicio>();
                
        if(rs.next()){
            
            String fecha = rs.getString("fechaNacimiento");
            String[] datosFecha = fecha.split("-");
            p=new Proveedor(rs.getString("nickname"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("email"), LocalDate.of(Integer.parseInt(datosFecha[0]), Integer.parseInt(datosFecha[1]), Integer.parseInt(datosFecha[2])), new ArrayList(),rs.getString("nombreEmpresa"), rs.getString("link"), new HashMap(), rs.getString("pass"));
                        
        }
        
        
        
        return p;
        
    }
    
    public ArrayList<Imagen> getImagenesProv(String nickProveedor) throws SQLException, ClassNotFoundException{
        Connection conn;
        
        ConexionBD conexion = new ConexionBD();
        
        conn = conexion.conectar();
        
        PreparedStatement pConsulta = conn.prepareStatement("select ruta from imagenesusuarios i, usuarios u where u.cliente = false and u.nickname=i.nickname and u.nickname = ?");
        
        pConsulta.setString(1, nickProveedor);
        
        ResultSet rs = pConsulta.executeQuery();
        
        ArrayList<Imagen> imagenes = new ArrayList<Imagen>();
        
        if(rs != null){
            while(rs.next()){
                imagenes.add(new Imagen(rs.getString("ruta"), new Usuario()));
            }
        }
        
        
        rs.close();
        
        conn.close();
        
        return imagenes;
        
    }
      
}
