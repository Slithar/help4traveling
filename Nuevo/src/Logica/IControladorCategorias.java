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
    
    public abstract ArrayList getCategoriasPadres() throws SQLException, ClassNotFoundException;
    public abstract ArrayList getCategoriasHijas(Categoria c) throws SQLException, ClassNotFoundException;
    public abstract boolean agregarNuevaCategoriaPadre(Categoria c) throws SQLException, ClassNotFoundException;
    public abstract boolean agregarNuevaCategoriaHija(Categoria c, String padre) throws SQLException, ClassNotFoundException;
    
}
