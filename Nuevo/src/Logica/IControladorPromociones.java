/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;
import java.util.*;
import java.sql.*;

/**
 *
 * @author usuario
 */
public interface IControladorPromociones {
    public abstract HashMap<String, Proveedor> getListaProveedores();
    public abstract void setListaProveedores(HashMap<String, Proveedor> ListaProveedores);
    public abstract void actualizarPromociones() throws SQLException, ClassNotFoundException;    
    public abstract int getCantPromociones();
    public abstract HashMap<String, Promocion> getListaPromociones();
    public abstract void setListaPromociones(HashMap<String, Promocion> ListaPromociones);
    public abstract void deleteAllPromociones() throws SQLException, ClassNotFoundException;
    public abstract void insertDatosPromocionesDePrueba() throws SQLException, ClassNotFoundException;
}
