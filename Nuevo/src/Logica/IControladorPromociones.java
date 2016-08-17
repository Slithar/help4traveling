/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;
import java.sql.SQLException;
import java.util.*;
import javax.swing.DefaultListModel;

/**
 *
 * @author usuario
 */
public interface IControladorPromociones {
    public int devolverPrecio(String cadena);
    public int obtenerPrecio(int Precio, ArrayList<Integer> todosLosPrecios, int descuento);
    public String obtenerProveedor(String cadena);
    public String obtenerServicio(String cadena);
    public boolean agregarNuevaPromocion(String nombrePromo,int descuentoPromo, int precioPromo) throws SQLException, ClassNotFoundException;
    public boolean agregarServiciosPromocion(String nombrePromo, DefaultListModel modelo) throws SQLException,ClassNotFoundException;
}
