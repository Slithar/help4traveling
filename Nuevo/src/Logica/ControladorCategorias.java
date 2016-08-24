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
    
    private DatosCategorias categorias;
    
    private HashMap<String, Categoria> ListaCategorias;
    
    public ControladorCategorias(){
        
        
    }
    
    public void actualizarCategorias() throws SQLException, ClassNotFoundException{
        categorias = new DatosCategorias();
        ListaCategorias = new HashMap<String, Categoria>();
        ArrayList<Categoria> categoriasResultado = categorias.selectAllCategorias();
        for(int i = 0; i < categoriasResultado.size(); i++){
            ListaCategorias.put(categoriasResultado.get(i).getNombre(), categoriasResultado.get(i));
        }
        Iterator it = ListaCategorias.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry cat = (Map.Entry) it.next();
            System.out.println("* " + cat.getKey());
            ArrayList<Categoria> catHijas = categorias.selectCategoriasHijas(String.valueOf(cat.getKey()));
            Categoria c = (Categoria) cat.getValue();
            c.setCategoriasHijas(catHijas);
            for(int i = 0; i < c.getCategoriasHijas().size(); i++){
                System.out.println("-- " + c.getCategoriasHijas().get(i).getNombre());
            }
        }
    }
    
    public int getCantCategorias(){
        return ListaCategorias.size();
    }
    
    @Override
    public ArrayList<DataCategoria> getCategoriasPadres() throws SQLException, ClassNotFoundException{
        categorias = new DatosCategorias();
        
        ArrayList<Categoria> categoriasPadres = categorias.selectCategoriasPadres();
        ArrayList<DataCategoria> resultado = new ArrayList<DataCategoria>();
        
        for(int i = 0; i < categoriasPadres.size(); i++){
            resultado.add(new DataCategoria(categoriasPadres.get(i).getNombre()));
        }
        
        return resultado;
        
    }
    
    @Override
    public ArrayList<DataCategoria> getCategoriasHijas(String c) throws SQLException, ClassNotFoundException{
        
        Categoria cat = new Categoria();
        cat.setNombre(c);
        
        categorias = new DatosCategorias();
        
        ArrayList<Categoria> categoriasPadres = categorias.selectCategoriasHijas(cat.getNombre());
        ArrayList<DataCategoria> resultado = new ArrayList<DataCategoria>();
        
        for(int i = 0; i < categoriasPadres.size(); i++){
            resultado.add(new DataCategoria(categoriasPadres.get(i).getNombre()));
        }
        
        return resultado;
        
    }    
    @Override
    public boolean agregarNuevaCategoriaPadre(String c) throws SQLException, ClassNotFoundException{
        
        Categoria cat = new Categoria(c, "", new ArrayList());
        
        categorias = new DatosCategorias();
        int rows = categorias.agregarCategoriaPadre(cat.getNombre());
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
       
       Categoria catHija = new Categoria(c, "", new ArrayList());
       
       categorias = new DatosCategorias();
       ArrayList existeCate = categorias.existeCategoria(catHija.getNombre());
       boolean existe;
       if(!existeCate.isEmpty()){
           existe = true;
       }else{
           existe= false;
       }
       if(existe==true){
            boolean resultado = categorias.agregarNuevaCategoriaHija(catHija.getNombre(), padre);
            return resultado;
       }else{
           categorias.agregarCategoriaPadre(catHija.getNombre());
           boolean resultado = categorias.agregarNuevaCategoriaHija(catHija.getNombre(), padre);
           return resultado;
       }
    }
    
    

    public HashMap<String, Categoria> getListaCategorias() {
        return ListaCategorias;
    }

    public void setListaCategorias(HashMap<String, Categoria> ListaCategorias) {
        this.ListaCategorias = ListaCategorias;
    }
    
}
