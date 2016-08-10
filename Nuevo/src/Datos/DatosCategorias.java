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
    
    private ConexionBD conexion;
    
    public DatosCategorias(){
        conexion = new ConexionBD();
    }
    
    public ArrayList selectCategoriasPadres() throws SQLException, ClassNotFoundException{
        //int indice = 0;
        
        ArrayList<Categoria> resultado = new ArrayList();
        
        Connection conn = conexion.conectar();
        
        Statement st = conn.createStatement();
        
        ResultSet rs = st.executeQuery("select nombre from categorias where nombre not in(select categoriaHija from categoriasrelacionadas)");
        
        while(rs.next()){
            Categoria c = new Categoria(rs.getString("nombre"), new ArrayList());
            resultado.add(c);
            //indice++;
        }
        
        rs.close();
        conexion.cerrar();
        
        return resultado;
    }
    
    public ArrayList selectCategoriasHijas(String categoria) throws SQLException, ClassNotFoundException{
        //int indice = 0;
        
        ArrayList<Categoria> resultado = new ArrayList();
        
        Connection conn = conexion.conectar();
        
        PreparedStatement pConsulta = conn.prepareStatement("select categoriaHija from categoriasrelacionadas where categoriaPadre = ?");
        
        pConsulta.setString(1, categoria);
        
        ResultSet rs = pConsulta.executeQuery();
        
        while(rs.next()){
            Categoria c = new Categoria(rs.getString("categoriaHija"), new ArrayList());
            resultado.add(c);
            //indice++;
        }
        
        rs.close();
        conexion.cerrar();
        
        return resultado;
    }
    public boolean agregarCategoriaPadre(String Nombre) throws SQLException, ClassNotFoundException{
        Connection conn = conexion.conectar();
        
        PreparedStatement pConsulta = conn.prepareStatement("INSERT INTO categorias VALUES("+"?"+")");
        
        pConsulta.setString(1, Nombre);
        
        int rows = pConsulta.executeUpdate();
        
        if(rows>0){
            boolean resultado = true;
            return resultado;
        }else{
            boolean resultado = false;
            return resultado;
        }
    }
    public boolean agregarNuevaCategoriaHija(String c, String padre) throws SQLException,ClassNotFoundException{
        Connection conn = conexion.conectar();
        
        PreparedStatement pConsulta = conn.prepareStatement("INSERT INTO categoriasrelacionadas VALUES (?,?)"); 
        
        pConsulta.setString(1,padre);
        
        pConsulta.setString(2, c);
        
        int rows = pConsulta.executeUpdate();
        
        
        if(rows>0){
            boolean resultado = true;
            return resultado;
        }else{
            boolean resultado = false;
            return resultado;
        }
    }
    public ResultSet existeCategoria(String c) throws SQLException, ClassNotFoundException{
        Connection conn = conexion.conectar();
        
        PreparedStatement pConsulta = conn.prepareStatement("SELECT * FROM categorias WHERE nombre=?"); 
        
        pConsulta.setString(1,c);
        
        ResultSet rs = pConsulta.executeQuery();
        return rs;
    }
    
}
