/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;
import java.sql.SQLException;
import java.util.*;

/**
 *
 * @author usuario
 */
public interface IControladorPromociones {
    public abstract ArrayList<DataPromocion> getPromociones() throws SQLException, ClassNotFoundException;
    public abstract ArrayList<DataServicio> getServiciosPorPromocion(String nombrePromo) throws SQLException, ClassNotFoundException;
    public abstract DataPromocion getDataPromocion(String nombrePromo, String nombreProveedor) throws SQLException, ClassNotFoundException;
}
