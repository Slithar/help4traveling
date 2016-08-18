/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;
import Logica.Cliente;
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
    
    public ArrayList<Cliente> selectAllClientes() throws SQLException, ClassNotFoundException{
        ArrayList<Cliente> resultado = new ArrayList();
        
        Connection conn;
        ConexionBD conexion = new ConexionBD();
        conn = conexion.conectar();
        
        Statement st = conn.createStatement();
        
        ResultSet rs = st.executeQuery("select * from usuarios order by nickname");
        
        while(rs.next()){
           Cliente cli = new Cliente();
           cli.setNickname(rs.getString("nickname"));
           cli.setNombre(rs.getString("nombre"));
           cli.setApellido(rs.getString("apellido"));
           cli.setEmail(rs.getString("email"));
           cli.setFechaNac(LocalDate.parse(rs.getString("fechaNacimiento")));
           
           resultado.add(cli);
        }
        
        rs.close();
        conn.close();
        
        return resultado;
        
    }
    
}
