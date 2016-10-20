/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author usuario
 */
public interface IControladorLogs {
    public abstract void agregarLog(LocalDate fecha, String ruta, String navegador, String so) throws SQLException, ClassNotFoundException;
    public abstract String getSO();    
    public abstract String getNavegador(String userAgent);
    public abstract void eliminarLogsViejos() throws SQLException, ClassNotFoundException;
    public abstract void posibleAgregar() throws SQLException, ClassNotFoundException;
    public abstract ArrayList<DataLog> getLogs() throws SQLException, ClassNotFoundException;
    
}
