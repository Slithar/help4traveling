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
    public abstract int getPrecio(String string);
    public abstract int calcularPrecio(ArrayList<Integer> precios, int Descuento);
    public abstract String getNombreServicio(String cadenaACortar);
    public abstract int agregarPromocion(int PrecioPromocion,String NombrePromocion, int Descuento, String nombreProveedor) throws SQLException, ClassNotFoundException;
    public abstract int agregarServiciosPromocion(String NombrePromo, String NombreServ, String NombreProv) throws SQLException, ClassNotFoundException;
}
