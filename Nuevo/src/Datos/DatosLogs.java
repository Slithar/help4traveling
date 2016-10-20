/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;
import Logica.*;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author usuario
 */
public class DatosLogs {
    
    public void agregarLog(LocalDate fecha, String ruta, String navegador, String so) throws SQLException, ClassNotFoundException{
        ConexionBD conexion = new ConexionBD();
        Connection conn;
        conn = conexion.conectar();
        
        PreparedStatement pConsulta = conn.prepareCall("insert into logs(fecha, ruta, navegador, so) values (?, ?, ?, ?)");
        
        pConsulta.setString(1, fecha.toString());
        pConsulta.setString(2, ruta);
        pConsulta.setString(3, navegador);
        pConsulta.setString(4, so);
        
        pConsulta.executeUpdate();
        
        conn.close();
    }
    
    public int getCantidadLogs() throws SQLException, ClassNotFoundException{
        
        int cantidad = 0;
        
        ConexionBD conexion = new ConexionBD();
        Connection conn;
        conn = conexion.conectar();
        
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select count(*) cantidad from logs where datediff(curdate() ,fecha) < 30");
        
        while(rs.next()){
            cantidad = rs.getInt("cantidad");
        }
        
        rs.close();
        conn.close();
        
        return cantidad;
        
    }
    
    public ArrayList<Log> selectAllLogs() throws SQLException, ClassNotFoundException{
        ConexionBD conexion = new ConexionBD();
        Connection conn;
        conn = conexion.conectar();
        
        ArrayList<Log> resultado = new ArrayList<Log>();
        
        Statement st = conn.createStatement();
        
        ResultSet rs = st.executeQuery("select * from logs order by numero");
        
        while(rs.next()){
            int nro = rs.getInt("numero");
            String fecha = rs.getString("fecha");
            String[] datosFecha = fecha.split("-");
            LocalDate fechaLog = LocalDate.of(Integer.parseInt(datosFecha[0]), Integer.parseInt(datosFecha[1]), Integer.parseInt(datosFecha[2]));
            String ruta = rs.getString("ruta");
            String navegador = rs.getString("navegador");
            String so = rs.getString("so");
            //JOptionPane.showMessageDialog(null, fechaLog.toString());
            Log l = new Log(nro, fechaLog, rs.getString("ruta"), rs.getString("navegador"), rs.getString("so"));
            resultado.add(l);
        }
        
        rs.close();
        conn.close();
        
        return resultado;
        
    }
    
    public void deleteLogsViejos() throws SQLException, ClassNotFoundException{
        ConexionBD conexion = new ConexionBD();
        Connection conn;
        conn = conexion.conectar();
        
        Statement st = conn.createStatement();
        
        st.executeUpdate("delete from logs where fecha < date_format(date_add(now(), interval-30 day), '%Y-%m-%d') and numero <> -1");
                
        
        conn.close();
        
    }
    
    public void deleteLogsMasViejo() throws SQLException, ClassNotFoundException{
        ConexionBD conexion = new ConexionBD();
        Connection conn;
        conn = conexion.conectar();
        
        Statement st = conn.createStatement();
        
        st.executeUpdate("delete from logs where numero > -1 limit 1");
                
        
        conn.close();
        
    }
}
