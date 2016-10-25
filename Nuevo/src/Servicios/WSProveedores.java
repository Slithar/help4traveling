/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;
import Logica.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

/**
 *
 * @author usuario
 */

@WebService
public class WSProveedores {
    
    private Endpoint endpoint = null;
    private IControladorProveedores icprov = new ControladorProveedores();
    
    @WebMethod(exclude = true)
    public void publicar(){
        endpoint = Endpoint.publish("http://localhost:8810/proveedores", this);
    }
    
    @WebMethod
    public ArrayList<DataCategoria> getCategorias(String nombre, String nombreProveedor){
        try {
            //System.out.println("HOLAAAA");
            return icprov.getCategorias(nombre, nombreProveedor);
        } catch (SQLException ex) {
            return new ArrayList();
        } catch (ClassNotFoundException ex) {
            return new ArrayList();
        }
    }
    
    @WebMethod
    public ArrayList<DataProveedor> getInfoProveedores() {
        try {
            return icprov.getInfoProveedores();
        } catch (SQLException ex) {
            return new ArrayList();
        } catch (ClassNotFoundException ex) {
            return new ArrayList();
        }
    }
    
    @WebMethod
    public ArrayList<DataImagen> getImagenesProv(String nombreProveedor) {
        try {
            return icprov.getImagenesProv(nombreProveedor);
        } catch (SQLException ex) {
            return new ArrayList();
        } catch (ClassNotFoundException ex) {
            return new ArrayList();
        }
    }
    
    @WebMethod
    public BufferedImage copiarImagenesServicio(String ruta){
        try {
            return icprov.copiarImagenesServicio(ruta);
        } catch (SQLException ex) {
            return null;
        } catch (ClassNotFoundException ex) {
            return null;
        } catch (IOException ex) {
            return null;
        }
    }
    
    @WebMethod
    public ArrayList<DataServicio> getServicios() {
        try {
            return icprov.getServicios();
        } catch (SQLException ex) {
            return new ArrayList();
        } catch (ClassNotFoundException ex) {
            return new ArrayList();
        }
    }
    
    @WebMethod
    public ArrayList<DataImagen> getImagenes(String nombre, String nombreProveedor) {
        try {
            return icprov.getImagenes(nombre, nombreProveedor);
        } catch (SQLException ex) {
            return new ArrayList();
        } catch (ClassNotFoundException ex) {
            return new ArrayList();
        }
    }
    
    @WebMethod
    public void deleteAllProveedores() {
        try {
            icprov.deleteAllProveedores();
        } catch (SQLException ex) {
            Logger.getLogger(WSProveedores.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WSProveedores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @WebMethod
    public void insertCiudadesDePrueba() {
        try {
            icprov.insertCiudadesDePrueba();
        } catch (SQLException ex) {
            Logger.getLogger(WSProveedores.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WSProveedores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @WebMethod
    public DataProveedor verInfoProveedor(String nickname) {
        try {
            return icprov.verInfoProveedor(nickname);
        } catch (SQLException ex) {
            return new DataProveedor();
        } catch (ClassNotFoundException ex) {
            return new DataProveedor();
        }
    }
    
    @WebMethod
    public void insertDatosProveedoresDePrueba() {
        try {
            icprov.insertDatosProveedoresDePrueba();
        } catch (SQLException ex) {
            Logger.getLogger(WSProveedores.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WSProveedores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @WebMethod
    public ArrayList getMaxServicios() {
        try {
            return icprov.getMaxServicios();
        } catch (SQLException ex) {
            return new ArrayList();
        } catch (ClassNotFoundException ex) {
            return new ArrayList();
        }
    }
    
    @WebMethod
    public DataProveedor getNombreEmpresa(String nick) {
        try {
            return icprov.getNombreEmpresa(nick);
        } catch (SQLException ex) {
            return new DataProveedor();
        } catch (ClassNotFoundException ex) {
            return new DataProveedor();
        }
    }
    
    @WebMethod
    public ArrayList<DataServicio> getServiciosProveedor(String NombreProveedor) {
        try {
            return icprov.getServiciosProveedor(NombreProveedor);
        } catch (SQLException ex) {
            return new ArrayList();
        } catch (ClassNotFoundException ex) {
            return new ArrayList();
        }
    }
    
    @WebMethod
    public DataServicio getDatosServicio(String nombre, String nombreProveedor) {
        try {
            return icprov.getDatosServicio(nombre, nombreProveedor);
        } catch (SQLException ex) {
            return new DataServicio();
        } catch (ClassNotFoundException ex) {
            return new DataServicio();
        }
    }
    
    @WebMethod
    public DataCiudad getCiudadOrigen(String nombre, String nombreProveedor) {
        try {
            return icprov.getCiudadOrigen(nombre, nombreProveedor);
        } catch (SQLException ex) {
            return new DataCiudad();
        } catch (ClassNotFoundException ex) {
            return new DataCiudad();
        }
    }
    
    @WebMethod
    public DataCiudad getCiudadDestino(String nombre, String nombreProveedor) {
        try {
            return icprov.getCiudadDestino(nombre, nombreProveedor);
        } catch (SQLException ex) {
            return new DataCiudad();
        } catch (ClassNotFoundException ex) {
            return new DataCiudad();
        }
    }
    
    @WebMethod
    public ArrayList<String> rutaImagenesServicios(String nombre, String nickProveedor) {
        try {
            return icprov.rutaImagenesServicios(nombre, nickProveedor);
        } catch (SQLException ex) {
            return new ArrayList();
        } catch (ClassNotFoundException ex) {
            return new ArrayList();
        }
    }
    
    @WebMethod
    public void agregarVisita(String nombreServicio, String nombreProveedor){
        try {
            icprov.agregarVisita(nombreServicio, nombreProveedor);
        } catch (SQLException ex) {
            Logger.getLogger(WSProveedores.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WSProveedores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @WebMethod
    public ArrayList<DataServicio> getServiciosPorCategoriaOrdenPrecio(String categoria) {
        try {
            return icprov.getServiciosPorCategoriaOrdenPrecio(categoria);
        } catch (SQLException ex) {
            return new ArrayList();
        } catch (ClassNotFoundException ex) {
            return new ArrayList();
        }
    }
    
    @WebMethod
    public ArrayList<DataServicio> getServiciosPorCategoriaOrdenAlfabeticamente(String categoria) {
        try {
            return icprov.getServiciosPorCategoriaOrdenAlfabeticamente(categoria);
        } catch (SQLException ex) {
            return new ArrayList();
        } catch (ClassNotFoundException ex) {
            return new ArrayList();
        }
    }
}
