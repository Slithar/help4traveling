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
            p.setNombreEmpresa(rs.getString("nickProveedor"));
            promociones.add(new Promocion(rs.getString("nombre"), rs.getInt("descuento"), rs.getInt("precio"), new ArrayList(), p));
        }
        
        rs.close();
        conn.close();
        
        return promociones;
        
    }
    
    public ArrayList<Promocion> selectAllPromocionesOrdenPrecio() throws SQLException, ClassNotFoundException{
        
        ArrayList<Promocion> promociones = new ArrayList<Promocion>();
        
        ConexionBD conexion = new ConexionBD();
        
        Connection conn;
        
        conn = conexion.conectar();
        
        Statement st = conn.createStatement();
        
        ResultSet rs = st.executeQuery("select * from promociones order by precio asc");
        
        while(rs.next()){
            Proveedor p = new Proveedor();
            p.setNombreEmpresa(rs.getString("nickProveedor"));
            promociones.add(new Promocion(rs.getString("nombre"), rs.getInt("descuento"), rs.getInt("precio"), new ArrayList(), p));
        }
        
        rs.close();
        conn.close();
        
        return promociones;
        
    }
    
    public ArrayList<Promocion> selectAllPromocionesOrdenAlfabeticamente() throws SQLException, ClassNotFoundException{
        
        ArrayList<Promocion> promociones = new ArrayList<Promocion>();
        
        ConexionBD conexion = new ConexionBD();
        
        Connection conn;
        
        conn = conexion.conectar();
        
        Statement st = conn.createStatement();
        
        ResultSet rs = st.executeQuery("select * from promociones order by nombre asc");
        
        while(rs.next()){
            Proveedor p = new Proveedor();
            p.setNombreEmpresa(rs.getString("nickProveedor"));
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
    
        public ArrayList<Servicio> selectAllServiciosPromocion(String nombre, String prov) throws SQLException, ClassNotFoundException{
        
        ArrayList<Servicio> servicios = new ArrayList<Servicio>();
        
        ConexionBD conexion = new ConexionBD();
        
        Connection conn;
        
        conn = conexion.conectar();
        
        PreparedStatement pConsulta = conn.prepareCall("select * from serviciosdepromociones where nombrePromocion = ? AND nickProveedor = ?");
        
        pConsulta.setString(1, nombre);
        pConsulta.setString(2, prov);
        
        ResultSet rs = pConsulta.executeQuery();
        
        while(rs.next()){
            Servicio s = new Servicio();
            s.setNombreServicio(rs.getString("nombreServicio"));
            Proveedor p = new Proveedor();
            p.setNombreEmpresa(rs.getString("nickProveedor"));
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
    
    public Promocion getDataPromocion(String nombrePromo, String nombreProveedor) throws SQLException, ClassNotFoundException {
        Promocion promo = new Promocion();
        Connection conn;
        ConexionBD conexion = new ConexionBD();
        conn = conexion.conectar();
        
        PreparedStatement st = conn.prepareStatement("select * from promociones where nombre = ? and nickProveedor = ?");
        st.setString(1, nombrePromo);
        st.setString(2, nombreProveedor);
        ResultSet rs = st.executeQuery();
        if(rs.next()){
            Proveedor nombreProv = new Proveedor();
            nombreProv.setNombreEmpresa(rs.getString("nickProveedor"));
            promo.setProveedor(nombreProv);
            promo.setNombre(rs.getString("nombre"));
            promo.setDescuento(rs.getInt("descuento"));
            promo.setPrecio(rs.getInt("precio"));
        }
        conn.close();
        rs.close();
        return promo;
    }
    
    public ArrayList<Promocion> selectMaxPromociones() throws SQLException, ClassNotFoundException{
        
        ArrayList<Promocion> promociones = new ArrayList<Promocion>();
        
        ConexionBD conexion = new ConexionBD();
        
        Connection conn;
        
        conn = conexion.conectar();
        
        Statement st = conn.createStatement();
        
        ResultSet rs = st.executeQuery("select count(*) cantidad, nombrePromocion, nickProveedor from cantidadreservaspromociones group by nombrePromocion, nickProveedor order by cantidad desc");
        
        while(rs.next()){
            Proveedor p = new Proveedor();
            p.setNickname(rs.getString("nickProveedor"));
            promociones.add(new Promocion(rs.getString("nombrePromocion"), 0, 0, new ArrayList(), p));
        }
        
        rs.close();
        conn.close();
        
        return promociones;
        
    }
    
    public ArrayList<String> selectBusquedaDatosOrdenPrecio(String buscar) throws SQLException, ClassNotFoundException{
        ArrayList<String> resultado = new ArrayList<String>();
        ConexionBD conexion = new ConexionBD();
        Connection conn;
        conn = conexion.conectar();
        PreparedStatement pConsulta = conn.prepareCall("select distinct 'servicio' as tipo, s.nombre, s.nickProveedor, s.precio from servicios s, categoriasdeservicios c where s.nombre = c.nombreServicio and s.nickProveedor = c.nickProveedor and c.rutaCategoria like ? union select distinct 'servicio' as tipo, s.nombre, s.nickProveedor, s.precio from servicios s where s.nombre like ? or s.descripcion like ? union select 'promocion' as tipo, nombre, nickProveedor, precio from promociones where nombre like ? order by precio");
        pConsulta.setString(1, "%" + buscar + "%");
        pConsulta.setString(2, "%" + buscar + "%");
        pConsulta.setString(3, "%" + buscar + "%");
        pConsulta.setString(4, "%" + buscar + "%");
        ResultSet rs = pConsulta.executeQuery();
        while(rs.next()){
            String r = rs.getString("tipo") + ";" + rs.getString("nombre") + ";" + rs.getString("nickProveedor") + ";" + rs.getString("precio") + ";";
            resultado.add(r);
        }
        rs.close();
        conn.close();
        
        return resultado;
    }
    
    public ArrayList<String> selectBusquedaDatosOrdenAlfabeticamente(String buscar) throws SQLException, ClassNotFoundException{
        ArrayList<String> resultado = new ArrayList<String>();
        ConexionBD conexion = new ConexionBD();
        Connection conn;
        conn = conexion.conectar();
        PreparedStatement pConsulta = conn.prepareCall("select distinct 'servicio' as tipo, s.nombre, s.nickProveedor, s.precio from servicios s, categoriasdeservicios c where s.nombre = c.nombreServicio and s.nickProveedor = c.nickProveedor and c.rutaCategoria like ? union select distinct 'servicio' as tipo, s.nombre, s.nickProveedor, s.precio from servicios s where s.nombre like ? or s.descripcion like ? union select 'promocion' as tipo, nombre, nickProveedor, precio from promociones where nombre like ? order by nombre");
        pConsulta.setString(1, "%" + buscar + "%");
        pConsulta.setString(2, "%" + buscar + "%");
        pConsulta.setString(3, "%" + buscar + "%");
        pConsulta.setString(4, "%" + buscar + "%");
        ResultSet rs = pConsulta.executeQuery();
        while(rs.next()){
            String r = rs.getString("tipo") + ";" + rs.getString("nombre") + ";" + rs.getString("nickProveedor") + ";" + rs.getString("precio") + ";";
            resultado.add(r);
        }
        rs.close();
        conn.close();
        
        return resultado;
    }
    
    
}
