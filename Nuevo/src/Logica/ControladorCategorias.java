/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;
import java.util.*;
import java.sql.*;
import Datos.DatosCategorias;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author usuario
 */
public class ControladorCategorias implements IControladorCategorias{
    
    DatosCategorias categorias;
    
    public ControladorCategorias(){
        
    }
    
    @Override
    public ArrayList getCategoriasPadres() throws SQLException, ClassNotFoundException{
        categorias = new DatosCategorias();
        
        ArrayList<Categoria> categoriasPadres = categorias.selectCategoriasPadres();
        ArrayList<String> resultado = new ArrayList();
        
        for(int i = 0; i < categoriasPadres.size(); i++){
            resultado.add(categoriasPadres.get(i).getNombre());
        }
        
        return resultado;
        
    }
    
    @Override
    public ArrayList getCategoriasHijas(String c) throws SQLException, ClassNotFoundException{
        categorias = new DatosCategorias();
        
        ArrayList<Categoria> categoriasPadres = categorias.selectCategoriasHijas(c);
        ArrayList<String> resultado = new ArrayList();
        
        for(int i = 0; i < categoriasPadres.size(); i++){
            resultado.add(categoriasPadres.get(i).getNombre());
        }
        
        return resultado;
        
    }    
    @Override
    public boolean agregarNuevaCategoriaPadre(String c) throws SQLException, ClassNotFoundException{
        categorias = new DatosCategorias();
        int rows = categorias.agregarCategoriaPadre(c);
        if(rows>0){
            boolean resultado = true;
            return resultado;
        }else{
            boolean resultado = false;
            return resultado;
        }
    }
    
    @Override
    public boolean agregarNuevaCategoriaHija(String c, String padre) throws SQLException,ClassNotFoundException{
       categorias = new DatosCategorias();
       ArrayList existeCate = categorias.existeCategoria(c);
       boolean existe;
       if(!existeCate.isEmpty()){
           existe = true;
       }else{
           existe= false;
       }
       if(existe==true){
       boolean resultado = categorias.agregarNuevaCategoriaHija(c, padre);
       return resultado;
       }else{
           categorias.agregarCategoriaPadre(c);
           boolean resultado = categorias.agregarNuevaCategoriaHija(c, padre);
           return resultado;
       }
    }
    
}
