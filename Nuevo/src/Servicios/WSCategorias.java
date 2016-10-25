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
public class WSCategorias {
    
    private Endpoint endpoint = null;
    private IControladorCategorias iccat = new ControladorCategorias();
    
    @WebMethod(exclude = true)
    public void publicar(){
        endpoint = Endpoint.publish("http://localhost:8810/categorias", this);
    }
    
    @WebMethod
    public ArrayList<DataCategoria> getCategoriasPadres(){
        try {
            return iccat.getCategoriasPadres();
        } catch (SQLException ex) {
            return new ArrayList();
        } catch (ClassNotFoundException ex) {
            return new ArrayList();
        }
    }
    
    @WebMethod
    public ArrayList getCategoriasRelacionadas(){       
        try {
            return iccat.getCategoriasRelacionadas();
        } catch (SQLException ex) {
            return new ArrayList();
        } catch (ClassNotFoundException ex) {
            return new ArrayList();
        }
    }
    
    @WebMethod
    public void deleteAllCategorias(){
        try {
            iccat.deleteAllCategorias();
        } catch (SQLException ex) {
            Logger.getLogger(WSCategorias.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WSCategorias.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @WebMethod
    public void insertCategoriasDePrueba(){
        try {
            iccat.insertCategoriasDePrueba();
        } catch (SQLException ex) {
            Logger.getLogger(WSCategorias.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WSCategorias.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
