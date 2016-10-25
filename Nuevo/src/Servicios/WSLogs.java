/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Logica.*;
import java.sql.*;
import java.time.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

/**
 *
 * @author usuario
 */

@WebService
public class WSLogs {
    
    private Endpoint endpoint = null;
    IControladorLogs iclog = new ControladorLogs();
    
    @WebMethod(exclude = true)
    public void publicar(){
        endpoint = Endpoint.publish("http://localhost:8810/logs", this);
    }
    
    @WebMethod
    public void agregarLog(LocalDate fecha, String ruta, String navegador, String so) {
        try {
            iclog.agregarLog(fecha, ruta, navegador, so);
        } catch (SQLException ex) {
            Logger.getLogger(WSLogs.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WSLogs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @WebMethod
    public void eliminarLogsViejos() {
        try {
            iclog.eliminarLogsViejos();
        } catch (SQLException ex) {
            Logger.getLogger(WSLogs.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WSLogs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @WebMethod
    public void posibleAgregar() {
        try {
            iclog.posibleAgregar();
        } catch (SQLException ex) {
            Logger.getLogger(WSLogs.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WSLogs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
