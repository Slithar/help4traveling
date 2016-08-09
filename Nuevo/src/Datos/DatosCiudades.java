/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;
import java.util.*;
import java.sql.*;
import Logica.Ciudad;
import Logica.Pais;

/**
 *
 * @author usuario
 */
public class DatosCiudades {
    
    private ConexionBD conexion =  new ConexionBD();
    
    public ArrayList<Ciudad> selectAllCiudades() throws SQLException, ClassNotFoundException{
        ArrayList ciudades = new ArrayList();
        int indice = 0;
        Connection conn = conexion.conectar();
        
        Statement st = conn.createStatement();
        
        ResultSet rs = st.executeQuery("select nombre, nombrePais from ciudades order by nombre");
        
        while(rs.next()){
            ciudades.add(indice, new Ciudad(rs.getString("nombre"), new ArrayList(), new Pais(rs.getString("nombrePais"))));
            indice++;
        }
        
        rs.close();
        conexion.cerrar();
        
        return ciudades;
    }
    
}
