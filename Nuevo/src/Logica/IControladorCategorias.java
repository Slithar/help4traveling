/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;
import java.sql.*;
import java.util.*;

/**
 *
 * @author usuario
 */
public interface IControladorCategorias {
    
    public abstract ArrayList<DataCategoria> getCategoriasPadres() throws SQLException, ClassNotFoundException;
    public abstract ArrayList<DataCategoria> getCategoriasHijas(String c) throws SQLException, ClassNotFoundException;
    public abstract boolean agregarNuevaCategoriaPadre(String c) throws SQLException, ClassNotFoundException;
    public abstract boolean agregarNuevaCategoriaHija(String c, String padre) throws SQLException, ClassNotFoundException;
    public abstract void actualizarCategorias() throws SQLException, ClassNotFoundException;    
    public abstract int getCantCategorias();
    public abstract HashMap<String, Categoria> getListaCategorias();
    public abstract void setListaCategorias(HashMap<String, Categoria> ListaCategorias);
    public abstract boolean existeCategoria(String c) throws SQLException, ClassNotFoundException;
    public abstract void deleteAllCategorias() throws SQLException, ClassNotFoundException;
    public abstract void insertCategoriasDePrueba() throws SQLException, ClassNotFoundException;
}
