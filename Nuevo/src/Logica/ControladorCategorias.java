/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;
import java.util.*;
import java.sql.*;
import Datos.DatosCategorias;
import java.sql.SQLException;
/**
 *
 * @author usuario
 */
public class ControladorCategorias {
    
    DatosCategorias categorias;
    
    public ControladorCategorias(){
        
    }
    
    public ArrayList getCategoriasPadres() throws SQLException, ClassNotFoundException{
        categorias = new DatosCategorias();
        
        ArrayList<Categoria> categoriasPadres = categorias.selectCategoriasPadres();
        ArrayList<String> resultado = new ArrayList();
        
        for(int i = 0; i < categoriasPadres.size(); i++){
            resultado.add(categoriasPadres.get(i).getNombre());
        }
        
        return resultado;
        
    }
    
    public ArrayList getCategoriasHijas(Categoria c) throws SQLException, ClassNotFoundException{
        categorias = new DatosCategorias();
        
        ArrayList<Categoria> categoriasPadres = categorias.selectCategoriasHijas(c.getNombre());
        ArrayList<String> resultado = new ArrayList();
        
        for(int i = 0; i < categoriasPadres.size(); i++){
            resultado.add(categoriasPadres.get(i).getNombre());
        }
        
        return resultado;
        
    }
    public boolean agregarNuevaCategoriaPadre(Categoria c) throws SQLException, ClassNotFoundException{
        categorias = new DatosCategorias();
        boolean resultado = categorias.agregarCategoriaPadre(c.getNombre());
        return resultado;
    }
    
    public boolean agregarNuevaCategoriaHija(Categoria c, String padre) throws SQLException,ClassNotFoundException{
       categorias = new DatosCategorias();
       ResultSet existeCate = categorias.existeCategoria(c.getNombre());
       boolean existe;
       if(existeCate.next()){
           existe = true;
       }else{
           existe= false;
       }
       if(existe==true){
       boolean resultado = categorias.agregarNuevaCategoriaHija(c.getNombre(), padre);
       return resultado;
       }else{
           categorias.agregarCategoriaPadre(c.getNombre());
           boolean resultado = categorias.agregarNuevaCategoriaHija(c.getNombre(), padre);
           return resultado;
       }
    }
    
}
