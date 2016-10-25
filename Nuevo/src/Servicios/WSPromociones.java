/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Logica.*;
import java.sql.*;
import java.util.*;
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
public class WSPromociones {
    
    private Endpoint endpoint = null;
    private IControladorPromociones icprom = new ControladorPromociones(); 
    
    @WebMethod(exclude = true)
    public void publicar(){
        endpoint = Endpoint.publish("http://localhost:8810/promociones", this);
    }
    
    @WebMethod
    public ArrayList<String> selectBusquedaDatosOrdenPrecio(String buscar) {
        try {
            return icprom.selectBusquedaDatosOrdenPrecio(buscar);
        } catch (SQLException ex) {
            return new ArrayList();
        } catch (ClassNotFoundException ex) {
            return new ArrayList();
        }
    }
    
    @WebMethod
    public ArrayList<String> selectBusquedaDatosOrdenAlfabeticamente(String buscar) {
        try {
            return icprom.selectBusquedaDatosOrdenAlfabeticamente(buscar);
        } catch (SQLException ex) {
            return new ArrayList();
        } catch (ClassNotFoundException ex) {
            return new ArrayList();
        }
    }
    
    @WebMethod
    public void deleteAllPromociones() {
        try {
            icprom.deleteAllPromociones();
        } catch (SQLException ex) {
            Logger.getLogger(WSPromociones.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WSPromociones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @WebMethod
    public void insertDatosPromocionesDePrueba() {
        try {
            icprom.insertDatosPromocionesDePrueba();
        } catch (SQLException ex) {
            Logger.getLogger(WSPromociones.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WSPromociones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @WebMethod
    public ArrayList getMaxPromociones() {
        try {
            return icprom.getMaxPromociones();
        } catch (SQLException ex) {
            return new ArrayList();
        } catch (ClassNotFoundException ex) {
            return new ArrayList();
        }
    }
    
    @WebMethod
    public ArrayList<DataPromocion> getPromociones() {
        try {
            return icprom.getPromociones();
        } catch (SQLException ex) {
            return new ArrayList();
        } catch (ClassNotFoundException ex) {
            return new ArrayList();
        }
    }
    
    @WebMethod
    public DataPromocion getDataPromocion(String nombrePromo, String nombreProveedor) {
        try {
            return icprom.getDataPromocion(nombrePromo, nombreProveedor);
        } catch (SQLException ex) {
            return new DataPromocion();
        } catch (ClassNotFoundException ex) {
            return new DataPromocion();
        }
    }
    
    @WebMethod
    public ArrayList<DataServicio> getServiciosPromocion(String nombrePromo, String nombreProveedor) {
        try {
            return icprom.getServiciosPromocion(nombrePromo, nombreProveedor);
        } catch (SQLException ex) {
            return new ArrayList();
        } catch (ClassNotFoundException ex) {
            return new ArrayList();
        }
    }
    
    @WebMethod
    public ArrayList<DataPromocion> getPromocionesOrdenPrecio() {
        try {
            return icprom.getPromocionesOrdenPrecio();
        } catch (SQLException ex) {
            return new ArrayList();
        } catch (ClassNotFoundException ex) {
            return new ArrayList();
        }
    }
    
    @WebMethod
    public ArrayList<DataPromocion> getPromocionesOrdenAlfabeticamente() {
        try {
            return icprom.getPromocionesOrdenAlfabeticamente();
        } catch (SQLException ex) {
            return new ArrayList();
        } catch (ClassNotFoundException ex) {
            return new ArrayList();
        }
    }
}
