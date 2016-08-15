/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;
import java.sql.*;

/**
 *
 * @author usuario
 */
public class ConexionBD {
    private Connection conn;
    
    public ConexionBD(){
        conn = null;
    }
    
    public Connection conectar() throws SQLException, ClassNotFoundException{
        if(conn == null){
            try{
                Class.forName("com.mysql.jdbc.Driver");
                
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/help4traveling?autoReconnect=true", "help4traveling", "help4traveling");
            }
            catch(SQLException ex){
                throw new SQLException(ex);
            }
            catch(ClassNotFoundException ex){
                throw new ClassCastException(ex.getMessage());
            }
        }        
        return conn;
    }
    
    public void cerrar() throws SQLException{
        if(conn != null)
            conn = null;
    }
 
}
