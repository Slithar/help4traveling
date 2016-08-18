/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;
import Logica.DataPromocion;
import java.sql.*;
import java.util.ArrayList;

        
/**
 *
 * @author ezequiel
 */
public class DatosPromociones {
    
    public ArrayList<DataPromocion> selectAllPromociones() throws SQLException, ClassNotFoundException{
        ArrayList<DataPromocion> resultado = new ArrayList();
        DataPromocion promo = new DataPromocion();
        
        Connection conn;
        ConexionBD conexion = new ConexionBD();
        
        conn = conexion.conectar();
        Statement st = conn.createStatement();
        
        ResultSet rs = st.executeQuery("select promociones.nombre, serviciosdepromociones.nombreProveedor, promociones.precio from promociones, serviciosdepromociones where promociones.nombre = serviciosdepromociones.nombrePromocion order by promociones.nombre");
        while(rs.next()){
            
        }
        return resultado;
    }
    
}
