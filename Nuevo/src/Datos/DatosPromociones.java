/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;
import Logica.DataPromocion;
import Logica.Promocion;
import Logica.Proveedor;
import Logica.Servicio;
import java.sql.*;
import java.util.ArrayList;

        
/**
 *
 * @author ezequiel
 */
public class DatosPromociones {
    public ArrayList<Promocion> selectAllPromociones() throws SQLException, ClassNotFoundException{
        ArrayList<Promocion> resultado = new ArrayList();

        //DataPromocion promo = new DataPromocion();
        Connection conn;
        ConexionBD conexion = new ConexionBD();
        
        conn = conexion.conectar();
        Statement st = conn.createStatement();
        
        ResultSet rs = st.executeQuery("select nombre, nombreProveedor, precio from promociones, serviciosdepromociones where promociones.nombre = serviciosdepromociones.nombrePromocion order by promociones.nombre");
        while(rs.next()){
            Promocion promo = new Promocion();//creo objeto promocion
            promo.setNombre(rs.getString("nombre"));//seteo el nombre de la promocion
            promo.setPrecio(rs.getInt("precio"));//seteo el preciode la promocion
            Proveedor prov = new Proveedor();//nuevo objeto proveedor
            prov.setNombreEmpresa(rs.getString("nombreProveedor"));//seteo el nombre del objeto proveedor
            ArrayList<Servicio> servicios = new ArrayList();//nueva lista de Servicios
            Servicio serv = new Servicio();//nuevo objeto servicio
            serv.setProveedorServicio(prov);//linkeo el objeto proveedor con un servicio 
            servicios.add(serv);//agregoese servicio a la lista
            promo.setServicios(servicios);//agrego la lista de servicios a la promo
            resultado.add(promo);
            
        }
        return resultado;
    }
    //                      ____________________________________________
    
    public ArrayList<Promocion> getDatosPromociones() throws SQLException, ClassNotFoundException{
        ArrayList<Promocion> resultado = new ArrayList();
        
        Connection conn;
        ConexionBD conexion = new ConexionBD();
        conn = conexion.conectar();
        Statement st = conn.createStatement();
        
        ResultSet rs = st.executeQuery("select * from promociones");
        while(rs.next()){
            Promocion promo = new Promocion();
            promo.setNombre(rs.getString("nombre"));
            promo.setDescuento(rs.getInt("descuento"));
            promo.setPrecio(rs.getInt("precio"));
            resultado.add(promo);
        }
        return resultado;
    }
    
    public Promocion getDataPromocion(String nombrePromo, String nombreProveedor) throws SQLException, ClassNotFoundException{
        Promocion resultado =new Promocion();
        Connection conn;
        ConexionBD conexion = new ConexionBD();
        conn = conexion.conectar();
        PreparedStatement st = conn.prepareStatement("select * from promociones where nombre = ? && nombreproveedor = ?");
        st.setString(1, nombrePromo);
        st.setString(2, nombreProveedor);
        ResultSet rs = st.executeQuery();
        if(rs.next()){
            resultado.setNombre(rs.getString("nombre"));
            resultado.setDescuento(rs.getInt("descuento"));
            resultado.setPrecio(rs.getInt("precio"));
        }
        return resultado;
    }
}
