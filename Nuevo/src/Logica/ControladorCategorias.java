/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;
import java.util.*;
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
    
}
