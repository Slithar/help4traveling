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

/**
 *
 * @author usuario
 */
public class DatosCategorias {
    
    //private ConexionBD conexion;
    
    public DatosCategorias(){
        //conexion = new ConexionBD();
    }
    
    public ArrayList selectCategoriasPadres() throws SQLException, ClassNotFoundException{
        //int indice = 0;
        
        ArrayList<Categoria> resultado = new ArrayList();
        
        Connection conn;
        
        ConexionBD conexion = new ConexionBD();
        
        conn = conexion.conectar();
        
        Statement st = conn.createStatement();
        
        ResultSet rs = st.executeQuery("select nombre from categorias where nombre not in(select categoriaHija from categoriasrelacionadas)");
        
        while(rs.next()){
            Categoria c = new Categoria(rs.getString("nombre"), "", new ArrayList());
            resultado.add(c);
            //indice++;
        }
        
        rs.close();
        //conexion.cerrar();
        conn.close();
        
        return resultado;
    }
    
    public ArrayList<Categoria> selectCategoriasHijas(String categoria) throws SQLException, ClassNotFoundException{
        //int indice = 0;
        
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
        //conexion.cerrar();
        conn.close();
        
        return resultado;
    }


    
    public int agregarCategoriaPadre(String nombre) throws SQLException, ClassNotFoundException{
        Connection conn;
        
        ConexionBD conexion = new ConexionBD();
        
        conn = conexion.conectar();
        
        PreparedStatement pConsulta = conn.prepareStatement("INSERT INTO categorias VALUES("+"?"+")");
        
        pConsulta.setString(1, nombre);
        
        int rows = pConsulta.executeUpdate();
        
        //conexion.cerrar();
        
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
        
        //conexion.cerrar();
        
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
            Categoria categoria = new Categoria(rs.getString("categoriaHija"), "", new ArrayList());
            cates.add(categoria);
            //indice 
        }
            
        rs.close();
        
        //conexion.cerrar();
        
        conn.close();// He hecho un cambio para pablo
        
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

    
}
