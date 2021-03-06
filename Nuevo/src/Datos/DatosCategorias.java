/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;
import java.util.*;
import java.sql.*;
import Logica.Categoria;
import Logica.Servicio;
import javax.swing.JOptionPane;

/**
 *
 * @author usuario
 */
public class DatosCategorias {
    
    public DatosCategorias(){
    }
    
    public ArrayList selectCategoriasPadres() throws SQLException, ClassNotFoundException{
        ArrayList<Categoria> resultado = new ArrayList();
        
        Connection conn;
        
        ConexionBD conexion = new ConexionBD();
        
        conn = conexion.conectar();
        
        Statement st = conn.createStatement();
        
        ResultSet rs = st.executeQuery("select nombre from categorias where nombre not in(select categoriaHija from categoriasrelacionadas)");
        
        while(rs.next()){
            Categoria c = new Categoria(rs.getString("nombre"), "", new ArrayList());
            resultado.add(c);
        }
        
        rs.close();
        conn.close();
        
        return resultado;
    }
    
    public ArrayList<Categoria> selectCategoriasHijas(String categoria) throws SQLException, ClassNotFoundException{
        ArrayList<Categoria> resultado = new ArrayList();
        
        Connection conn;
        
        ConexionBD conexion = new ConexionBD();
        
        conn = conexion.conectar();
        
        PreparedStatement pConsulta = conn.prepareStatement("select categoriaHija from categoriasrelacionadas where categoriaPadre = ?");
        
        pConsulta.setString(1, categoria);
        
        ResultSet rs = pConsulta.executeQuery();
        
        while(rs.next()){
            Categoria c = new Categoria(rs.getString("categoriaHija"), "", new ArrayList());
            resultado.add(c);
            //indice++;
        }
        
        rs.close();
        conn.close();
        
        return resultado;
    }


    
    public int agregarCategoriaPadre(String nombre) throws SQLException, ClassNotFoundException{
        Connection conn;
        
        ConexionBD conexion = new ConexionBD();
        
        conn = conexion.conectar();
        
        PreparedStatement pConsulta = conn.prepareStatement("INSERT INTO categorias VALUES(?)");
        
        pConsulta.setString(1, nombre);
        
        int rows = pConsulta.executeUpdate();
        
        conn.close();

        return rows;
    }
    public boolean agregarNuevaCategoriaHija(String c, String padre) throws SQLException,ClassNotFoundException{
        Connection conn;
        
        ConexionBD conexion = new ConexionBD();
        
        conn = conexion.conectar();
        
        PreparedStatement pConsulta = conn.prepareStatement("INSERT INTO categoriasrelacionadas VALUES (?,?)"); 
        
        pConsulta.setString(1,padre);
        
        pConsulta.setString(2, c);
        
        int rows = pConsulta.executeUpdate();
        
        
        boolean resultado;
        if(rows>0){
            resultado = true;
        }else{
            resultado = false;
        }
        
        conn.close();
        
        return resultado;
        
        
    }
    public ArrayList existeCategoria(String c) throws SQLException, ClassNotFoundException{
        Connection conn;
        
        ConexionBD conexion = new ConexionBD();
        
        conn = conexion.conectar();
        
        PreparedStatement pConsulta = conn.prepareStatement("SELECT * FROM categorias WHERE nombre=?"); 
        
        pConsulta.setString(1,c);
        
        
        ResultSet rs = pConsulta.executeQuery();
        
        ArrayList cates = new ArrayList();
        
        while(rs.next()){
            Categoria categoria = new Categoria(rs.getString("nombre"), "", new ArrayList());
            cates.add(categoria);
        }
            
        rs.close();
        
        conn.close();
        
        return cates;
    }
    
    public ArrayList<Categoria> selectAllCategorias() throws SQLException, ClassNotFoundException{
        
        ArrayList<Categoria> categorias = new ArrayList<Categoria>();
        
        ConexionBD conexion = new ConexionBD();
        
        Connection conn;
        
        conn = conexion.conectar();
        
        Statement st = conn.createStatement();
        
        ResultSet rs = st.executeQuery("select * from categorias order by nombre");
        
        while(rs.next()){
            categorias.add(new Categoria(rs.getString("nombre"), "", new ArrayList()));
        }
        
        rs.close();
        conn.close();
        
        return categorias;
        
    }
    
    public void deleteAllCategorias(String s) throws SQLException, ClassNotFoundException{
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
    
    public void insertCategoriasDePrueba(String s) throws SQLException, ClassNotFoundException{
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
    
    public ArrayList getCategoriasRelacionadas() throws SQLException, ClassNotFoundException{
        ConexionBD conexion = new ConexionBD();
        
        Connection conn;
        
        conn = conexion.conectar();
        
        Statement st = conn.createStatement();
        
        ResultSet rs = st.executeQuery("select * from categoriasrelacionadas");
        
        ArrayList relacionadas = new ArrayList();
        while(rs.next()){
            relacionadas.add(rs.getString("categoriaPadre") + ";" + rs.getString("categoriaHija"));
        }
        
        rs.close();
        conn.close();
        
        return relacionadas;
    }

    
}
